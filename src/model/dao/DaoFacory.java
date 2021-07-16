package model.dao;

import dataBase.DataBase;
import model.dao.impl.TipoAcessoDaoJDBC;

public class DaoFacory {
	
	public static TipoAcessoDaoJDBC createTipoAcesso() {
		return new TipoAcessoDaoJDBC(DataBase.connect());
	}
	
}
