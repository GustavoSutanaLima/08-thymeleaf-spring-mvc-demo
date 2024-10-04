# Diferença entre ```@Controller``` e ```@RestController```

* A diferença entre @Controller e @RestController no Spring Boot está principalmente na forma como eles tratam as respostas HTTP.

* **@Controller**
    * É usado para definir controladores em aplicações web tradicionais que retornam vistas (HTML, JSP, etc.).
    * Os métodos anotados com @Controller geralmente retornam nomes de vistas que são resolvidos por um ViewResolver para renderizar a resposta.

        ```java
        @Controller
        public class MyController {
            
            @GetMapping("/hello")
            public String hello(Model model) {
                model.addAttribute("message", "Hello, World!");
                return "hello"; // Nome da vista (hello.html, por exemplo)\\vai chamar esse arquivo para exibir a resposta;
            }
        }
        ```
* **@RestController**
    * É uma <u>especialização</u> de @Controller usada para criar controladores RESTful que retornam dados diretamente (geralmente em formato JSON ou XML).
    * Combina @Controller e @ResponseBody, o que significa que os métodos anotados com @RestController retornam os dados <u>diretamente no corpo da resposta HTTP, **sem** passar por um ViewResolver</u>.

        ```java
        @RestController
        public class MyRestController {
            
            @GetMapping("/hello")
            public String hello() {
                return "Hello, World!"; // Retorna diretamente como resposta HTTP
            }
        }
        ```
## Resumo das Diferenças
* Essas diferenças são importantes para escolher a anotação correta dependendo do tipo de aplicação que você está desenvolvendo.
    * **@Controller**: Usado para aplicações web tradicionais, retorna vistas (um arquivo html, por exemplo, que vai definir como o usuário verá a resposta da sua requisição).

    * **@RestController**: Usado para APIs RESTful, retorna dados diretamente no corpo da resposta.

