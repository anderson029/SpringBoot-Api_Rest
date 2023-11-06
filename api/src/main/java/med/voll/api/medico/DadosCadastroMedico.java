package med.voll.api.medico;

import com.sun.istack.NotNull;
import med.voll.api.endereco.DadosEndereco;

import javax.validation.Valid;
import javax.validation.constraints.*;

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Size(max = 6)
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco) {
}