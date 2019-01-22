package br.com.bionexo.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.domain.StatusUbsEnum;
import br.com.bionexo.service.CsvService;

@Service
public class CsvServiceImpl implements CsvService {

	private static final Logger LOG = LoggerFactory.getLogger(CsvService.class);

	public List<PersistentUbs> lerCsvUbs(String is) {
//		XSSFWorkbook workbook;
		List<PersistentUbs> ubslst = new ArrayList<PersistentUbs>();
		long i = 0L;
		String line = "";
		String cvsSplitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(is), "UTF8"));
	            while ((line = br.readLine()) != null) {
	                // use comma as separator
	                String[] lineS = line.split(cvsSplitBy);
	                if(i != 0L) {
	                	LOG.debug(String.format("Lendo a linha: %s ",String.valueOf(i)));
		                PersistentUbs ubs = this.lerLinha(lineS);
		                LOG.debug(String.format("Objeto criado referente a linha: %s ",String.valueOf(i)));
		                ubslst.add(ubs);	
	                }
	                i++;

	            }

			}catch (IOException e) {
			LOG.error("Ocorreu um erro ao carregar a planilha");
			LOG.error(e.getMessage());
		}
		return ubslst;

	}

	private PersistentUbs lerLinha(String[] line) {
		PersistentUbs ubs = new PersistentUbs();
		
		ubs.setGeoCodeLat(getValueBigDecimal(line[0]));
		ubs.setGeoCodeLong(getValueBigDecimal(line[1]));
		ubs.setCo_municipio(getLongValue(line[2]));
		ubs.setCo_cnes(getLongValue(line[3]));
		ubs.setName(getValueString(line[4]));
		ubs.setAddress(getValueString(line[5]).trim());
		ubs.setNo_bairro(getValueString(line[6]).trim());
		ubs.setCity(getValueString(line[7]).trim());
		ubs.setPhone(getValueString(line[8]).trim());
		ubs.setSize(getEnumValue(getValueString(line[9]).trim()));
		ubs.setScoresAdaptationForSeniors(getEnumValue(getValueString(line[10]).trim()));
		ubs.setScoresMediceEquipment(getEnumValue(getValueString(line[11]).trim()));
		ubs.setScoresMedice(getEnumValue(getValueString(line[12]).trim()));

		return ubs;
	}

	private Long getEnumValue(String s) {
		StatusUbsEnum tipo = StatusUbsEnum.obterPorDescricao(s);
		return Long.valueOf(tipo.getCodigo());
	}

	private Long getLongValue(String s) {
		Long ret = 0L;
		try {
			ret = Long.valueOf(s);

		} catch (NumberFormatException e) {
			LOG.error("Ocorreu um erro no parse da coluna: {}", s);
			LOG.error(e.getMessage());
		}
		return ret;
	}
	
	private static BigDecimal getValueBigDecimal(String s) {
		return new BigDecimal(s);
	}

	private static String getValueString(String s) {
		String v = "Valor nao informado";
		if (s != null) {
			v = s.trim();
		} else {
			LOG.error("Cell is null");
		}
		return v;
		
	}

}
