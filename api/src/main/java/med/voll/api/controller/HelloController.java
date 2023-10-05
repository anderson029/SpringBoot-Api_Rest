package med.voll.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Anotação para api rest
@RequestMapping("/hello") // Qual é a URL que o controller vai responder
public class HelloController {
    // Quando chegar um requisição do tipo get para a requisição /hello,
    // o spring chama o método com essa anotação
    @GetMapping
    public String olaMundo() {
        return "Hello World Spring!";
    }
}
