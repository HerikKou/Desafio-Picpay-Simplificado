package PicPayDesafio.PicPayDesafio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PicPayDesafio.PicPayDesafio.model.UserModel;
import PicPayDesafio.PicPayDesafio.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/User")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/registerUser")
    public ResponseEntity<UserModel> registrarUsuario(@RequestBody UserModel user) throws Exception{
       UserModel registerUser = userService.register(user);
       if(registerUser != null){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
       }
       else{
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
       }

    }
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarUsuario(@PathVariable Long id)throws Exception {
        UserModel getuser = userService.getuser( id);
        if(getuser != null){
             return ResponseEntity.status(HttpStatus.OK).body(getuser);
        }
        else{
             return ResponseEntity.status(404).body(null);
        }
    }
    
    
    
}
