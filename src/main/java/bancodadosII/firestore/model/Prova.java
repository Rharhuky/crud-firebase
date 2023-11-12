package bancodadosII.firestore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prova {

    private String descricao;

    private List<Timestamp> periodo;

    private List<Questao> questoes;

}
