package rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

import domain.model.HistoryLog;
import domain.model.Person;

import java.util.List;


@XmlRootElement
public class AccountDto {
	
	private int id;
	private int personId;
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
