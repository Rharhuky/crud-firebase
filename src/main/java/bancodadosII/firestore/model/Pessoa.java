package bancodadosII.firestore.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Builder
public class Pessoa {

    private String nome;
    private String profissao;
    private LocalDate nascimento;

}
