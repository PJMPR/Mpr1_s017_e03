package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Account;

public interface IMapResultSetIntoEntity<TEntity> {

	public TEntity map(ResultSet rs) throws SQLException;;


	public Account map1(ResultSet rs) throws SQLException;;
}