package dev.gabebuzato.ItauTesteTecnico;
import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter oi valor maior ou igual a zero");
        }
        if (transacaoRequest.getData().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter a data menor ou igual a atual");
        }
        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem conter um valor");
        }
        if (transacaoRequest.getData() == null) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem conter data");
        } else
            ResponseEntity.ok().body(transacaoRequest);
    }
}
