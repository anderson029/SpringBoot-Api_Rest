package med.voll.api.controller;

import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfomacoes(dados);
    }
    /*
    // Excluir dados do banco dados
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        repository.deleteById(id);
    }
  */
    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void desativar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

}
