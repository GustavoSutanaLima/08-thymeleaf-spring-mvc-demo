## Resumo sobre Thymeleaf e seu Uso com Spring Boot

**Thymeleaf** é um motor de template Java para processamento de HTML, XML, JavaScript, CSS e até texto puro. Ele é amplamente utilizado em aplicações Spring Boot para renderizar conteúdo dinâmico na web. 

* **Integração com Spring Boot
Configuração Simples**: Thymeleaf se integra facilmente com Spring Boot. Basta adicionar a dependência spring-boot-starter-thymeleaf no arquivo pom.xml.
Templates: Os arquivos de template Thymeleaf são colocados na pasta src/main/resources/templates.
* **Sintaxe e Expressões Thymeleaf**: Utiliza expressões como ```${}``` para acessar dados do modelo. Por exemplo, ```${theDate}``` para exibir a data e hora atual, baseado na linha: ```model.addAttribute("theDate", java.time.LocalDateTime.now());```, que atribui à variável ```theDate```, o objeto passado no segundo argumento de ```addAttribute()```;

* **Atributos Thymeleaf**: Usa atributos como ```th:text```, ```th:if```, ```th:each``` para manipular o conteúdo HTML dinamicamente.

#### Passando os dados do Código para o Template

* **Modelo**: Dados são passados para o template através do objeto Model no controlador (classe anotada com @Controller).


    ```java
    model.addAttribute("theDate", java.time.LocalDateTime.now());
    ```
* **Renderização de Páginas Dinâmicas
HTML Válido**: Thymeleaf permite que você mantenha HTML válido e visualizável no navegador, mesmo durante o desenvolvimento.

* **Exibição de Dados**: Dados dinâmicos são exibidos diretamente nas páginas HTML.

    ```html
    <h1 th:text="'Olá mundo, agora são ' + ${theDate}"></h1>
    ```
