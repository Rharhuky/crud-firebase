package bancodadosII.firestore.controller;

import bancodadosII.firestore.model.Prova;
import bancodadosII.firestore.service.ProvaService;
import io.opencensus.metrics.export.TimeSeries;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/prova")
public class ProvaController {

    private final ProvaService provaService;

    @PostMapping
    public String saveProva(@RequestBody Prova prova) {
//        prova.setPeriodo(
//                List.of(Timestamp.valueOf(
//                        LocalDate.of(2023, 12, 15).atStartOfDay()),
//                        Timestamp.valueOf(LocalDate.of(2023, 12, 16).atStartOfDay())));
        return provaService.saveProva(prova);
    }

    @GetMapping("/{idProva}")
    public Prova buscarProvaPeloId(@PathVariable String idProva) {
        return provaService.buscarProvaPeloId(idProva);
    }

}
