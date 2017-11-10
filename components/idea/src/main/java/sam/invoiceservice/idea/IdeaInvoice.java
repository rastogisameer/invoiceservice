package sam.invoiceservice.idea;

public class IdeaInvoice {

    private long invoiceId;
    private double originalAmount;
    private String payorName;

    public IdeaInvoice(long invoiceId, double originalAmount, String payorName) {
        this.invoiceId = invoiceId;
        this.originalAmount = originalAmount;
        this.payorName = payorName;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public String getPayorName() {
        return payorName;
    }

    public void setPayorName(String payorName) {
        this.payorName = payorName;
    }
}
