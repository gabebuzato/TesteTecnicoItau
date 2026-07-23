package dev.gabebuzato.ItauTesteTecnico.Transacoes;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransacaoRequest {

    @NotNull(message = "A transação deve conter valor")
    @Positive(message = "O valor da transação deve ser maior ou igual a zero")
    private BigDecimal valor;
    private OffsetDateTime data;
}
