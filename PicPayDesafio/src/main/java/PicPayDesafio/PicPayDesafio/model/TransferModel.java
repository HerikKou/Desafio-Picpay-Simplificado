package PicPayDesafio.PicPayDesafio.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TransferModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(message = "O ID não pode ser Obrigatorio")
    private Long id;

    @Column(name = "value")
    @NotNull(message = "O Valor deve ser Obrigatorio")
    private double value;

    @Column(name = "mensagem")
    private String menssage;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    
    private UserModel cliente;
     @ManyToOne
    @JoinColumn(name = "lojista_id")
    private UserModel lojista;    
   
 

}
