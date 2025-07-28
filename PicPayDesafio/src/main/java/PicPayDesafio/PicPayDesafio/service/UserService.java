package PicPayDesafio.PicPayDesafio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PicPayDesafio.PicPayDesafio.model.UserModel;
import PicPayDesafio.PicPayDesafio.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserModel register(UserModel user) throws Exception {
        String email = user.getEmail();
        String document = user.getDocument();

        if (user.getName().isEmpty() || user.getName() == null) {

            throw new Exception("O Nome não pode ser Null ");

        } else if (email.isEmpty()) {
            throw new Exception("O Email não pode estar  vazio ");

        } else if (userRepository.existsByEmail(email)) {
            throw new Exception("O usuário já cadastrado ");
        }

        else if (document.isEmpty()) {
            throw new Exception("O Documento não pode estar vazio ");
        } else if (userRepository.existsByDocument(document)) {
            throw new Exception("O usuário já cadastrado ");
        }

        else {
            return userRepository.save(user);
        }

    }
    public UserModel getuser( Long id) throws Exception{
        if(userRepository.existsById(id)){
            return userRepository.findById(id).orElse(null);
        }
        else{
              throw new Exception("Usuário não encontrado ");
        }
    }
}
