package dev.gabebuzato.ItauTesteTecnico.Estatisticas;

import dev.gabebuzato.ItauTesteTecnico.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;


@RestController
@RequestMapping("/estatistica")
public class EstatisticasController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstatisticasProperties estatisticasProperties;

    @GetMapping
    public ResponseEntity estatistica() {
        final var horarioInicial = OffsetDateTime.now().minusSeconds(estatisticasProperties.segundos());
        EstatisticaDTO estatisticas = transacaoRepository.estatistica(horarioInicial);
        return ResponseEntity.ok().body(estatisticas);
    }

}
