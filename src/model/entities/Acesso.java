package model.entities;

import java.io.Serializable;
import java.util.Date;

import enumuration.Sexo;

public class Acesso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer codLogin;
	private String  nomOperador;
	private String  eMail;
	private String  login;
	private Date	nascido;
	private Sexo	sexo;
	private String  senha;
	private TipoAcesso codAcesso;
	
	public Acesso() {
		
	}

	public Acesso(Integer codLogin, String nomOperador, String eMail, String login, Date nascido, Sexo sexo,
			String senha, TipoAcesso codAcesso) {

		this.codLogin = codLogin;
		this.nomOperador = nomOperador;
		this.eMail = eMail;
		this.login = login;
		this.nascido = nascido;
		this.sexo = sexo;
		this.senha = senha;
		this.codAcesso = codAcesso;
	}

	public Integer getCodLogin() {
		return codLogin;
	}

	public void setCodLogin(Integer codLogin) {
		this.codLogin = codLogin;
	}

	public String getNomOperador() {
		return nomOperador;
	}

	public void setNomOperador(String nomOperador) {
		this.nomOperador = nomOperador;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getNascido() {
		return nascido;
	}

	public void setNascido(Date nascido) {
		this.nascido = nascido;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoAcesso getCodAcesso() {
		return codAcesso;
	}

	public void setCodAcesso(TipoAcesso codAcesso) {
		this.codAcesso = codAcesso;
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
		Acesso other = (Acesso) obj;
		if (codAcesso == null) {
			if (other.codAcesso != null)
				return false;
		} else if (!codAcesso.equals(other.codAcesso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Acesso [codLogin=" + codLogin + ", nomOperador=" + nomOperador + ", eMail=" + eMail + ", login=" + login
				+ ", nascido=" + nascido + ", sexo=" + sexo + ", senha=" + senha + ", codAcesso=" + codAcesso + "]";
	}
	
	
	
	
	
}
