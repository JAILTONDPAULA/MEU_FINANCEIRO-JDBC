package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFacory;
import model.dao.impl.TipoAcessoDaoJDBC;
import model.entities.TipoAcesso;

public class Program {

	public static void main(String[] args) {

		TipoAcessoDaoJDBC acesso = DaoFacory.createTipoAcesso();
		List<TipoAcesso>  lista	 = new ArrayList<>();
		TipoAcesso tipo1 = new TipoAcesso("Usuários Temporarios","2");
		System.out.println("=======================================INSERT");
		//adicionar 
		Integer novoCod = acesso.insert(tipo1);
		//consultar
		TipoAcesso nivel = acesso.findByCod(novoCod);
		System.out.println(nivel);
		System.out.println("=======================================UPDATE");
		//alterar
		nivel.setDescAcesso("Usuário Auditor");
		nivel.setNivel("1");
		
		acesso.update(nivel);
		nivel = acesso.findByCod(novoCod);
		System.out.println(nivel);
		System.out.println("=======================================LISTA");
		//listar acessos
		lista = acesso.findAll();
		for(TipoAcesso resultado : lista) {
			System.out.println(resultado);
		}
		//DELETE
		System.out.println("=======================================LISTA PÓS DELETE");
		acesso.deleteByCod(nivel);
		lista = acesso.findAll();
		for(TipoAcesso resultado : lista) {
			System.out.println(resultado);
		}

	}

}
