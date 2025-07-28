package PicPayDesafio.PicPayDesafio.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import PicPayDesafio.PicPayDesafio.model.TransferModel;


@Repository
public interface TransferRepository extends JpaRepository<TransferModel, Long>  {

Optional<TransferModel>  findById(Long id);
boolean existsById(Long id);


}
