package med.voll.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice /* tag para fazer o spring boot entender que se trata de uma classe de tratativas de erros */
public class TratadorDeErros {
  @ExceptionHandler(EntityNotFoundException.class) /* se acontecer alguma exception na requisição o spring retornar 404*/
  public ResponseEntity tratarErro404(){
     return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) /*se acontecer alguma exception de argumentos inválidos retorna esse método*/
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }

    private record DadosErroValidacao(String campo, String mensagem){
        public DadosErroValidacao (FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
