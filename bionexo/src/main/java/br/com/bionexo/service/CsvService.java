package br.com.bionexo.service;

import java.io.InputStream;
import java.util.List;

import br.com.bionexo.domain.PersistentUbs;

public interface CsvService {
	
	public List<PersistentUbs> lerCsvUbs(InputStream is);

}
