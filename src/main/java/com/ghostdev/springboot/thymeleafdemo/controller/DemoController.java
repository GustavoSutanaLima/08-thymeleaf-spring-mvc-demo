package com.ghostdev.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// Indica que esta classe é um controlador Spring MVC, responsável por lidar com requisições HTTP.
@Controller
public class DemoController {

    // Mapeia requisições HTTP GET para o método sayHello quando o end-point /hello é acessado 
    @GetMapping("/hello")
    public String sayHello(Model model) {

        // Adiciona um atributo ao modelo com o nome "theDate" e o valor da data e hora atual
        model.addAttribute("theDate", java.time.LocalDateTime.now());

        // Retorna o nome da vista "helloworld" que será resolvida pelo ViewResolver, no caso,
        // precisamos ter um aruiqvo dentro de "src\main\resources\templates" com o nome helloworld.html, 
        // O ViewResolver montará o corpo da resposta basedo nesse recurso html;
        return "helloworld";
    }

}