package domain.model;

import java.util.Date;

public class HistoryLog {
	
	private int idHistoryLog;
	private int idWalletOperation;
	private float from;
	private float to;
	private Date date;
	private float amount;
	private float rate;
	
	public int getIdHistoryLog() {
		return idHistoryLog;
	}
	public void setIdHistoryLog(int idHistoryLog) {
		this.idHistoryLog = idHistoryLog;
	}
	public int getIdWalletOperation() {
		return idWalletOperation;
	}
	public void setIdWalletOperation(int idWalletOperation) {
		this.idWalletOperation = idWalletOperation;
	}
	public float getFrom() {
		return from;
	}
	public void setFrom(float from) {
		this.from = from;
	}
	public float getTo() {
		return to;
	}
	public void setTo(float to) {
		this.to = to;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	
	

}