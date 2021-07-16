package model.dao;

import java.util.List;

import model.entities.Acesso;

public interface AcessoDao {
	void insert(Acesso obj);
	void update(Acesso obj);
	void deleteByCod(Acesso obj);
	Acesso findByCod(Integer cod);
	List<Acesso> findAll();
}
