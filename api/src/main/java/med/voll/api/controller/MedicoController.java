package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;


@RestController/*é uma anotação no Spring Framework para construir serviços web RESTful*/
@RequestMapping("medicos") /*anotação para controlar vários aspectos do mapeamento de solicitação, como HTTP@GetMapping,@PostMapping, `@Colocar@PutMapping, `@DeleteMapping)*/
public class MedicoController {
    @Autowired /*é uma anotação na linguagem de programação Java usada no Spring Framework para injeção de dependência. É usado para injetar dependências automaticamente em um bean Spring, como uma classe, sem criá-las explicitamente no código.*/
    private MedicoRepository repository;

    @PostMapping /*é uma forma de declarar um método que lida com solicitações HTTP POST*/
    @Transactional /*fazer uma transação ativa no banco de dados*/
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
