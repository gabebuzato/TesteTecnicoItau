package dev.gabebuzato.ItauTesteTecnico;

import dev.gabebuzato.ItauTesteTecnico.Docs.TrasacaoControllerDoc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacoesController implements TrasacaoControllerDoc {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest) {
        try{
            log.info("Validando transação, aguarde...");
            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch(IllegalArgumentException exception) {
            log.error("Erro em uma ou mais validação(ões), tente novamente");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).build();
        } catch(Exception exception) {
            log.error("Erro no servidor, tente novamente");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @DeleteMapping("/deletar")
    public ResponseEntity deletar(){
        log.info("Deletando dados de transações");
        transacaoRepository.deletarDados();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
