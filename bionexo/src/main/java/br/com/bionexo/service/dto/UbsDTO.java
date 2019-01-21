package br.com.bionexo.service.dto;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the TB_UBS entity.
 */
public class UbsDTO implements Serializable {

    private Long id;

    private String co_latitude;

    private String co_longitute;

    private Long co_municipio;

    private Long co_cnes;

    private String no_estabelecimento;

    @NotNull
    private String no_endereco;

    private String no_bairro;

    private String no_cidade;

    private String co_telefone;

    private String no_estrutra_fisica_ambiencia;

    private String no_adap_defic_fisic_idoso;

    private String no_equipamentos;

    private String no_medicamentos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCo_latitude() {
        return co_latitude;
    }

    public void setCo_latitude(String co_latitude) {
        this.co_latitude = co_latitude;
    }

    public String getCo_longitute() {
        return co_longitute;
    }

    public void setCo_longitute(String co_longitute) {
        this.co_longitute = co_longitute;
    }

    public Long getCo_municipio() {
        return co_municipio;
    }

    public void setCo_municipio(Long co_municipio) {
        this.co_municipio = co_municipio;
    }

    public Long getCo_cnes() {
        return co_cnes;
    }

    public void setCo_cnes(Long co_cnes) {
        this.co_cnes = co_cnes;
    }

    public String getNo_estabelecimento() {
        return no_estabelecimento;
    }

    public void setNo_estabelecimento(String no_estabelecimento) {
        this.no_estabelecimento = no_estabelecimento;
    }

    public String getNo_endereco() {
        return no_endereco;
    }

    public void setNo_endereco(String no_endereco) {
        this.no_endereco = no_endereco;
    }

    public String getNo_bairro() {
        return no_bairro;
    }

    public void setNo_bairro(String no_bairro) {
        this.no_bairro = no_bairro;
    }

    public String getNo_cidade() {
        return no_cidade;
    }

    public void setNo_cidade(String no_cidade) {
        this.no_cidade = no_cidade;
    }

    public String getCo_telefone() {
        return co_telefone;
    }

    public void setCo_telefone(String co_telefone) {
        this.co_telefone = co_telefone;
    }

    public String getNo_estrutra_fisica_ambiencia() {
        return no_estrutra_fisica_ambiencia;
    }

    public void setNo_estrutra_fisica_ambiencia(String no_estrutra_fisica_ambiencia) {
        this.no_estrutra_fisica_ambiencia = no_estrutra_fisica_ambiencia;
    }

    public String getNo_adap_defic_fisic_idoso() {
        return no_adap_defic_fisic_idoso;
    }

    public void setNo_adap_defic_fisic_idoso(String no_adap_defic_fisic_idoso) {
        this.no_adap_defic_fisic_idoso = no_adap_defic_fisic_idoso;
    }

    public String getNo_equipamentos() {
        return no_equipamentos;
    }

    public void setNo_equipamentos(String no_equipamentos) {
        this.no_equipamentos = no_equipamentos;
    }

    public String getNo_medicamentos() {
        return no_medicamentos;
    }

    public void setNo_medicamentos(String no_medicamentos) {
        this.no_medicamentos = no_medicamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UbsDTO tB_UBSDTO = (UbsDTO) o;
        if (tB_UBSDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tB_UBSDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TB_UBSDTO{" +
            "id=" + getId() +
            ", co_latitude='" + getCo_latitude() + "'" +
            ", co_longitute='" + getCo_longitute() + "'" +
            ", co_municipio=" + getCo_municipio() +
            ", co_cnes=" + getCo_cnes() +
            ", no_estabelecimento='" + getNo_estabelecimento() + "'" +
            ", no_endereco='" + getNo_endereco() + "'" +
            ", no_bairro='" + getNo_bairro() + "'" +
            ", no_cidade='" + getNo_cidade() + "'" +
            ", co_telefone='" + getCo_telefone() + "'" +
            ", no_estrutra_fisica_ambiencia='" + getNo_estrutra_fisica_ambiencia() + "'" +
            ", no_adap_defic_fisic_idoso='" + getNo_adap_defic_fisic_idoso() + "'" +
            ", no_equipamentos='" + getNo_equipamentos() + "'" +
            ", no_medicamentos='" + getNo_medicamentos() + "'" +
            "}";
    }
}
