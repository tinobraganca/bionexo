package br.com.bionexo.web.rest;

import br.com.bionexo.BionexoApp;

import br.com.bionexo.domain.PersistentUbs;
import br.com.bionexo.repository.UbsRepository;
import br.com.bionexo.service.UbsService;
import br.com.bionexo.service.dto.UbsDTO;
import br.com.bionexo.service.mapper.UbsMapper;
import br.com.bionexo.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static br.com.bionexo.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TB_UBSResource REST controller.
 *
 * @see UbsResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BionexoApp.class)
public class TB_UBSResourceIntTest {

	private static final String DEFAULT_CO_LATITUDE = "AAAAAAAAAA";
	private static final String UPDATED_CO_LATITUDE = "BBBBBBBBBB";

	private static final String DEFAULT_CO_LONGITUTE = "AAAAAAAAAA";
	private static final String UPDATED_CO_LONGITUTE = "BBBBBBBBBB";

	private static final Long DEFAULT_CO_MUNICIPIO = 1L;
	private static final Long UPDATED_CO_MUNICIPIO = 2L;

	private static final Long DEFAULT_CO_CNES = 1L;
	private static final Long UPDATED_CO_CNES = 2L;

	private static final String DEFAULT_NO_ESTABELECIMENTO = "AAAAAAAAAA";
	private static final String UPDATED_NO_ESTABELECIMENTO = "BBBBBBBBBB";

	private static final String DEFAULT_NO_ENDERECO = "AAAAAAAAAA";
	private static final String UPDATED_NO_ENDERECO = "BBBBBBBBBB";

	private static final String DEFAULT_NO_BAIRRO = "AAAAAAAAAA";
	private static final String UPDATED_NO_BAIRRO = "BBBBBBBBBB";

	private static final String DEFAULT_NO_CIDADE = "AAAAAAAAAA";
	private static final String UPDATED_NO_CIDADE = "BBBBBBBBBB";

	private static final String DEFAULT_CO_TELEFONE = "AAAAAAAAAA";
	private static final String UPDATED_CO_TELEFONE = "BBBBBBBBBB";

	private static final Long DEFAULT_NO_ESTRUTRA_FISICA_AMBIENCIA = Long.valueOf(111111);
	private static final Long UPDATED_NO_ESTRUTRA_FISICA_AMBIENCIA = Long.valueOf(22222);

	private static final Long DEFAULT_NO_ADAP_DEFIC_FISIC_IDOSO = Long.valueOf(111111);
	private static final Long UPDATED_NO_ADAP_DEFIC_FISIC_IDOSO = Long.valueOf(22222);

	private static final Long DEFAULT_NO_EQUIPAMENTOS = Long.valueOf(111111);
	private static final Long UPDATED_NO_EQUIPAMENTOS = Long.valueOf(22222);

	private static final Long DEFAULT_NO_MEDICAMENTOS = Long.valueOf(111111);
	private static final Long UPDATED_NO_MEDICAMENTOS = Long.valueOf(22222);

	@Autowired
	private UbsRepository tB_UBSRepository;

	@Autowired
	private UbsMapper tB_UBSMapper;

	@Autowired
	private UbsService tB_UBSService;

	@Autowired
	private MappingJackson2HttpMessageConverter jacksonMessageConverter;

	@Autowired
	private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

	@Autowired
	private ExceptionTranslator exceptionTranslator;

	@Autowired
	private EntityManager em;

	private MockMvc restTB_UBSMockMvc;

