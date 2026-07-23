package dev.gabebuzato.ItauTesteTecnico.Transacoes;
import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validarTransacao(TransacaoRequest transacaoRequest) {

        if (transacaoRequest.getValor() == null) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem conter um valor");
        }
        if (transacaoRequest.getData() == null) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem conter data");
        }
        if (transacaoRequest.getValor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter o valor maior ou igual a zero");
        }
        if (transacaoRequest.getData().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("Erro: Isso não é uma transação válida, transações devem ter a data menor ou igual a atual");
        }
    }
}
