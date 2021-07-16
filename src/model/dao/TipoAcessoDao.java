package model.dao;

import java.util.List;

import model.entities.TipoAcesso;

public interface TipoAcessoDao {
	Integer insert(TipoAcesso obj);
	void update(TipoAcesso obj);
	void deleteByCod(TipoAcesso obj);
	TipoAcesso findByCod(Integer cod);
	List<TipoAcesso> findAll();
}
