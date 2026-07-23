package dev.gabebuzato.ItauTesteTecnico.Estatisticas;

import dev.gabebuzato.ItauTesteTecnico.Docs.EstatisticaControllerDoc;
import dev.gabebuzato.ItauTesteTecnico.Transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticasController implements EstatisticaControllerDoc {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstatisticasProperties estatisticasProperties;

    @GetMapping
    public ResponseEntity estatistica() {

        log.info("Calculando estatísticas de transações nos últimos " + estatisticasProperties.segundos() + " segundos");
        final var horarioInicial = OffsetDateTime
                .now()
                .minusSeconds(estatisticasProperties.segundos());
        return ResponseEntity.ok(transacaoRepository.estatistica(horarioInicial));
    }

}


