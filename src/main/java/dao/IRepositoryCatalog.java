package dao;

public interface IRepositoryCatalog {

	public IPersonRepository people();
	public IAccountRepository accounts();
	public IEnumRepository dictionaries();
	public IHistoryRepository history();
	public void save();
	public void saveAndClose();
	
}
