package com.ghostdev.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller //Define um Spring MVC controller:
public class HelloWorldController {

    // Controlador para exibir o form html (campo onde uma informação será digitada)

    /*  A anotação @RequestMapping É mais flexível do que a @GetMapping, podendo ser usado para mapear
    qualquer tipo de requisição HTTP (GET, POST, PUT, DELETE, etc.). Você pode especificar o método 
    HTTP usando o atributo method: @RequestMapping(value = "/showForm", method = RequestMethod.GET)

    Por exemplo, se o método abaixo estiver anotado com @RequestMapping(name = "/showForm", method = RequestMethod.GET), 
    esse método só irá aceitar requisições do tipo GET, caso nenhum atributo "method" esteja especificado, ele
    poderá ligar com qualquer tipo de requisição HTTP.

    @GetMapping("/showForm") é a forma sucinta de se escrever @RequestMapping(name = "/showForm", method = RequestMethod.GET)
    */ 
    @GetMapping("/showForm")
    public String showForm() {
        //buscará o arquivo de visualização em src/main/resources/templates/helloworld-form.html;
        return "helloworld-form"; 
    }

    // Controlador para processar o input que o usuário fez no form acima
    @RequestMapping("/processForm")
    public String processForm() {
        //buscará o arquivo de visualização em src/main/resources/templates/helloworld.html;
        return "helloworld"; 
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        //para eu trazer a informação que foi passada no userform (no end-point /showForm)
        //eu preciso usar um objeto do tipo HttpServletRequest (é nele que constam as informações do 
        //dos forms no html) e trazer o parâmetro com o nome
        //"studentName" que está dentro do html chamado na requisão do end-point: /showForm;

        //o model é o container que registra dos dados;
        String namePassedInTheUserForm = request.getParameter("studentName");

        //após esse valor ser "trazido" pra dentro do código, como uma String, passo no toUpperCase()
        //para fazer uma manipulção simples;
        namePassedInTheUserForm = namePassedInTheUserForm.toUpperCase();

        //Crio um nova string com o nome result e adiciono "Yo! " como prefixo;
        String result = "Yo! " + namePassedInTheUserForm;

        //adiciona um atributo ao modelo, o html enxergará esse atributo como "message", e será definido lá
        //como ${model} mas no código Java o nome desse atributo é result, para adicioná-lo ao modelo, 
        //é preciso passar o seu nome no html e o do objeto aqui no código;
        model.addAttribute("message", result);

        //helloword.html precisa conter em seu corpo @{message} para poder exibir a mensagem no browser
        return "helloworld";

    }

    @PostMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String studentName, @RequestParam("lastName") String lastName, Model model) {
        
        //Outra forma de capturar os dados userform é através da anotação Spring @RequestParam(),
        //que funciona similar ao @RequestBody da aplicação REST. Essa anotação busca os dados do userform
        //e os atribui à variável que está logo após a anotação;

        String result = "Your name is : " + studentName.toUpperCase() + " " + lastName.toUpperCase() + " , right?";

        //adiciona um atributo ao modelo, o html enxergará esse atributo como "message", e será definido lá
        //como ${model} mas no código Java o nome desse atributo é result, para adicioná-lo ao modelo, 
        //é preciso passar o seu nome no html e o do objeto aqui no código;
        model.addAttribute("message", result);

        //helloword.html precisa conter em seu corpo @{message} para poder exibir a mensagem no browser
        return "helloworld";

    }

}
