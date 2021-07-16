package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.AcessoDao;
import model.entities.Acesso;

public class AcessoDaoJDBC implements AcessoDao{
	
	private Connection conn;
	
	public AcessoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Acesso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Acesso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByCod(Acesso obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Acesso findByCod(Integer cod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acesso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
