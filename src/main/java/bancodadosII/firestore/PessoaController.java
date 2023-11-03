package bancodadosII.firestore;

import bancodadosII.firestore.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api-firebase")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/savePessoa")
    public String salvarPessoa(@RequestBody Pessoa pessoa) {

        try {
            return pessoaService.saveProduct(pessoa);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
