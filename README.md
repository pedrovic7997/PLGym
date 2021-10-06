# PLGym
Aplicação Web desenvolvida para a disciplina Projeto Integrado I, lecionada pelo professor João Paulo Andrade Almeida.



# Sobre
O PLGym é uma ferramenta que facilita e organiza os seus exercícios físicos em casa. Cada usuário é capaz de adicionar em sua lista pessoal os exercícios que desejar dentre os fornecidos no nosso banco de dados. Todos os exercícios possuem um endereço de acesso a um vídeo tutorial (curado pela nossa equipe) sobre como melhor executá-lo.

### Ferramentas usada

* Spring Boot
* Spring Security
* Bootstrap
* JQuery
* Thymeleaf
* Maven

# Como instalar

Para utilizar a ferramenta, basta seguir as seguintes instruções. As instruções são voltadas para uma máquina usando Linux.

### Pré-requisitos

* mvn (Maven)
```sh
sudo apt install maven
```
### Instalação

* Clone o repositório
```sh
git clone https://github.com/pedrovic7997/PLGym.git
```

* Abra o diretório criado e acesse a pasta "back-app"

* Dentro de "back-app", execute o comando
```sh
mvn spring-boot:run
```
Neste momento, depois de instalar diversos arquivos, o Spring entrará em atividade, sinalizando que a aplicação estará ativa.

Para acessar, entre no seu navegador de internet e digite
```
localhost:8080
```

# Exemplo de uso

Para ilustrar alguns exemplos de uso, temos abaixo um video demonstrando a navegação no site.

<iframe width="864" height="486" src="https://www.youtube.com/embed/9r8Xv2tUghc?start=29&end=182;" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

**OBS:** Na versão atua do programa, o cadastro está funcionando porém para acessar com a conta criada, por motivos técnicos, o comando que liga o Spring deverá ser refeito para reiniciar a aplicação e assim fazer o login utilizando a conta nova.


* 4 - Como organizar o setup de desenvolvimento
* 5 - Como enviar uma modificação
* 6 - Log de modificações
* 7 - Licença e informações do autor