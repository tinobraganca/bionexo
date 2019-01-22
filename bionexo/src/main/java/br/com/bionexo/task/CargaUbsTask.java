package br.com.bionexo.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.repository.UbsRepository;
import br.com.bionexo.service.CsvService;
import br.com.bionexo.service.UbsService;

@EnableScheduling
@Component
public class CargaUbsTask {
	
	@Autowired
	private CsvService csvService;

	@Autowired
	private UbsService ubsService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CargaUbsTask.class);

	@Autowired
	Environment env;
	
	@Autowired
	Properties properties;
	
	@Value("${spring.app.csv.file.path}")
	public String filePath;

	@Scheduled(cron = "* * 12 * * ?")
	public boolean cargaUbs() {
		LOG.info("Executando rotina de carga da planilha de Ubs...");
		try {
			List<PersistentUbs> lstUbs = csvService.lerCsvUbs(filePath);
			ubsService.saveAll(lstUbs);
			LOG.info("Fim da carga");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
		
	}
}
