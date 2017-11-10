package sam.invoiceservice.ar;

public class ArInvoice {

    private long invoiceId;
    private double paymentAmount;
    private String payorName;

    public ArInvoice(long invoiceId, double paymentAmount, String payorName) {
        this.invoiceId = invoiceId;
        this.paymentAmount = paymentAmount;
        this.payorName = payorName;
    }

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPayorName() {
        return payorName;
    }

    public void setPayorName(String payorName) {
        this.payorName = payorName;
    }
}
