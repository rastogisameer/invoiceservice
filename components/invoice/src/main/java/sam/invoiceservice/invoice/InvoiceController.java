package sam.invoiceservice.invoice;

import org.springframework.web.bind.annotation.*;
import sam.invoiceservice.ar.ArController;
import sam.invoiceservice.ar.ArInvoice;
import sam.invoiceservice.idea.IdeaController;
import sam.invoiceservice.idea.IdeaInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    private IdeaController ideaController;
    private ArController arController;

    public InvoiceController(IdeaController ideaController, ArController arController) {
        this.ideaController = ideaController;
        this.arController = arController;
    }


    @GetMapping
    public List<Invoice> getAll() {

        List<Invoice> invoices = new ArrayList<Invoice>();

        List<IdeaInvoice> ideaInvoices = ideaController.getAll();
        List<ArInvoice> arInvoices = arController.getAll();

        Map<Long, ArInvoice> arMap = arInvoices.stream().collect(
                Collectors.toMap(x -> x.getInvoiceId(), x -> x));

        ideaInvoices.forEach(inv1 -> {

            long id1 = inv1.getInvoiceId();
            Invoice invoice = new Invoice();
            invoice.setInvoiceId(id1);
            invoice.setIdeaInvoice(inv1);

            invoice.setArInvoice(arMap.get(id1));

        });
        return invoices;
    }

    @GetMapping("{id}")
    public List<Invoice> get(@RequestParam long id) {

        List<Invoice> invoices = new ArrayList<Invoice>();

        IdeaInvoice ideaInvoice = ideaController.getAll().get(0);
        ArInvoice arInvoice = arController.getAll().get(0);

        long id1 = ideaInvoice.getInvoiceId();
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(id1);
        invoice.setIdeaInvoice(ideaInvoice);

        invoice.setArInvoice(arInvoice);

        return invoices;

    }

    @PostMapping
    public long post(@RequestBody Invoice inv) {

        long id = ideaController.post(inv.getIdeaInvoice());
        arController.post(inv.getArInvoice());

        return id;

    }

    @PutMapping
    public int put(@RequestParam long id, @RequestBody Invoice inv) {

        int numupdated = ideaController.put(id, inv.getIdeaInvoice());

        arController.put(id, inv.getArInvoice());
        return numupdated;
    }

}
