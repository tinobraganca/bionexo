package br.com.bionexo.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.math.BigDecimal;
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
	private BigDecimal geoCodeLat;
	
	@NotNull
	@Column(name = "co_longitute")
	private BigDecimal geoCodeLong;
	
	@NotNull
	@Column(name = "co_municipio")
	private Long co_municipio;
	
	@NotNull
	@Column(name = "co_cnes")
	private Long co_cnes;

	@NotNull
	@Column(name = "no_estabelecimento")
	private String name;
	
	@NotNull
	@Column(name = "no_endereco", nullable = false)
	private String address;
	
	@NotNull
	@Column(name = "no_bairro")
	private String no_bairro;
	
	@NotNull
	@Column(name = "no_cidade")
	private String city;
	
	@NotNull
	@Column(name = "co_telefone")
	private String phone;
	
	@NotNull
	@Column(name = "no_estrutra_fisica_ambiencia")
	private Long size;
	
	@NotNull
	@Column(name = "no_adap_defic_fisic_idoso")
	private Long scoresAdaptationForSeniors;
	
	@NotNull
	@Column(name = "no_equipamentos")
	private Long scoresMediceEquipment;
	
	@NotNull
	@Column(name = "no_medicamentos")
	private Long scoresMedice;

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getScoresAdaptationForSeniors() {
		return scoresAdaptationForSeniors;
	}

	public void setScoresAdaptationForSeniors(Long scoresAdaptationForSeniors) {
		this.scoresAdaptationForSeniors = scoresAdaptationForSeniors;
	}

	public Long getScoresMediceEquipment() {
		return scoresMediceEquipment;
	}

	public void setScoresMediceEquipment(Long scoresMediceEquipment) {
		this.scoresMediceEquipment = scoresMediceEquipment;
	}

	public Long getScoresMedice() {
		return scoresMedice;
	}

	public void setScoresMedice(Long scoresMedice) {
		this.scoresMedice = scoresMedice;
	}

	public BigDecimal getGeoCodeLat() {
		return geoCodeLat;
	}

	public void setGeoCodeLat(BigDecimal geoCodeLat) {
		this.geoCodeLat = geoCodeLat;
	}

	public BigDecimal getGeoCodeLong() {
		return geoCodeLong;
	}

	public void setGeoCodeLong(BigDecimal geoCodeLong) {
		this.geoCodeLong = geoCodeLong;
	}

}
