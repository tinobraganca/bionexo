package br.com.bionexo.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.bionexo.service.CsvService;

@EnableScheduling
@Component
public class CargaUbsTask {
	
	@Autowired
	private CsvService csvService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CargaUbsTask.class);

	@Autowired
	Environment env;
	@Autowired
	Properties properties;
	
	@Value("${spring.app.csv.file.path}")
	public String filePath3;
//	
//	@Value("${spring.app.csv.cron}")
//	public String cronTask;
	
	
	@Scheduled(cron = "* * 12 * * ?")
	public boolean cargaUbs() {
		LOG.info("Executando rotina de carga da planilha de Ubs...");
		System.out.println(filePath3);
		InputStream ExcelFileToRead;
		try {
			ExcelFileToRead = new FileInputStream(filePath3);
			csvService.lerCsvUbs(ExcelFileToRead);
			LOG.info("Fim da carga");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}