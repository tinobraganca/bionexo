package br.com.bionexo.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.bionexo.service.UbsService;
import br.com.bionexo.web.rest.errors.BadRequestAlertException;
import br.com.bionexo.web.rest.util.HeaderUtil;
import br.com.bionexo.service.dto.UbsDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing TB_UBS.
 */
@RestController
@RequestMapping("/api")
public class TB_UBSResource {

    private final Logger log = LoggerFactory.getLogger(TB_UBSResource.class);

    private static final String ENTITY_NAME = "tB_UBS";

    private final UbsService tB_UBSService;

    public TB_UBSResource(UbsService tB_UBSService) {
        this.tB_UBSService = tB_UBSService;
    }

    /**
     * POST  /tb-ubs : Create a new tB_UBS.
     *
     * @param tB_UBSDTO the tB_UBSDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new tB_UBSDTO, or with status 400 (Bad Request) if the tB_UBS has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/tb-ubs")
    @Timed
    public ResponseEntity<UbsDTO> createTB_UBS(@Valid @RequestBody UbsDTO tB_UBSDTO) throws URISyntaxException {
        log.debug("REST request to save TB_UBS : {}", tB_UBSDTO);
        if (tB_UBSDTO.getId() != null) {
            throw new BadRequestAlertException("A new tB_UBS cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UbsDTO result = tB_UBSService.save(tB_UBSDTO);
        return ResponseEntity.created(new URI("/api/tb-ubs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /tb-ubs : Updates an existing tB_UBS.
     *
     * @param tB_UBSDTO the tB_UBSDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated tB_UBSDTO,
     * or with status 400 (Bad Request) if the tB_UBSDTO is not valid,
     * or with status 500 (Internal Server Error) if the tB_UBSDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/tb-ubs")
    @Timed
    public ResponseEntity<UbsDTO> updateTB_UBS(@Valid @RequestBody UbsDTO tB_UBSDTO) throws URISyntaxException {
        log.debug("REST request to update TB_UBS : {}", tB_UBSDTO);
        if (tB_UBSDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UbsDTO result = tB_UBSService.save(tB_UBSDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, tB_UBSDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /tb-ubs : get all the tB_UBS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of tB_UBS in body
     */
    @GetMapping("/tb-ubs")
    @Timed
    public List<UbsDTO> getAllTB_UBS() {
        log.debug("REST request to get all TB_UBS");
        return tB_UBSService.findAll();
    }

    /**
     * GET  /tb-ubs/:id : get the "id" tB_UBS.
     *
     * @param id the id of the tB_UBSDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the tB_UBSDTO, or with status 404 (Not Found)
     */
    @GetMapping("/tb-ubs/{id}")
    @Timed
    public ResponseEntity<UbsDTO> getTB_UBS(@PathVariable Long id) {
        log.debug("REST request to get TB_UBS : {}", id);
        Optional<UbsDTO> tB_UBSDTO = tB_UBSService.findOne(id);
        return ResponseUtil.wrapOrNotFound(tB_UBSDTO);
    }

    /**
     * DELETE  /tb-ubs/:id : delete the "id" tB_UBS.
     *
     * @param id the id of the tB_UBSDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/tb-ubs/{id}")
    @Timed
    public ResponseEntity<Void> deleteTB_UBS(@PathVariable Long id) {
        log.debug("REST request to delete TB_UBS : {}", id);
        tB_UBSService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
