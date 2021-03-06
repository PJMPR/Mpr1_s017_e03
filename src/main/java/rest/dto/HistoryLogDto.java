package rest.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import domain.model.Account;


@XmlRootElement
public class HistoryLogDto {
	
	private int id;
	
	private Date date;
	private double amount;
	private AccountDto from;
	private AccountDto to;
	private double rate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public AccountDto getFrom() {
		return from;
	}
	public void setFrom(AccountDto from) {
		this.from = from;
	}
	public AccountDto getTo() {
		return to;
	}
	public void setTo(AccountDto to) {
		this.to = to;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	

}
