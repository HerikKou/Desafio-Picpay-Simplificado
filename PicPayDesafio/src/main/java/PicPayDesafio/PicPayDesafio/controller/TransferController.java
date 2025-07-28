package PicPayDesafio.PicPayDesafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PicPayDesafio.PicPayDesafio.model.TransferModel;
import PicPayDesafio.PicPayDesafio.service.TransferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
  @Autowired
  private TransferService transferService;

  @PostMapping("/transacao")
  public ResponseEntity<TransferModel> enviarTransacao(@RequestBody TransferModel transfer) throws Exception {
    TransferModel transferir = transferService.sendTransfer(transfer);
    if (transferir != null) {
      return ResponseEntity.status(HttpStatus.OK).body(transfer);
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  @GetMapping("{id}/transacoes")
  public ResponseEntity<?> buscarTransferencia(@PathVariable Long id) throws Exception {
    TransferModel pegarTransferencia = transferService.getTranfer(id);
    if (pegarTransferencia != null) {
      return ResponseEntity.status(HttpStatus.OK).body(pegarTransferencia);
    } else {
      return ResponseEntity.status(404).body(null);
    }
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deletarTransferencia(@PathVariable Long id) throws Exception {
     try {
        transferService.deleteTransfer(id);
        return ResponseEntity.ok("Transferência excluída com sucesso");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transferência não encontrada");
    }
}
  }


