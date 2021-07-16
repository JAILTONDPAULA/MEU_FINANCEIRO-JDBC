package model.entities;

import java.io.Serializable;

public class TipoAcesso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer codAcesso;
	private String	descAcesso;
	private String	nivel;
	
	public TipoAcesso() {
		
	}

	public TipoAcesso(Integer codAcesso, String descAcesso,String nivel) {
		this.codAcesso  = codAcesso;
		this.descAcesso = descAcesso;
		this.nivel      = nivel;
	}

	public TipoAcesso(String descAcesso,String nivel) {
		this.descAcesso = descAcesso;
		this.nivel      = nivel;
	}

	
	public Integer getCodAcesso() {
		return codAcesso;
	}

	public void setCodAcesso(Integer codAcesso) {
		this.codAcesso = codAcesso;
	}

	public String getDescAcesso() {
		return descAcesso;
	}

	public void setDescAcesso(String descAcesso) {
		this.descAcesso = descAcesso;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAcesso == null) ? 0 : codAcesso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoAcesso other = (TipoAcesso) obj;
		if (codAcesso == null) {
			if (other.codAcesso != null)
				return false;
		} else if (!codAcesso.equals(other.codAcesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoAcesso [codAcesso=" + codAcesso + ", descAcesso=" + descAcesso + ", nivel=" + nivel + "]";
	}



	
	
	
	
}
