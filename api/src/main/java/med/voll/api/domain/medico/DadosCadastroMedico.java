package med.voll.api.domain.medico;

import com.sun.istack.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.*;

public record DadosCadastroMedico(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{telefone.obrigatorio")
        String telefone,
        @NotBlank(message = "{crm.obrigatorio}")
        @Size(max = 6, message = "{crm.invalido}")
        String crm,
        @NotNull/*(message = "{especialidade.obrigatoria}")*/
        Especialidade especialidade,
        @NotNull/*(message = "{endereco.obrigatorio}")*/
        @Valid
        DadosEndereco endereco) {
}