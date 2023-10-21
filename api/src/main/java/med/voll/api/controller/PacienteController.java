package med.voll.api.controller;

import med.voll.api.pacientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired /*é uma anotação na linguagem de programação Java usada no Spring Framework para injeção de dependência. É usado para injetar dependências automaticamente em um bean Spring, como uma classe, sem criá-las explicitamente no código.*/
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"})Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPacientes::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPacientes dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInfomacoes(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inativar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }
}
