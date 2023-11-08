package med.voll.api.domain.pacientes;

import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public record DadosCadastroPaciente(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        String email,
        @NotBlank(message = "{telefone.obrigatorio}")
        String telefone,
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "{cpf.obrigatorio}")
        String cpf,
        @NotNull(message = "{endereco.obrigatorio}")
        @Valid
        DadosEndereco endereco) {
}
