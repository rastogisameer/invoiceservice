package sam.invoiceservice.ar;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ar")
public class ArController {

    private final ArRepository arRepository;

    public ArController(ArRepository arRepository){
        this.arRepository = arRepository;
    }

    @GetMapping
    public List<ArInvoice> getAll(){

        return arRepository.readAll();
    }

    @GetMapping("{id}")
    public List<ArInvoice> get(@RequestParam long id){

        return arRepository.read(id);

    }
    @PostMapping
    public long post(@RequestBody ArInvoice inv){
        return  arRepository.create(inv);
    }
    @PutMapping
    public int put(@RequestParam long id, @RequestBody ArInvoice inv){
        return arRepository.update(id, inv);
    }

}
