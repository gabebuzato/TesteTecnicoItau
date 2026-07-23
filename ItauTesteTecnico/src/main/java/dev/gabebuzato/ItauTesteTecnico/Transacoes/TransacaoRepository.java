package dev.gabebuzato.ItauTesteTecnico.Transacoes;

import dev.gabebuzato.ItauTesteTecnico.Estatisticas.EstatisticaDTO;

import lombok.Getter;

import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
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

    public EstatisticaDTO estatistica(OffsetDateTime horarioInicial) {
        if (listaDeTransacoes.isEmpty()) {
            return new EstatisticaDTO(0, 0.0, 0.0, 0.0, 0.0);
        }
        final var summary = listaDeTransacoes.stream()
                .filter(t ->
                        t.getData().isAfter(horarioInicial) || t.getData().isEqual(horarioInicial)
                )
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax());
    }
}
