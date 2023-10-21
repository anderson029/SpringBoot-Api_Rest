package med.voll.api.pacientes;

import med.voll.api.endereco.DadosEndereco;

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
