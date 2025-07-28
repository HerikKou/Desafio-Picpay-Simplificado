package PicPayDesafio.PicPayDesafio.dto;


// import PicPayDesafio.PicPayDesafio.model.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDto {

    private Long id;

    private double value;
     private String menssage;
    private UserDto cliente;
    private UserDto lojista;

    public String toString() {

        return 
                "Value:" + getValue()
                +"\n"+
                "Mensagem:"+getMenssage() 
                +"\n"+
                "Cliente:"+getCliente()
                +"\n"+
                "Lojista:"+getLojista();
                
                
              
              
    }
}
