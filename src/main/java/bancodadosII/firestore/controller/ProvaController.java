package bancodadosII.firestore.controller;

import bancodadosII.firestore.model.Prova;
import bancodadosII.firestore.service.ProvaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/prova")
public class ProvaController {
    /*
    TODO atualizar pessoa
    TODO deletar pessoa
    TODO getAll pessoa - FIXME with Query
     */

    private final ProvaService provaService;

    @PostMapping
    public String saveProva(@RequestBody Prova prova) {
        return provaService.saveProva(prova);
    }

    @GetMapping("/{idProva}")
    public Prova buscarProvaPeloId(@PathVariable String idProva) {
        return provaService.buscarProvaPeloId(idProva);
    }


    @GetMapping
    public List<Prova> buscarTodasProvas(){

        return this.provaService.buscarTodasProvas();

    }

    @PutMapping("/{idProva}")
    public Prova atualizarProvaPeloId(
            @PathVariable String idProva,
            @RequestBody Prova prova) {

        return this.provaService.atualizarProvaPeloId(idProva, prova);
    }

    @DeleteMapping("del/{idProva}")
    public String deletarProvaPeloId(@PathVariable String idProva){

        return this.provaService.deletarProvaPeloId(idProva);

    }


}
