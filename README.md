# cotacao-preco-online

* Projeto criado para o processo seletivo para Betha Sistemas. 
Este repositório e o **back-end** da aplicação. Para acesso ao front-end, click [aqui](https://github.com/amandasomariva/cotacao-preco-online-front).

## Tecnologias aplicada
* Java 8
* Springboot 
* JPA
* PostgreSQL

## Como executar 
* Crie um banco de dados no postgres com o seguinte nome: **cotacao**
* Vá ao **application.properties** e altere as seguintes opção
    * Caminho do arquivo: **src/main/resource/application.properties**
    * **spring.datasource.username**: Insira o nome de usuario do banco de dados
    * **spring.datasource.password**: Insira o password do usuário do banco
* Agora basta da um start na aplicação, todo o processo de criação das entidade serão criado automaticamente. 