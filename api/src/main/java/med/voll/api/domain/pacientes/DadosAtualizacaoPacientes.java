package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public record DadosAtualizacaoPacientes(
        @NotNull
        Long id,
        String email,
        String telefone,
        @Valid
        DadosEndereco endereco
) {
}
