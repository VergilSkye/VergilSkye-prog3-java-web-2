# prog3-java-web


## Objetivo 

*Git para apresentação dos trabalhos 6 e 7 da matéria Programação de Computadores III*

### Tarefas
------------
- [x] [Trabalho 6](https://nead.ifb.edu.br/pluginfile.php/312324/mod_resource/content/0/Trabalho6.pdf)
- [x] [Trabalho 7](https://nead.ifb.edu.br/pluginfile.php/315014/mod_resource/content/0/Aula14.pdf)
------------
### Links Úteis Para os Projetos
------------
Trabalho 6 | Trabalho 7
------------ | -------------
[Pasta ](https://github.com/VergilSkye/prog3-java-web/tree/master/trabalho6) | [Pasta ](https://github.com/VergilSkye/prog3-java-web-2)
[Site Funcional ](https://infinite-bayou-16512.herokuapp.com/) | [Site Funcional ](https://agile-dawn-72784.herokuapp.com)
------------

### Uso do trabalho 7
------------
Clone o diretório
``` 
git clone https://github.com/VergilSkye/prog3-java-web.git
```
Dê build na pasta do projeto escolhido
``` 
mvn clean install
```
Crie um um arquivo chamado ProcFile com as informações do seu banco de dados postgres ou passe os parâmetros como argumentos

``` 
web: java -Dhibernate_db_name=${YOUR_DATABASE_URL} -Dhibernate_username=${YOUR_DATABASE_LOGIN} -Dhibernate_password=${YOUR_DATABASE_PASSWORD} $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war 
```

Agora é só utilizar um server ~~(tomcat ou webapp runner)~~ e testar localmente.
