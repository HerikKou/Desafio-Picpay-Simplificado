package PicPayDesafio.PicPayDesafio.dto;


import PicPayDesafio.PicPayDesafio.model.UserTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String document;

    private UserTypes type;

    private double balance;

    public String toSting() {

        return 
                
                "Name:" + getName()
                + "\n"
                + "Email:" + getEmail()
                + "\n"
                + "Document:" + getDocument()
                + "\n" + "Type:" + getType()
                + "\n"
                + "Balance:" + getBalance();
    }
}
