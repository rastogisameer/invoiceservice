package sam.invoiceservice.idea;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("idea")
public class IdeaController {

    @GetMapping("{id}")
    public void Get(){

    }
}
