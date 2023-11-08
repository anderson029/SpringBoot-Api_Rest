package med.voll.api.domain.pacientes;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.Endereco;

import javax.persistence.*;

    @Getter
    @EqualsAndHashCode(of = "id")
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity(name = "Paciente")
    @Table(name = "pacientes")
    public class Paciente {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String cpf;
        private String telefone;
        private Boolean ativo;

        @Embedded
        private Endereco endereco;

        public Paciente(DadosCadastroPaciente dados) {
            this.ativo = true;
            this.nome = dados.nome();
            this.email = dados.email();
            this.telefone = dados.telefone();
            this.cpf = dados.cpf();
            this.endereco = new Endereco(dados.endereco());
        }

        public void atualizarInfomacoes(DadosAtualizacaoPacientes dados) {
            if(dados.email() != null){
                this.email = dados.email();
            }
            if(dados.telefone() != null){
                this.telefone = dados.telefone();
            }
            if(dados.endereco() != null){
                this.endereco.atualizarEndereco(dados.endereco());
            }
        }
        public void inativar() {
            this.ativo = false;
        }
    }
