package med.voll.api.Pacientes;

import med.voll.api.endereco.DadosEndereco;

public record dadosCadastroPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
