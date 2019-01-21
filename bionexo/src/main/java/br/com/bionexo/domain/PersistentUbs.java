package br.com.bionexo.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A TB_UBS.
 */
@Entity
@Table(name = "tb_ubs")
public class PersistentUbs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "co_latitude")
	private String co_latitude;
	
	@NotNull
	@Column(name = "co_longitute")
	private String co_longitute;
	
	@NotNull
	@Column(name = "co_municipio")
	private Long co_municipio;
	
	@NotNull
	@Column(name = "co_cnes")
	private Long co_cnes;

	@NotNull
	@Column(name = "no_estabelecimento")
	private String no_estabelecimento;
	
	@NotNull
	@Column(name = "no_endereco", nullable = false)
	private String no_endereco;
	
	@NotNull
	@Column(name = "no_bairro")
	private String no_bairro;
	
	@NotNull
	@Column(name = "no_cidade")
	private String no_cidade;
	
	@NotNull
	@Column(name = "co_telefone")
	private String co_telefone;
	
	@NotNull
	@Column(name = "no_estrutra_fisica_ambiencia")
	private Long no_estrutra_fisica_ambiencia;
	
	@NotNull
	@Column(name = "no_adap_defic_fisic_idoso")
	private Long no_adap_defic_fisic_idoso;
	
	@NotNull
	@Column(name = "no_equipamentos")
	private Long no_equipamentos;
	
	@NotNull
	@Column(name = "no_medicamentos")
	private Long no_medicamentos;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCo_latitude() {
		return co_latitude;
	}

	public PersistentUbs co_latitude(String co_latitude) {
		this.co_latitude = co_latitude;
		return this;
	}

	public void setCo_latitude(String co_latitude) {
		this.co_latitude = co_latitude;
	}

	public String getCo_longitute() {
		return co_longitute;
	}

	public PersistentUbs co_longitute(String co_longitute) {
		this.co_longitute = co_longitute;
		return this;
	}

	public void setCo_longitute(String co_longitute) {
		this.co_longitute = co_longitute;
	}

	public Long getCo_municipio() {
		return co_municipio;
	}

	public PersistentUbs co_municipio(Long co_municipio) {
		this.co_municipio = co_municipio;
		return this;
	}

	public void setCo_municipio(Long co_municipio) {
		this.co_municipio = co_municipio;
	}

	public Long getCo_cnes() {
		return co_cnes;
	}

	public PersistentUbs co_cnes(Long co_cnes) {
		this.co_cnes = co_cnes;
		return this;
	}

	public void setCo_cnes(Long co_cnes) {
		this.co_cnes = co_cnes;
	}

	public String getNo_estabelecimento() {
		return no_estabelecimento;
	}

	public PersistentUbs no_estabelecimento(String no_estabelecimento) {
		this.no_estabelecimento = no_estabelecimento;
		return this;
	}

	public void setNo_estabelecimento(String no_estabelecimento) {
		this.no_estabelecimento = no_estabelecimento;
	}

	public String getNo_endereco() {
		return no_endereco;
	}

	public PersistentUbs no_endereco(String no_endereco) {
		this.no_endereco = no_endereco;
		return this;
	}

	public void setNo_endereco(String no_endereco) {
		this.no_endereco = no_endereco;
	}

	public String getNo_bairro() {
		return no_bairro;
	}

	public PersistentUbs no_bairro(String no_bairro) {
		this.no_bairro = no_bairro;
		return this;
	}

	public void setNo_bairro(String no_bairro) {
		this.no_bairro = no_bairro;
	}

	public String getNo_cidade() {
		return no_cidade;
	}

	public PersistentUbs no_cidade(String no_cidade) {
		this.no_cidade = no_cidade;
		return this;
	}

	public void setNo_cidade(String no_cidade) {
		this.no_cidade = no_cidade;
	}

	public String getCo_telefone() {
		return co_telefone;
	}

	public PersistentUbs co_telefone(String co_telefone) {
		this.co_telefone = co_telefone;
		return this;
	}

	public void setCo_telefone(String co_telefone) {
		this.co_telefone = co_telefone;
	}

	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PersistentUbs tB_UBS = (PersistentUbs) o;
		if (tB_UBS.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), tB_UBS.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}
//
//	@Override
//	public String toString() {
//		return "TB_UBS{" + "id=" + getId() + ", co_latitude='" + getCo_latitude() + "'" + ", co_longitute='"
//				+ getCo_longitute() + "'" + ", co_municipio=" + getCo_municipio() + ", co_cnes=" + getCo_cnes()
//				+ ", no_estabelecimento='" + getNo_estabelecimento() + "'" + ", no_endereco='" + getNo_endereco() + "'"
//				+ ", no_bairro='" + getNo_bairro() + "'" + ", no_cidade='" + getNo_cidade() + "'" + ", co_telefone='"
//				+ getCo_telefone() + "'" + ", no_estrutra_fisica_ambiencia='" + getNo_estrutra_fisica_ambiencia() + "'"
//				+ ", no_adap_defic_fisic_idoso='" + getNo_adap_defic_fisic_idoso() + "'" + ", no_equipamentos='"
//				+ getNo_equipamentos() + "'" + ", no_medicamentos='" + getNo_medicamentos() + "'" + "}";
//	}

	public Long getNo_estrutra_fisica_ambiencia() {
		return no_estrutra_fisica_ambiencia;
	}

	public void setNo_estrutra_fisica_ambiencia(Long no_estrutra_fisica_ambiencia) {
		this.no_estrutra_fisica_ambiencia = no_estrutra_fisica_ambiencia;
	}

	public Long getNo_adap_defic_fisic_idoso() {
		return no_adap_defic_fisic_idoso;
	}

	public void setNo_adap_defic_fisic_idoso(Long no_adap_defic_fisic_idoso) {
		this.no_adap_defic_fisic_idoso = no_adap_defic_fisic_idoso;
	}

	public Long getNo_equipamentos() {
		return no_equipamentos;
	}

	public void setNo_equipamentos(Long no_equipamentos) {
		this.no_equipamentos = no_equipamentos;
	}

	public Long getNo_medicamentos() {
		return no_medicamentos;
	}

	public void setNo_medicamentos(Long no_medicamentos) {
		this.no_medicamentos = no_medicamentos;
	}
}
