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
	
	public RepositoryCatalog(String url) {
		super();
		try {
			this.connection = DriverManager.getConnection(url);
			this.uow = new UnitOfWork(this.connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public RepositoryCatalog(IUnitOfWork uow, Connection connection) {
		super();
		this.uow = uow;
		this.connection = connection;
	}

	
	public IPersonRepository people() {
		return new PersonRepository(connection, new PersonMapper(), uow);
	}

	public IAccountRepository accounts() {
		return new AccountRepository(connection, new AccountMapper(), people(), uow);
	}

	public IEnumRepository dictionaries() {
		return new EnumDictionaryRepository(connection, new EnumDirectoryMapper(), uow);
	}

	public IHistoryRepository history() {
		return new HistoryLogRepository(connection, new HistoryLogMapper(), uow);
	}

	public void saveAndClose() {
		try{
		uow.commit();
		connection.close();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
	}

}
