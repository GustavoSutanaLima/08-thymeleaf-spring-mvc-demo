package com.ghostdev.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import com.ghostdev.springboot.thymeleafdemo.model.Student;

@Controller
public class StudentController {

    /*Definindo um atributo para o controlador de Students que receberá a lista de Countries */
    /*Preciso anotar essa classe com @Value para poder trazer os valores do arquivo de condiguração .properties */
    /*e passar o nome do atributo que eu quero trazer do .properties dentro de aspas duplas, e dentro de ${} */

    @Value("${students.countries}")
    private List<String> countries;

    /*Definindo outro atributo para o controlador de Student, neste caso termeos uma lista de Linguagens de programação */
    @Value("${program.languages}")
    private List<String> programLanguages;

    /*Definindo mais um atributo que trás informações do .properties */
    @Value("${operational.systems}")
    private List<String> operationalSystems;

    /*Método que vai, de fato, chamar o form que o usuário irá preencher e dar subit */
    /*Quando o client der um GET sobre esse end-point, esse método rodará. */
    @GetMapping("/student-form")

    /*
     * No Spring MVC, o Model é uma interface que permite passar dados do controlador 
     * para a view (a página HTML que será exibida ao usuário). 
     * Ele funciona como um contêiner para os dados que você deseja exibir na view.
     */
    public String mostrarFormStudent(Model model){

        Student theStudent = new Student();
        //Instancia um novo objeto do tipo Student

        model.addAttribute("student", theStudent);
        //Nome do atrbituo (html) e valor que ele recebe, no caso o objeto theStudent (do tipo Student)

        model.addAttribute("countries_list", this.countries);
        //Adiciona a lista de países (Countries) ao modelo (ou seja, agora é possível acessar esse atributo dentro
        //do hmtl que será chamado abaixo:)

        model.addAttribute("programLanguage_list", this.programLanguages);

        model.addAttribute("operationalSystem_list", operationalSystems);

        return "student-form";
    }

    /*
     * Esta anotação mapeia requisições HTTP POST para o método processarFormStudent. 
     * Quando um formulário é submetido para o endpoint /processStudentForm, este método será chamado.
     * Ou seja, quando o usuário der um post sobre este endpoint ou algum formulário chamar este endpoint,
     * o métdo abaixo será executado.
     */
    @PostMapping("/processStudentForm")
    public String processarFormStudent(@ModelAttribute("student") Student studentToProcess) {
        /*
         * @ModelAttribute("student"): Esta anotação vincula o objeto Student do modelo ao parâmetro 
         * studentToProcess. Ou seja, Spring MVC automaticamente cria um objeto com os dados do "student"
         * (com informações submetidas no formulário html).
         * 
         * Por tanto, o objeto studentToProcess agora contém os dados do formulário submetido.
         * 
         * É PRECISO QUE ESSE ATRIBUTO SEJA PASSADO NO MÉTODO COM A ANOTAÇÃO @ModelAttribute("sutdent"), 
         * É ESSA ANOTAÇÃO QUE GARANTE QUE AS INFORAMÇÕES DO FORMULÁRIO DE INSCRIÇÃO SEJAM PASSADAS AO 
         * FORMULÁRIO DE CONFIRMAÇÃO.
         */
            System.out.println(studentToProcess); 
            System.out.println(this.programLanguages);

        return "student-confirmation";
    }
}
