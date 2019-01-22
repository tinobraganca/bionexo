package br.com.bionexo.service.impl;

import br.com.bionexo.service.UbsService;
import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.repository.UbsRepository;
import br.com.bionexo.service.dto.UbsDTO;
import br.com.bionexo.service.mapper.UbsMapper;

import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing TB_UBS.
 */
@Service
@Transactional
public class UbsServiceImpl implements UbsService {

    private final Logger LOG = LoggerFactory.getLogger(UbsServiceImpl.class);

    private final UbsRepository ubsRepository;

    private final UbsMapper ubsMapper;

    public UbsServiceImpl(UbsRepository UbsRepository, UbsMapper UbsMapper) {
        this.ubsRepository = UbsRepository;
        this.ubsMapper = UbsMapper;
    }

    /**
     * Save a tB_UBS.
     *
     * @param tB_UBSDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UbsDTO save(UbsDTO tB_UBSDTO) {
        LOG.debug("Request to save TB_UBS : {}", tB_UBSDTO);

        PersistentUbs tB_UBS = ubsMapper.toEntity(tB_UBSDTO);
        tB_UBS = ubsRepository.save(tB_UBS);
        return ubsMapper.toDto(tB_UBS);
    }
    @Override
    public void saveAll(List<PersistentUbs> ubsList) {
        LOG.debug("Salvando lista em banco");

    	ubsRepository.saveAll(ubsList);
    	LOG.debug("Lista salva no banco");
    }
    /**
     * Get all the tB_UBS.
     *
     * @return the list of entities
     */
//    @Override
//    @Transactional(readOnly = true)
//    public List<PersistentUbs> findAll() {
//        LOG.debug("Request to get all TB_UBS");
//        ubsRepository.findAll()
//        return ubsRepository.findAll().stream()
//            .map(ubsMapper::toDto)
//            .collect(Collectors.toCollection(LinkedList::new));
//    }
//    
    @Override
    @Transactional(readOnly = true)
    public List<PersistentUbs> findAll() {
        LOG.debug("Request to get all TB_UBS");
        return ubsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersistentUbs> findAllByLatLong(BigDecimal lat, BigDecimal longitude) {
    	return ubsRepository.findAllByLatAndLong(lat, longitude);
    }
    

    /**
     * Get one tB_UBS by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<UbsDTO> findOne(Long id) {
        LOG.debug("Request to get TB_UBS : {}", id);
        return ubsRepository.findById(id)
            .map(ubsMapper::toDto);
    }

    /**
     * Delete the tB_UBS by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete TB_UBS : {}", id);
        ubsRepository.deleteById(id);
    }
   
}
