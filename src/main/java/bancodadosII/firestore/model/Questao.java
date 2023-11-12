package bancodadosII.firestore.model;

import bancodadosII.firestore.model.enumerated.Dificuldade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Questao {

    private String enunciado;

    private String titulo;

    private Dificuldade dificuldade;

    private List<String> temas;

    private List<String> alternativas;

    private String resposta;
}
