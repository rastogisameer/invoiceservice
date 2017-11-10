package sam.invoiceservice.idea;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("idea")
public class IdeaController {

    private final IdeaRepository ideaRepository;

    public IdeaController(IdeaRepository ideaRepository){
        this.ideaRepository = ideaRepository;
    }

    @GetMapping
    public List<IdeaInvoice> getAll(){

        return ideaRepository.readAll();
    }

    @GetMapping("{id}")
    public List<IdeaInvoice> get(@RequestParam long id){

        return ideaRepository.read(id);

    }
    @PostMapping
    public long post(@RequestBody IdeaInvoice inv){
        return  ideaRepository.create(inv);
    }
    @PutMapping
    public int put(@RequestParam long id, @RequestBody IdeaInvoice inv){
        return ideaRepository.update(id, inv);
    }

}
