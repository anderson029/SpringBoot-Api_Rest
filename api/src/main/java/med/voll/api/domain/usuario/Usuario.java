package med.voll.api.domain.usuario;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter /* Utilizando lombok para criar todos os getters*/
@NoArgsConstructor /*gera o construtor default que a jpa exige em todas entidades*/
@AllArgsConstructor /* criando construtores que recebe todos os campos*/
@EqualsAndHashCode(of = "id") /**/
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
}