	private PersistentUbs tB_UBS;

//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        final TB_UBSResource tB_UBSResource = new TB_UBSResource(tB_UBSService);
//        this.restTB_UBSMockMvc = MockMvcBuilders.standaloneSetup(tB_UBSResource)
//            .setCustomArgumentResolvers(pageableArgumentResolver)
//            .setControllerAdvice(exceptionTranslator)
//            .setConversionService(createFormattingConversionService())
//            .setMessageConverters(jacksonMessageConverter).build();
//    }
//
//    /**
//     * Create an entity for this test.
//     *
//     * This is a static method, as tests for other entities might also need it,
//     * if they test an entity which requires the current entity.
//     */
//    public static PersistentUbs createEntity(EntityManager em) {
//        PersistentUbs tB_UBS = new PersistentUbs()
//            .co_latitude(DEFAULT_CO_LATITUDE)
//            .co_longitute(DEFAULT_CO_LONGITUTE)
//            .co_municipio(DEFAULT_CO_MUNICIPIO)
//            .co_cnes(DEFAULT_CO_CNES)
//            .no_estabelecimento(DEFAULT_NO_ESTABELECIMENTO)
//            .no_endereco(DEFAULT_NO_ENDERECO)
//            .no_bairro(DEFAULT_NO_BAIRRO)
//            .no_cidade(DEFAULT_NO_CIDADE)
//            .co_telefone(DEFAULT_CO_TELEFONE)
//            .no_estrutra_fisica_ambiencia(DEFAULT_NO_ESTRUTRA_FISICA_AMBIENCIA)
//            .no_adap_defic_fisic_idoso(DEFAULT_NO_ADAP_DEFIC_FISIC_IDOSO)
//            .no_equipamentos(DEFAULT_NO_EQUIPAMENTOS)
//            .no_medicamentos(DEFAULT_NO_MEDICAMENTOS);
//        return tB_UBS;
//    }

//    @Before
//    public void initTest() {
//        tB_UBS = createEntity(em);
//    }

//	@Test
//	@Transactional
//	public void createTB_UBS() throws Exception {
//		int databaseSizeBeforeCreate = tB_UBSRepository.findAll().size();
//
//		// Create the TB_UBS
//		UbsDTO tB_UBSDTO = tB_UBSMapper.toDto(tB_UBS);
//		restTB_UBSMockMvc.perform(post("/api/tb-ubs").contentType(TestUtil.APPLICATION_JSON_UTF8)
//				.content(TestUtil.convertObjectToJsonBytes(tB_UBSDTO))).andExpect(status().isCreated());
//
//		// Validate the TB_UBS in the database
//		List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
//		assertThat(tB_UBSList).hasSize(databaseSizeBeforeCreate + 1);
//		PersistentUbs testTB_UBS = tB_UBSList.get(tB_UBSList.size() - 1);
//		assertThat(testTB_UBS.getCo_latitude()).isEqualTo(DEFAULT_CO_LATITUDE);
//		assertThat(testTB_UBS.getCo_longitute()).isEqualTo(DEFAULT_CO_LONGITUTE);
//		assertThat(testTB_UBS.getCo_municipio()).isEqualTo(DEFAULT_CO_MUNICIPIO);
//		assertThat(testTB_UBS.getCo_cnes()).isEqualTo(DEFAULT_CO_CNES);
//		assertThat(testTB_UBS.getNo_estabelecimento()).isEqualTo(DEFAULT_NO_ESTABELECIMENTO);
//		assertThat(testTB_UBS.getNo_endereco()).isEqualTo(DEFAULT_NO_ENDERECO);
//		assertThat(testTB_UBS.getNo_bairro()).isEqualTo(DEFAULT_NO_BAIRRO);
//		assertThat(testTB_UBS.getNo_cidade()).isEqualTo(DEFAULT_NO_CIDADE);
//		assertThat(testTB_UBS.getCo_telefone()).isEqualTo(DEFAULT_CO_TELEFONE);
//		assertThat(testTB_UBS.getNo_estrutra_fisica_ambiencia()).isEqualTo(DEFAULT_NO_ESTRUTRA_FISICA_AMBIENCIA);
//		assertThat(testTB_UBS.getNo_adap_defic_fisic_idoso()).isEqualTo(DEFAULT_NO_ADAP_DEFIC_FISIC_IDOSO);
//		assertThat(testTB_UBS.getNo_equipamentos()).isEqualTo(DEFAULT_NO_EQUIPAMENTOS);
//		assertThat(testTB_UBS.getNo_medicamentos()).isEqualTo(DEFAULT_NO_MEDICAMENTOS);
//	}
//
//	@Test
//	@Transactional
//	public void createTB_UBSWithExistingId() throws Exception {
//		int databaseSizeBeforeCreate = tB_UBSRepository.findAll().size();
//
//		// Create the TB_UBS with an existing ID
//		tB_UBS.setId(1L);
//		UbsDTO tB_UBSDTO = tB_UBSMapper.toDto(tB_UBS);
//
//		// An entity with an existing ID cannot be created, so this API call must fail
//		restTB_UBSMockMvc.perform(post("/api/tb-ubs").contentType(TestUtil.APPLICATION_JSON_UTF8)
//				.content(TestUtil.convertObjectToJsonBytes(tB_UBSDTO))).andExpect(status().isBadRequest());
//
//		// Validate the TB_UBS in the database
//		List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
//		assertThat(tB_UBSList).hasSize(databaseSizeBeforeCreate);
//	}
//
//	@Test
//	@Transactional
//	public void checkNo_enderecoIsRequired() throws Exception {
//		int databaseSizeBeforeTest = tB_UBSRepository.findAll().size();
//		// set the field null
//		tB_UBS.setNo_endereco(null);
//
//		// Create the TB_UBS, which fails.
//		UbsDTO tB_UBSDTO = tB_UBSMapper.toDto(tB_UBS);
//
//		restTB_UBSMockMvc.perform(post("/api/tb-ubs").contentType(TestUtil.APPLICATION_JSON_UTF8)
//				.content(TestUtil.convertObjectToJsonBytes(tB_UBSDTO))).andExpect(status().isBadRequest());
//
//		List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
//		assertThat(tB_UBSList).hasSize(databaseSizeBeforeTest);
//	}
//
//	@Test
//	@Transactional
//	public void getAllTB_UBS() throws Exception {
//		// Initialize the database
//		tB_UBSRepository.saveAndFlush(tB_UBS);
//
//		// Get all the tB_UBSList
//		restTB_UBSMockMvc.perform(get("/api/tb-ubs?sort=id,desc")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(jsonPath("$.[*].id").value(hasItem(tB_UBS.getId().intValue())))
//				.andExpect(jsonPath("$.[*].co_latitude").value(hasItem(DEFAULT_CO_LATITUDE.toString())))
//				.andExpect(jsonPath("$.[*].co_longitute").value(hasItem(DEFAULT_CO_LONGITUTE.toString())))
//				.andExpect(jsonPath("$.[*].co_municipio").value(hasItem(DEFAULT_CO_MUNICIPIO.intValue())))
//				.andExpect(jsonPath("$.[*].co_cnes").value(hasItem(DEFAULT_CO_CNES.intValue())))
//				.andExpect(jsonPath("$.[*].no_estabelecimento").value(hasItem(DEFAULT_NO_ESTABELECIMENTO.toString())))
//				.andExpect(jsonPath("$.[*].no_endereco").value(hasItem(DEFAULT_NO_ENDERECO.toString())))
//				.andExpect(jsonPath("$.[*].no_bairro").value(hasItem(DEFAULT_NO_BAIRRO.toString())))
//				.andExpect(jsonPath("$.[*].no_cidade").value(hasItem(DEFAULT_NO_CIDADE.toString())))
//				.andExpect(jsonPath("$.[*].co_telefone").value(hasItem(DEFAULT_CO_TELEFONE.toString())))
//				.andExpect(jsonPath("$.[*].no_estrutra_fisica_ambiencia")
//						.value(hasItem(DEFAULT_NO_ESTRUTRA_FISICA_AMBIENCIA.toString())))
//				.andExpect(jsonPath("$.[*].no_adap_defic_fisic_idoso")
//						.value(hasItem(DEFAULT_NO_ADAP_DEFIC_FISIC_IDOSO.toString())))
//				.andExpect(jsonPath("$.[*].no_equipamentos").value(hasItem(DEFAULT_NO_EQUIPAMENTOS.toString())))
//				.andExpect(jsonPath("$.[*].no_medicamentos").value(hasItem(DEFAULT_NO_MEDICAMENTOS.toString())));
//	}
//
//	@Test
//	@Transactional
//	public void getTB_UBS() throws Exception {
//		// Initialize the database
//		tB_UBSRepository.saveAndFlush(tB_UBS);
//
//		// Get the tB_UBS
//		restTB_UBSMockMvc.perform(get("/api/tb-ubs/{id}", tB_UBS.getId())).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//				.andExpect(jsonPath("$.id").value(tB_UBS.getId().intValue()))
//				.andExpect(jsonPath("$.co_latitude").value(DEFAULT_CO_LATITUDE.toString()))
//				.andExpect(jsonPath("$.co_longitute").value(DEFAULT_CO_LONGITUTE.toString()))
//				.andExpect(jsonPath("$.co_municipio").value(DEFAULT_CO_MUNICIPIO.intValue()))
//				.andExpect(jsonPath("$.co_cnes").value(DEFAULT_CO_CNES.intValue()))
//				.andExpect(jsonPath("$.no_estabelecimento").value(DEFAULT_NO_ESTABELECIMENTO.toString()))
//				.andExpect(jsonPath("$.no_endereco").value(DEFAULT_NO_ENDERECO.toString()))
//				.andExpect(jsonPath("$.no_bairro").value(DEFAULT_NO_BAIRRO.toString()))
//				.andExpect(jsonPath("$.no_cidade").value(DEFAULT_NO_CIDADE.toString()))
//				.andExpect(jsonPath("$.co_telefone").value(DEFAULT_CO_TELEFONE.toString()))
//				.andExpect(jsonPath("$.no_estrutra_fisica_ambiencia")
//						.value(DEFAULT_NO_ESTRUTRA_FISICA_AMBIENCIA.toString()))
//				.andExpect(jsonPath("$.no_adap_defic_fisic_idoso").value(DEFAULT_NO_ADAP_DEFIC_FISIC_IDOSO.toString()))
//				.andExpect(jsonPath("$.no_equipamentos").value(DEFAULT_NO_EQUIPAMENTOS.toString()))
//				.andExpect(jsonPath("$.no_medicamentos").value(DEFAULT_NO_MEDICAMENTOS.toString()));
//	}
//
//	@Test
//	@Transactional
//	public void getNonExistingTB_UBS() throws Exception {
//		// Get the tB_UBS
//		restTB_UBSMockMvc.perform(get("/api/tb-ubs/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
//	}

//    @Test
//    @Transactional
//    public void updateTB_UBS() throws Exception {
//        // Initialize the database
//        tB_UBSRepository.saveAndFlush(tB_UBS);
//
//        int databaseSizeBeforeUpdate = tB_UBSRepository.findAll().size();
//
//        // Update the tB_UBS
//        PersistentUbs updatedTB_UBS = tB_UBSRepository.findById(tB_UBS.getId()).get();
//        // Disconnect from session so that the updates on updatedTB_UBS are not directly saved in db
//        em.detach(updatedTB_UBS);
//        updatedTB_UBS
//            .co_latitude(UPDATED_CO_LATITUDE)
//            .co_longitute(UPDATED_CO_LONGITUTE)
//            .co_municipio(UPDATED_CO_MUNICIPIO)
//            .co_cnes(UPDATED_CO_CNES)
//            .no_estabelecimento(UPDATED_NO_ESTABELECIMENTO)
//            .no_endereco(UPDATED_NO_ENDERECO)
//            .no_bairro(UPDATED_NO_BAIRRO)
//            .no_cidade(UPDATED_NO_CIDADE)
//            .co_telefone(UPDATED_CO_TELEFONE)
//            .no_estrutra_fisica_ambiencia(UPDATED_NO_ESTRUTRA_FISICA_AMBIENCIA)
//            .no_adap_defic_fisic_idoso(UPDATED_NO_ADAP_DEFIC_FISIC_IDOSO)
//            .no_equipamentos(UPDATED_NO_EQUIPAMENTOS)
//            .no_medicamentos(UPDATED_NO_MEDICAMENTOS);
//        UbsDTO tB_UBSDTO = tB_UBSMapper.toDto(updatedTB_UBS);
//
//        restTB_UBSMockMvc.perform(put("/api/tb-ubs")
//            .contentType(TestUtil.APPLICATION_JSON_UTF8)
//            .content(TestUtil.convertObjectToJsonBytes(tB_UBSDTO)))
//            .andExpect(status().isOk());
//
//        // Validate the TB_UBS in the database
//        List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
//        assertThat(tB_UBSList).hasSize(databaseSizeBeforeUpdate);
//        PersistentUbs testTB_UBS = tB_UBSList.get(tB_UBSList.size() - 1);
//        assertThat(testTB_UBS.getCo_latitude()).isEqualTo(UPDATED_CO_LATITUDE);
//        assertThat(testTB_UBS.getCo_longitute()).isEqualTo(UPDATED_CO_LONGITUTE);
//        assertThat(testTB_UBS.getCo_municipio()).isEqualTo(UPDATED_CO_MUNICIPIO);
//        assertThat(testTB_UBS.getCo_cnes()).isEqualTo(UPDATED_CO_CNES);
//        assertThat(testTB_UBS.getNo_estabelecimento()).isEqualTo(UPDATED_NO_ESTABELECIMENTO);
//        assertThat(testTB_UBS.getNo_endereco()).isEqualTo(UPDATED_NO_ENDERECO);
//        assertThat(testTB_UBS.getNo_bairro()).isEqualTo(UPDATED_NO_BAIRRO);
//        assertThat(testTB_UBS.getNo_cidade()).isEqualTo(UPDATED_NO_CIDADE);
//        assertThat(testTB_UBS.getCo_telefone()).isEqualTo(UPDATED_CO_TELEFONE);
//        assertThat(testTB_UBS.getNo_estrutra_fisica_ambiencia()).isEqualTo(UPDATED_NO_ESTRUTRA_FISICA_AMBIENCIA);
//        assertThat(testTB_UBS.getNo_adap_defic_fisic_idoso()).isEqualTo(UPDATED_NO_ADAP_DEFIC_FISIC_IDOSO);
//        assertThat(testTB_UBS.getNo_equipamentos()).isEqualTo(UPDATED_NO_EQUIPAMENTOS);
//        assertThat(testTB_UBS.getNo_medicamentos()).isEqualTo(UPDATED_NO_MEDICAMENTOS);
//    }

