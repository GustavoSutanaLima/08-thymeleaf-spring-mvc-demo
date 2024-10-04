# Interação entre HTML e CSS em Projeto Spring Boot com Thymeleaf

Spring Boot é um framework que facilita a criação de aplicações Java robustas e escaláveis. Thymeleaf é um mecanismo de template que permite a criação de páginas HTML dinâmicas. A integração entre HTML e CSS em um projeto Spring Boot com Thymeleaf é essencial para criar interfaces de usuário atraentes e responsivas.

* A estrutura típica de um projeto Spring Boot com Thymeleaf inclui as seguintes pastas:
    ```
    src/
    ├── main/
    │   ├── java/
    │   ├── resources/
    │   │   ├── static/
    │   │   │   ├── css/
                    styles.css
    │   │   │   ├── js/
    │   │   ├── templates/
    │   │   │   ├── index.html
    ```
    * ```static/css/```: Contém os arquivos CSS.
    * ```templates/```: Contém os arquivos HTML processados pelo Thymeleaf.

## Um exemplo de arquivo HTML usando Thymeleaf (index.html):


```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <!-- No cabeçalho do arquivo html, o caminho do css é referenciado -->
        <meta charset="UTF-8">
        <title>Minha Página</title>
        <link rel="stylesheet" th:href="@{/css/styles.css}"/>
    </head>
    <body>
        <!-- A variável nome é processado pelo java no controlador do Spring Boot e no texto html é referenciado como: ${nome} -->
        <h1 th:text="'Olá, ' + ${nome}">Olá, Mundo!</h1>
    </body>
</html>
```

### Explicação
* ```<html xmlns:th="http://www.thymeleaf.org">```: Define o namespace do Thymeleaf.
* ```<link rel="stylesheet" th:href="@{/css/styles.css}"/>```: O Thymeleaf processa o atributo ```th:href``` para resolver o caminho do arquivo CSS.

*  ```<h1 th:text="'Olá, ' + ${nome}">Olá, Mundo!</h1>```: Insere texto dinâmico no HTML usando a variável nome passada pelo controlador Spring Boot.

## CSS
* Arquivo CSS:

    ```css
    body {
        font-family: Arial, sans-serif;
    }

    h1 {
        color: blue;
    }
    ```
* Explicação
    * **body**: Define a fonte padrão para o corpo da página.
    * **h1**: Define a cor do texto do cabeçalho h1.

## Controlador Spring Boot
* Um exemplo de controlador Spring Boot que passa dados para o template Thymeleaf:

    ```java
    @Controller
    public class HomeController {

        @GetMapping("/")
        public String home(Model model) {
            model.addAttribute("nome", "Mundo");
            return "index";
        }
    }
    ```

    * **@Controller**: Anotação que indica que esta classe é um controlador Spring MVC.
    * **@GetMapping("/")**: Mapeia requisições GET para a raiz (/) do aplicativo.
    * **model.addAttribute("nome", "Mundo")**: Adiciona um atributo ao modelo que será acessível no template Thymeleaf.
    return "index": Retorna o nome do template Thymeleaf (index.html).


* A integração entre HTML e CSS em um projeto Spring Boot com Thymeleaf permite criar páginas web dinâmicas e estilizadas de forma eficiente. O Thymeleaf facilita a inserção de dados dinâmicos no HTML, enquanto o Spring Boot gerencia a lógica do servidor.

Com essa estrutura, você pode desenvolver aplicações web robustas e visualmente atraentes, aproveitando o melhor de Java, Spring Boot e Thymeleaf.