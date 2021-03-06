package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import dao.mappers.IMapResultSetIntoEntity;
import dao.uow.IUnitOfWork;
import domain.model.Account;
import domain.model.HistoryLog;

public class HistoryLogRepository extends RepositoryBase<HistoryLog> 
	implements IHistoryRepository {
	
	public HistoryLogRepository(Connection connection, 
			IMapResultSetIntoEntity<HistoryLog> mapper,
			IUnitOfWork uow) {
		super(connection, mapper,uow);
	}
	
	
	@Override
	protected String tableName() {
		return "historyLog";
	}

	@Override
	protected String createTableSql() {
		return "CREATE TABLE historyLog("
				+ "id bigint GENERATED BY DEFAULT AS IDENTITY,"
				+ "date DATE,"
				+ "amount DECIMAL(7,2),"
				+ "from_id BIGINT,"
				+ "to_id BIGINT,"
				+ "rate DECIMAL(7,2),"
				+ ")";
	}

	@Override
	protected String insertSql() {
		return "INSERT INTO historyLog(date,amount,from_id,to_id,rate) VALUES(?,?,?,?,?)";
	}

	@Override
	protected String deleteSql() {
		return "DELETE FROM historyLog WHERE id = ?";
	}

	@Override
	protected String updateSql() {
		return "UPDATE historyLog set date=?, amount=?, from_id=?, to_id=?, rate=? WHERE id=?";
	}

	@Override
	protected String selectByIdSql() {
		return "SELECT * FROM historyLog WHERE id=?";
	}

	@Override
	protected String selectAllSql() {
		return "SELECT * FROM historyLog";
	}

	@Override
	protected void setupInsert(HistoryLog entity) throws SQLException {
	
		insert.setDouble(2, entity.getAmount());
		insert.setInt(3, entity.getFrom().getId());
		insert.setInt(4, entity.getTo().getId());
		insert.setDouble(5, entity.getRate());
		insert.setDate(1,new Date(entity.getDate().getTime()));
		
	}

	@Override
	protected void setupUpdate(HistoryLog entity) throws SQLException {
		update.setString(1, entity.getDate().toString());
		update.setDouble(2, entity.getAmount());
		update.setInt(3, entity.getFrom().getId());
		update.setInt(4, entity.getTo().getId());
		update.setDouble(5, entity.getRate());
		
	}


	public List<HistoryLog> byAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
