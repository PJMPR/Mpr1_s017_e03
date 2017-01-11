package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.mappers.AccountMapper;
import dao.mappers.EnumDirectoryMapper;
import dao.mappers.HistoryLogMapper;
import dao.mappers.PersonMapper;
import dao.uow.IUnitOfWork;
import dao.uow.UnitOfWork;

public class RepositoryCatalog implements IRepositoryCatalog{

	IUnitOfWork uow;
	Connection connection;
	
	public RepositoryCatalog(String url) throws SQLException {
		super();
			this.connection = DriverManager.getConnection(url);
			this.uow = new UnitOfWork(this.connection);
	}
	
	public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
		super();
		this.uow = uow;
		this.connection = connection;
	}

	
	public IPersonRepository people() {
		return new PersonRepository(this.connection, new PersonMapper(), this.uow);
	}

	public IAccountRepository accounts() {
		return new AccountRepository(this.connection, new AccountMapper(), people(), this.uow);
	}

	public IEnumRepository dictionaries() {
		return new EnumDictionaryRepository(this.connection, new EnumDirectoryMapper(), this.uow);
	}

	public IHistoryRepository history() {
		return new HistoryLogRepository(this.connection, new HistoryLogMapper(), this.uow);
	}

	public void saveAndClose() {
		try{
		this.uow.commit();
		this.connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

	@Override
	public void save() {
		try {
			this.uow.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
