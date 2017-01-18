package domain.model;

import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name = "account.all", query = "SELECT a FROM Account a"),
	@NamedQuery(name = "account.id", query = "FROM Account a where a.id=:accountId"),
	@NamedQuery(name = "account.id", query = "SELECT a FROM Account a where a.personid=:personId")
})
public class Account implements IHaveId{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int personId;
	@ManyToOne
	private Person person;
	
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	private double amount;
	private String currency;
	private List<HistoryLog> history;
	
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public List<HistoryLog> getHistory() {
		return history;
	}
	public void setHistory(List<HistoryLog> history) {
		this.history = history;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
