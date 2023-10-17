package med.voll.api.medico;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

import javax.persistence.*;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter /* Utilizando lombok para criar todos os getters*/
@NoArgsConstructor /*gera o construtor default que a jpa exige em todas entidades*/
@AllArgsConstructor /* criando construtores que recebe todos os campos*/
@EqualsAndHashCode(of = "id") /**/
public class Medico {
    @Id /*Essa anotação é usada para marcar um campo como a chave primária da entidade. */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*Essa anotação é usada em conjunto com a anotação @Id para indicar como os valores da chave primária devem ser gerados automaticamente*/
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}