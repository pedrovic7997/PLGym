# Índice
<ul>
	<li><a href="#plgym">PLgym</a></li>
	<li><a href="#sobre">Sobre o projeto</a></li>
	<li>
		<a href="#como-executar">Como executar</a>
		<ul>
			<li><a href="#pr--requisitos">Pré-requisitos</a></li>
			<li><a href="#instala--o">Instalação</a></li>
			<li><a href="#instala--o">Ferramenta de administração</a></li>
		</ul>
	</li>
	<li><a href="#exemplo-de-uso">Exemplo de uso</a></li>
	<li><a href="#javadoc">Javadoc</a></li>
	<li><a href="#licen-a">Licença</a></li>
	<li><a href="#contato">Contato</a></li>
</ul>
<br>

# PLgym
Aplicação Web desenvolvida para a disciplina Projeto Integrado I no curso de Ciência de Computação da Universidade Federal do Espírito Santo, lecionada pelo professor João Paulo Andrade Almeida.

# Sobre

O PLgym é uma ferramenta que facilita e organiza os seus exercícios físicos em casa. Cada usuário é capaz de adicionar em sua lista pessoal os exercícios que desejar dentre os fornecidos no nosso banco de dados. Todos os exercícios possuem um endereço de acesso a um vídeo tutorial (curado pela nossa equipe) sobre como melhor executá-lo.

### **Ferramentas usadas**

* Spring Boot
* Spring Security
* Bootstrap
* JQuery
* Thymeleaf
* Maven

# Como executar

Para utilizar a ferramenta, basta seguir as seguintes instruções. As instruções são voltadas para uma máquina usando Linux.

### **Pré-requisitos**

* mvn (Maven)
```sh
sudo apt install maven
```
### **Instalação**

* Clone o repositório
```sh
git clone https://github.com/pedrovic7997/PLGym.git
```

* Abra o diretório criado e acesse a pasta "back-app"

* Dentro de "back-app", execute o comando
```sh
mvn spring-boot:run
```
Neste momento, depois de instalar diversas dependências, o Spring entrará em atividade, sinalizando que a aplicação estará ativa.

Para acessar, entre no seu navegador e digite
```
localhost:8080
```

### **Ferramenta de administração**

Caso queira utilizar a ferramenta de administrador para gerenciar o cadastro de exercícios, siga os seguintes passos.

Ainda no diretório "back-app", execute:
```sh
mvn clean install
```

Volte para o diretório pai, clonado inicialmente, e entre no diretório "admin-tool", e execute:

```sh
mvn clean package
```

```sh
java -cp ./target/admin-tool-1.0-jar-with-dependencies.jar plgtool.App
```

# Exemplo de uso

Para ilustrar alguns exemplos de uso, temos um [vídeo](https://www.youtube.com/embed/9r8Xv2tUghc?start=29&end=182) demonstrando a navegação no site.

**OBS:** Na versão atual do programa, o cadastro está funcionando porém para acessar com a conta criada, por motivos técnicos, o comando que liga o Spring deverá ser refeito para reiniciar a aplicação e assim fazer o login utilizando a conta nova.

# Javadoc

Para gerar páginas javadoc com o plugin Maven Javadoc, navegue para a pasta back-app e execute o seguinte comando

```sh
mvn javadoc:javadoc
```

As páginas se encontrarão no diretório ./target/site/apidocs.

# Licença

Distribuído sob a Licença MIT. Veja o arquivo `LICENSE` para mais informações.

# Contato

Leonardo Deorce  
https://github.com/leodeorce  
email: leodeorce@gmail.com

Pedro Victor Santos  
https://github.com/pedrovic7997  
email: pedrovictor6974@gmail.com
