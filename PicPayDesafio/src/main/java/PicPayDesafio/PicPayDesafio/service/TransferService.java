package PicPayDesafio.PicPayDesafio.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import PicPayDesafio.PicPayDesafio.model.TransferModel;
import PicPayDesafio.PicPayDesafio.model.UserModel;
import PicPayDesafio.PicPayDesafio.model.UserTypes;
import PicPayDesafio.PicPayDesafio.repository.TransferRepository;
import PicPayDesafio.PicPayDesafio.repository.UserRepository;

@Service
public class TransferService {

    @Autowired
    private TransferRepository transferRepository;
    @Autowired
    private UserRepository userRepository;

    public TransferModel sendTransfer(TransferModel transfer) throws Exception {
        Long clienteid = transfer.getCliente().getId();
        Long lojistaid = transfer.getLojista().getId();
        UserModel remetente = userRepository.findById(clienteid).orElse(null);
        UserModel destinatario = userRepository.findById(lojistaid).orElse(null);
        if (transfer.getValue() <= 0) {
            throw new Exception("O valor da transferencia não pode ser menor ou igual a zero");
        }

        else if (transfer.getLojista().getType() == UserTypes.MERCHANT) {
            throw new Exception("Este usuarioa nao pode realizar transferencia");
        } 
            if (remetente.getBalance() < transfer.getValue()) { 

                throw new Exception("Saldo insuficiente ");
            }
            remetente.setBalance(remetente.getBalance() - transfer.getValue());
            destinatario.setBalance(destinatario.getBalance() + transfer.getValue());
            userRepository.save(remetente);
            userRepository.save(destinatario);
            transfer.setCliente(remetente);
            transfer.setLojista(destinatario);
            
            return transferRepository.save(transfer);
        
        

    }

    public TransferModel getTranfer(Long id) throws Exception {
        if (transferRepository.existsById(id)) {
            return transferRepository.findById(id).orElse(null);
        } else {
            throw new Exception("Transação não encontrada");
        }
    }

    public void deleteTransfer(Long id) throws Exception {
        if (transferRepository.existsById(id)) {
            transferRepository.deleteById(id);
        } else {
            throw new Exception("Erro ao excluir transação");
        }
    }
}
