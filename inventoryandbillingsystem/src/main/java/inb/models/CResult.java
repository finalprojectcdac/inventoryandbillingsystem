//Created by Vaibhav

package inb.models;

import java.util.List;

public class CResult {
	
	private int status;
	private Inventory content;
	private SupplierRecord contentsupplier;
	private List<SupplierRecord> supplierdtls;
	private RealTimeData rtd;
	
	private Invoices contantinvoice;
	private String reason;
	
	
	
	public CResult(int status, RealTimeData rtd, String reason) {
		super();
		this.status = status;
		this.rtd = rtd;
		this.reason = reason;
	}
	
	public CResult(int status, List<SupplierRecord> supplierdtls, String reason) {
		super();
		this.status = status;
		this.supplierdtls = supplierdtls;
		this.reason = reason;
	}
	public Invoices getInvoice() {
		return contantinvoice;
	}
	public void setInvoice(Invoices invoice) {
		this.contantinvoice = invoice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Inventory getContent() {
		return content;
	}
	public void setContent(Inventory content) {
		this.content = content;
	}
	
	public List<SupplierRecord> getSupplierdtls() {
		return supplierdtls;
	}
	public void setSupplierdtls(List<SupplierRecord> supplierdtls) {
		this.supplierdtls = supplierdtls;
	}
	
	public CResult(int status, SupplierRecord contentsupplier, String reason) {
		super();
		this.status = status;
		this.contentsupplier = contentsupplier;
		this.reason = reason;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public SupplierRecord getContentsupplier() {
		return contentsupplier;
	}
	public void setContentsupplier(SupplierRecord contentsupplier) {
		this.contentsupplier = contentsupplier;
	}
	
	public RealTimeData getRtd() {
		return rtd;
	}

	public void setRtd(RealTimeData rtd) {
		this.rtd = rtd;
	}

	public CResult() {
		
	}
	public CResult(int status, Inventory content, String reason) {

		this.status = status;
		this.content = content;
		this.reason = reason;
	}
	public CResult(int status, String reason) {
		super();
		this.status = status;
		this.reason = reason;
	}
	public CResult(int status, Invoices invoice, String reason) {
		super();
		this.status = status;
		this.contantinvoice = invoice;
		this.reason = reason;
	}

	public void setContentInvoices(Invoices content) {
		// TODO Auto-generated method stub
		this.contantinvoice =content;
	}
	
}