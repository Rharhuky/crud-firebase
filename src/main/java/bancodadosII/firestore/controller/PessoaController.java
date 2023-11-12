package bancodadosII.firestore.controller;

import bancodadosII.firestore.model.Pessoa;
import bancodadosII.firestore.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api-firebase")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping("/savePessoa")
    public String salvarPessoa(@RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.savePessoa(pessoa);
    }

    @GetMapping("/getPessoa/{nomePessoa}")
    public ResponseEntity<Pessoa> getPessoa( @PathVariable String nomePessoa){
        return ResponseEntity.ok(this.pessoaService.getPessoa(nomePessoa));
    }

    @PutMapping("/atualizarPessoa")
    public ResponseEntity<Pessoa> atualizarPessoa(@RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(this.pessoaService.updatePessoa(pessoa));
    }

}
