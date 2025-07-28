package PicPayDesafio.PicPayDesafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PicPayDesafio.PicPayDesafio.model.UserModel;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel>  findById(Long id);
    boolean existsByEmail(String email);
    boolean existsByDocument(String document);
    boolean existsById(Long id);
}
