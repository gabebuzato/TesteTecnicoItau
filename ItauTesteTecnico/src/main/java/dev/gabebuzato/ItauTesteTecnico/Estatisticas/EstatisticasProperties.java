package dev.gabebuzato.ItauTesteTecnico.Estatisticas;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "estatistica")
public record EstatisticasProperties(Integer segundos) {

}
