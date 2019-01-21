package br.com.bionexo.service;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.service.dto.UbsDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing TB_UBS.
 */
public interface UbsService {

    /**
     * Save a tB_UBS.
     *
     * @param tB_UBSDTO the entity to save
     * @return the persisted entity
     */
    UbsDTO save(UbsDTO tB_UBSDTO);

    /**
     * Get all the tB_UBS.
     *
     * @return the list of entities
     */
    List<PersistentUbs> findAll();


    /**
     * Get the "id" tB_UBS.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<UbsDTO> findOne(Long id);

    /**
     * Delete the "id" tB_UBS.
     *
     * @param id the id of the entity
     */
    void delete(Long id);

	void saveAll(List<PersistentUbs> ubsList);
}