	@Test
	@Transactional
	public void updateNonExistingTB_UBS() throws Exception {
		int databaseSizeBeforeUpdate = tB_UBSRepository.findAll().size();

		// Create the TB_UBS
		UbsDTO tB_UBSDTO = tB_UBSMapper.toDto(tB_UBS);

		// If the entity doesn't have an ID, it will throw BadRequestAlertException
		restTB_UBSMockMvc.perform(put("/api/tb-ubs").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(tB_UBSDTO))).andExpect(status().isBadRequest());

		// Validate the TB_UBS in the database
		List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
		assertThat(tB_UBSList).hasSize(databaseSizeBeforeUpdate);
	}

	@Test
	@Transactional
	public void deleteTB_UBS() throws Exception {
		// Initialize the database
		tB_UBSRepository.saveAndFlush(tB_UBS);

		int databaseSizeBeforeDelete = tB_UBSRepository.findAll().size();

		// Get the tB_UBS
		restTB_UBSMockMvc.perform(delete("/api/tb-ubs/{id}", tB_UBS.getId()).accept(TestUtil.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());

		// Validate the database is empty
		List<PersistentUbs> tB_UBSList = tB_UBSRepository.findAll();
		assertThat(tB_UBSList).hasSize(databaseSizeBeforeDelete - 1);
	}

	@Test
	@Transactional
	public void equalsVerifier() throws Exception {
		TestUtil.equalsVerifier(PersistentUbs.class);
		PersistentUbs tB_UBS1 = new PersistentUbs();
		tB_UBS1.setId(1L);
		PersistentUbs tB_UBS2 = new PersistentUbs();
		tB_UBS2.setId(tB_UBS1.getId());
		assertThat(tB_UBS1).isEqualTo(tB_UBS2);
		tB_UBS2.setId(2L);
		assertThat(tB_UBS1).isNotEqualTo(tB_UBS2);
		tB_UBS1.setId(null);
		assertThat(tB_UBS1).isNotEqualTo(tB_UBS2);
	}

	@Test
	@Transactional
	public void dtoEqualsVerifier() throws Exception {
		TestUtil.equalsVerifier(UbsDTO.class);
		UbsDTO tB_UBSDTO1 = new UbsDTO();
		tB_UBSDTO1.setId(1L);
		UbsDTO tB_UBSDTO2 = new UbsDTO();
		assertThat(tB_UBSDTO1).isNotEqualTo(tB_UBSDTO2);
		tB_UBSDTO2.setId(tB_UBSDTO1.getId());
		assertThat(tB_UBSDTO1).isEqualTo(tB_UBSDTO2);
		tB_UBSDTO2.setId(2L);
		assertThat(tB_UBSDTO1).isNotEqualTo(tB_UBSDTO2);
		tB_UBSDTO1.setId(null);
		assertThat(tB_UBSDTO1).isNotEqualTo(tB_UBSDTO2);
	}

	@Test
	@Transactional
	public void testEntityFromId() {
		assertThat(tB_UBSMapper.fromId(42L).getId()).isEqualTo(42);
		assertThat(tB_UBSMapper.fromId(null)).isNull();
	}
}
