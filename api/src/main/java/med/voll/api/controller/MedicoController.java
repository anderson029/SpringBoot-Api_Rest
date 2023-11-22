package med.voll.api.controller;

import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.web.util.UriComponentsBuilder;


@RestController/*é uma anotação no Spring Framework para construir serviços web RESTful*/
@RequestMapping("medicos") /*anotação para controlar vários aspectos do mapeamento de solicitação, como HTTP@GetMapping,@PostMapping, `@Colocar@PutMapping, `@DeleteMapping)*/
public class MedicoController {
    @Autowired /*é uma anotação na linguagem de programação Java usada no Spring Framework para injeção de dependência. É usado para injetar dependências automaticamente em um bean Spring, como uma classe, sem criá-las explicitamente no código.*/
    private MedicoRepository repository;

    @PostMapping /*é uma forma de declarar um método que lida com solicitações HTTP POST*/
    @Transactional /*fazer uma transação ativa no banco de dados*/
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }
    @GetMapping
    public ResponseEntity <Page<DadosListagemMedico>> listar(Pageable paginacao){

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInfomacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
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
//    @ResponseStatus(HttpStatus.NO_CONTENT) uma das formas de atualizar o staus code do http
    public ResponseEntity desativar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

}