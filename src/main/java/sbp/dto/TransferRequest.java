package sbp.dto;

import java.math.BigDecimal;

public class TransferRequest {
	
	
	private long senderAccountId;
	private long reciverAccountId;
	private BigDecimal amount;
	public long getSenderAccountId() {
		return senderAccountId;
	}
	public void setSenderAccountId(long senderAccountId) {
		this.senderAccountId = senderAccountId;
	}
	public long getReciverAccountId() {
		return reciverAccountId;
	}
	public void setReciverAccountId(long reciverAccountId) {
		this.reciverAccountId = reciverAccountId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	

}
