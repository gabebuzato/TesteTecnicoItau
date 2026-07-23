package dev.gabebuzato.ItauTesteTecnico.Docs;

import dev.gabebuzato.ItauTesteTecnico.Transacoes.TransacaoRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Transações",
        description = "EndPoints responsáveis por criar e adicionar as transações em uma lista assim que validadas "
)
public interface TrasacaoControllerDoc {
    @Operation(
            summary = "Cria transação",
            description = "Recebe uma transação válida e adiciona em uma lista"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validação capturado"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro inesperado no servidor"
    )
    ResponseEntity<Void> adicionar(@RequestBody TransacaoRequest transacaoRequest);

    @Operation(
            summary = "Deleta transações",
            description = "Deleta todos os dados de transações armazenados"
    )
    ResponseEntity deletar();
}
