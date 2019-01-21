package br.com.bionexo.service.impl;

import br.com.bionexo.service.UbsService;
import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.repository.UbsRepository;
import br.com.bionexo.service.dto.UbsDTO;
import br.com.bionexo.service.mapper.TB_UBSMapper;

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

    private final Logger log = LoggerFactory.getLogger(UbsServiceImpl.class);

    private final UbsRepository tB_UBSRepository;

    private final TB_UBSMapper tB_UBSMapper;

    public UbsServiceImpl(UbsRepository tB_UBSRepository, TB_UBSMapper tB_UBSMapper) {
        this.tB_UBSRepository = tB_UBSRepository;
        this.tB_UBSMapper = tB_UBSMapper;
    }

    /**
     * Save a tB_UBS.
     *
     * @param tB_UBSDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public UbsDTO save(UbsDTO tB_UBSDTO) {
        log.debug("Request to save TB_UBS : {}", tB_UBSDTO);

        PersistentUbs tB_UBS = tB_UBSMapper.toEntity(tB_UBSDTO);
        tB_UBS = tB_UBSRepository.save(tB_UBS);
        return tB_UBSMapper.toDto(tB_UBS);
    }

    /**
     * Get all the tB_UBS.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<UbsDTO> findAll() {
        log.debug("Request to get all TB_UBS");
        return tB_UBSRepository.findAll().stream()
            .map(tB_UBSMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
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
        log.debug("Request to get TB_UBS : {}", id);
        return tB_UBSRepository.findById(id)
            .map(tB_UBSMapper::toDto);
    }

    /**
     * Delete the tB_UBS by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TB_UBS : {}", id);
        tB_UBSRepository.deleteById(id);
    }
   
}
