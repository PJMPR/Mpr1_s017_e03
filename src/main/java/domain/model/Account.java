package domain.model;

import java.util.List;

public class Account implements IHaveId{
	
	private int id;
	private int personId;
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
