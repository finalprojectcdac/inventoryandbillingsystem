//Created by Vaibhav

package inb.models;

import java.util.List;

public class CResult {
	
	private int status;
	private Inventory content;
	private SupplierRecord contentsupplier;
	private List<SupplierRecord> supplierdtls;
	private RealTimeData rtd;
	private RetailPriceData contentRpd;
	private BillingObject bo;
	
	public CResult(int status, BillingObject bo, String reason) {
		super();
		this.status = status;
		this.bo = bo;
		this.reason = reason;
	}

	public BillingObject getBo() {
		return bo;
	}

	public void setBo(BillingObject bo) {
		this.bo = bo;
	}

	

	public CResult(int status, RetailPriceData contentRpd, String reason) {
		super();
		this.status = status;
		this.contentRpd = contentRpd;
		this.reason = reason;
	}
	public RetailPriceData getContentRpd() {
		return contentRpd;
	}

	public void setContentRpd(RetailPriceData contentRpd) {
		this.contentRpd = contentRpd;
	}
	private Invoices invoice;
	private String reason;
	private Invoices contentinvoice;
	

	
	
	


	public Invoices getContentinvoice() {
		return contentinvoice;
	}

	public void setContentinvoice(Invoices contentinvoice) {
		this.contentinvoice = contentinvoice;
	}

	public CResult(int status, String reason, Invoices contentinvoice) {
		super();
		this.status = status;
		this.reason = reason;
		this.contentinvoice = contentinvoice;
	}

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
		
		this.reason = reason;
	}

}
