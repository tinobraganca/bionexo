package br.com.bionexo.domain;

public enum StatusUbsEnum {

	A(1, "Desempenho muito acima da média"), //
	B(2, "Desempenho acima da média"), //
	C(3, "Desempenho mediano ou  um pouco abaixo da média"); //

	private Integer codigo;
	private String descricao;

	StatusUbsEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static StatusUbsEnum obterPorCodigo(Integer codigo) {
		for (StatusUbsEnum tipo : StatusUbsEnum.values()) {
			if (tipo.getCodigo() == (codigo)) {
				return tipo;
			}
		}

		return null;
	}
	
	public static StatusUbsEnum obterPorDescricao(String descricao) {
		for (StatusUbsEnum tipo : StatusUbsEnum.values()) {
			if (tipo.getDescricao().equals(descricao)) {
				return tipo;
			}
		}

		return null;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
