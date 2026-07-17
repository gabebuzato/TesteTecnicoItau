package dev.gabebuzato.ItauTesteTecnico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest) {
        try{
            transacaoService.validarTransacao(transacaoRequest);
            transacaoRepository.salvarDados(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch(IllegalArgumentException exception) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch(Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @DeleteMapping("/deletar")
    public ResponseEntity deletar(){
        transacaoRepository.deletarDados();
        return ResponseEntity.ok().build();
    }
}
