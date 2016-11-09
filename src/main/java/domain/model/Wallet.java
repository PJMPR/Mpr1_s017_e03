package domain.model;

public class Wallet {
	
	private int idWallet;
	private String currency;
	private float asset;
	private int history;
	
	public int getIdWallet() {
		return idWallet;
	}
	public void setIdWallet(int idWallet) {
		this.idWallet = idWallet;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public float getAsset() {
		return asset;
	}
	public void setAsset(float asset) {
		this.asset = asset;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}

}