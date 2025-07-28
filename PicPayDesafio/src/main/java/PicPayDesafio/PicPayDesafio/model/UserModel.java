package PicPayDesafio.PicPayDesafio.model;


import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "O Nome deve ser Obrigatorio")
    private String name;

    @Column(name = "email" ,unique = true)
    @NotBlank(message = "O Email deve ser Obrigatorio")
    private String email;

    @Column(name = "document", unique = true)
    @NotBlank(message = "O Documento deve ser Obrigatorio")
    private String document;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "typeUser")
    private UserTypes type;

    @Column(name = "balance")
    @NotNull(message = "O Saldo deve ser Obrigatorio")
   
    private double balance;
  @OneToMany(mappedBy = "cliente")
  @JsonIgnore
    private List<TransferModel> transfersEnviadas;

    @OneToMany(mappedBy = "lojista")
    private List<TransferModel> transfersRecebidas;



}
