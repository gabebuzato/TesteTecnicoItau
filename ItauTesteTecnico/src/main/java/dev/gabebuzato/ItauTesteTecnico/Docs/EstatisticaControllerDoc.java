package dev.gabebuzato.ItauTesteTecnico.Docs;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface EstatisticaControllerDoc  {

    @ApiResponse(
            responseCode = "200",
            description = "Estatísticas calculadas e retornadas com sucesso"
    )
    ResponseEntity estatistica();
}
