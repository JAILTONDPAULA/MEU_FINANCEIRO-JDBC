package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataBase.ExceptionDataBase;
import model.dao.TipoAcessoDao;
import model.entities.TipoAcesso;

public class TipoAcessoDaoJDBC implements TipoAcessoDao{

	private Connection conn;
	
	public TipoAcessoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Integer insert(TipoAcesso obj) {
		PreparedStatement query  = null;
		ResultSet 		  codigo = null;
		try {
			query = conn.prepareStatement("insert into mf_tipo_acesso "
										+ "(desc_acesso,nivel)"
										+ "values"
										+ "(?,?)",Statement.RETURN_GENERATED_KEYS);
			
			query.setString(1,obj.getDescAcesso());
			query.setString(2, obj.getNivel());
			
			query.executeUpdate();
			
			codigo = query.getGeneratedKeys();
			codigo.next();
			return codigo.getInt(1);
 
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}finally {
			close(query);
		}
	}

	@Override
	public void update(TipoAcesso obj) {
		PreparedStatement query  = null;
		Integer		      result = null;
		TipoAcesso		  acesso = null;
		try {
			query = conn.prepareStatement("update mf_tipo_acesso set  desc_acesso = ?, nivel= ?"
					+ "where cod_acesso = ?");
			
			query.setString(1,obj.getDescAcesso());
			query.setString(2, obj.getNivel());
			query.setInt(3, obj.getCodAcesso());
			
			result = query.executeUpdate();
			System.out.println("ROWS:"+result);

		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}finally {
			close(query);
		}
	}

	@Override
	public void deleteByCod(TipoAcesso obj) {
		PreparedStatement query  = null;
		ResultSet		  result = null;
		try {
			query = conn.prepareStatement("delete from mf_tipo_acesso "
										+ "where cod_acesso = ?");
			query.setInt(1, obj.getCodAcesso());
			Integer linhas = query.executeUpdate();

			System.out.println("Rows: "+linhas);
			
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}finally {
			close(query);
		}
	}

	@Override
	public TipoAcesso findByCod(Integer cod) {
		PreparedStatement query  = null;
		ResultSet		  result = null;
		TipoAcesso		  acesso = null;
		try {
			query = conn.prepareStatement("select * from mf_tipo_acesso "
					+ "where cod_acesso = ?");
			query.setInt(1, cod);
			result = query.executeQuery();
			if(result.next()) {
				acesso = instaciarTipoAcesso(result);
			}
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}finally {
			close(result);
			close(query);
		}

		return acesso;
	}

	@Override
	public List<TipoAcesso> findAll() {
		PreparedStatement query  = null;
		ResultSet		  result = null;
		List<TipoAcesso>  lista	 = new ArrayList<>();
		
		try {
			query = conn.prepareStatement("select * from mf_tipo_acesso ");
			result = query.executeQuery();
			while(result.next()) {
				TipoAcesso acesso = instaciarTipoAcesso(result);
				lista.add(acesso);
			}
			return lista;
		}catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}finally {
			close(result);
			close(query);
		}
	}
	
	private static void close(PreparedStatement obj) {
		try { obj.close(); }
		catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}
	}

	private static void close(ResultSet obj) {
		try { obj.close(); }
		catch(SQLException error) {
			throw new ExceptionDataBase(error.getMessage());
		}
	}
	
	private static TipoAcesso instaciarTipoAcesso(ResultSet rs) throws SQLException {
		TipoAcesso acesso = new TipoAcesso();
		acesso.setCodAcesso(rs.getInt("cod_acesso"));
		acesso.setDescAcesso(rs.getString("desc_acesso"));
		acesso.setNivel(rs.getString("nivel"));
		return acesso;
	}

}
