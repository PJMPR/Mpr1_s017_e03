package dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.model.Account;
import domain.model.Person;

public abstract class AccountMapper implements IMapResultSetIntoEntity<Person>{

	public Account map1(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setAmount(rs.getDouble("account"));
		a.setCurrency(rs.getString("currency"));
		a.setPersonId(rs.getInt("personID"));
		return a;
	}

}
