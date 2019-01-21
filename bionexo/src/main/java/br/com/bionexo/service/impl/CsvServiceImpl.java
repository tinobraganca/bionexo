package br.com.bionexo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.domain.StatusUbsEnum;
import br.com.bionexo.service.CsvService;

@Service
public class CsvServiceImpl implements CsvService {

	private static final Logger LOG = LoggerFactory.getLogger(CsvService.class);

	public List<PersistentUbs> lerCsvUbs(InputStream is) {
		XSSFWorkbook workbook;
		List<PersistentUbs> ubslst = new ArrayList<PersistentUbs>();
		try {
			workbook = new XSSFWorkbook(is);
			FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(workbook);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> ite = sheet.rowIterator();
			long i = 0L;
			while (ite.hasNext()) {
				Row row = ite.next();
				if (row.getRowNum() == 0) {
					continue; // Pula linha header
				}

				LOG.debug(String.format("Lendo a linha: %s ",String.valueOf(i)));
				PersistentUbs ubs = this.lerLinha(row);
				LOG.debug(String.format("Objeto criado referente a linha: %s ",String.valueOf(i)));
				i++;
				ubslst.add(ubs);
			}
		} catch (IOException e) {
			LOG.error("Ocorreu um erro ao carregar a planilha");
			LOG.error(e.getMessage());
		}
		return ubslst;

	}

	private PersistentUbs lerLinha(Row row) {
		PersistentUbs ubs = new PersistentUbs();

		ubs.setCo_latitude(getCellValueString(row.getCell(0)).trim());
		ubs.setCo_longitute(getCellValueString(row.getCell(1)).trim());
		ubs.setCo_municipio(getLongValue(row.getCell(2)));
		ubs.setCo_cnes(getLongValue(row.getCell(3)));
		ubs.setNo_estabelecimento(getCellValueString(row.getCell(4)).trim());
		ubs.setNo_endereco(getCellValueString(row.getCell(5)).trim());
		ubs.setNo_bairro(getCellValueString(row.getCell(6)).trim());
		ubs.setNo_cidade(getCellValueString(row.getCell(7)).trim());
		ubs.setCo_telefone(getCellValueString(row.getCell(8)).trim());
		ubs.setNo_estrutra_fisica_ambiencia(getEnumValue(getCellValueString(row.getCell(9)).trim()));
		ubs.setNo_adap_defic_fisic_idoso(getEnumValue(getCellValueString(row.getCell(10)).trim()));
		ubs.setNo_equipamentos(getEnumValue(getCellValueString(row.getCell(11)).trim()));
		ubs.setNo_medicamentos(getEnumValue(getCellValueString(row.getCell(12)).trim()));

		return ubs;
	}

	private Long getEnumValue(String s) {
		StatusUbsEnum tipo = StatusUbsEnum.obterPorDescricao(s);
		return Long.valueOf(tipo.getCodigo());
	}

	private Long getLongValue(Cell c) {
		Long ret = 0L;
		try {
			ret = (long) c.getNumericCellValue();

		} catch (NumberFormatException e) {
			LOG.error("Ocorreu um erro no parse da coluna: ", c.getRow());
			LOG.error(e.getMessage());
		}
		return ret;
	}

	private static String getCellValueString(Cell c) {
		String value = "";
		if (c != null) {
			switch (c.getCellType()) {
			case Cell.CELL_TYPE_BOOLEAN:
				value = String.valueOf(c.getBooleanCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				value = BigDecimal.valueOf(c.getNumericCellValue()).toPlainString();
				break;
			case Cell.CELL_TYPE_STRING:
				value = String.valueOf(c.getStringCellValue());
				break;
			case Cell.CELL_TYPE_FORMULA:
				value = String.valueOf(c.getCellFormula());
				break;
			case Cell.CELL_TYPE_BLANK:
				value = "";
				break;
			}
		} else {
			LOG.error("Cell is null");
		}
		return value.trim();
	}

}
