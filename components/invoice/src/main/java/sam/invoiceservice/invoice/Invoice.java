package sam.invoiceservice.invoice;

import sam.invoiceservice.ar.ArInvoice;
import sam.invoiceservice.idea.IdeaInvoice;

public class Invoice {

    public long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    private long invoiceId;

    private IdeaInvoice ideaInvoice;
    private ArInvoice arInvoice;

    public Invoice(){

    }
    public Invoice(long invoiceId, IdeaInvoice ideaInvoice, ArInvoice arInvoice) {
        this.invoiceId = invoiceId;
        this.ideaInvoice = ideaInvoice;
        this.arInvoice = arInvoice;
    }


    public IdeaInvoice getIdeaInvoice() {
        return ideaInvoice;
    }

    public void setIdeaInvoice(IdeaInvoice ideaInvoice) {
        this.ideaInvoice = ideaInvoice;
    }

    public ArInvoice getArInvoice() {
        return arInvoice;
    }

    public void setArInvoice(ArInvoice arInvoice) {
        this.arInvoice = arInvoice;
    }
}
