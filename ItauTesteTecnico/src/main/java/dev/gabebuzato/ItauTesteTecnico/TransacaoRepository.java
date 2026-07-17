package dev.gabebuzato.ItauTesteTecnico;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> listaDeTransacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest TransacaoRequest) {
        listaDeTransacoes.add(TransacaoRequest);
    }

    public void limparDados(TransacaoRequest TransacaoRequest) {

    }

    public void deletarDados() {
        listaDeTransacoes.clear();
    }
}
