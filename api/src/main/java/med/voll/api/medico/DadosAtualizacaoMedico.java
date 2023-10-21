package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
