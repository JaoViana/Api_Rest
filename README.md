# Api_Rest
Testando uma API Rest utilizando JAVA
LINK da API: https://fakerestapi.azurewebsites.net

--> Testando Rest-assured (com o Eclipse)
*Para consulta*
https://github.com/rest-assured/rest-assured/wiki/Usage

-> Instalando requesitos
1. Passo é baixar o Eclipse e instalar. É Preciso dizer que sem a JDK ele não reconhece o Java.
2. Instalar
3. Novo projeto
4. Na home do eclipse, iremos criar um novo projeto:
	4.1. Home > file > other > maven project
5. Com o projeto criado, busquemos as dependencies para adicionar no POM.
	5.1. https://mvnrepository.com/
	5.2. baixemos: Rest Assured - io.rest-assured; testNG; json. Siga esta ordem!
6. Com esses passos feitos, é possivel iniciar um projeto

-> Criando e testando um primeiro projeto
1. Como foi dito na primeira parte, vamos criar o projeto:
	1.1. Home > file > other > maven project
2. Como os arquivos de POM já foram importados, podemos deixar essa parte quieta.
Selecionemos: src/test/java > new package (dê o nome que quiser ao pacote) > New class
3. Algo como essa class deve aparecer para o usuário:
		package Rest_Assurd;

		public class Teste {

		}
4. Já podemos começar com o primeiro teste de GET:
package Rest_Assurd;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;				importantes para podermos usar o comando "equalTo" e outros.

public class Teste {
	
	@Test (Isso vai importar a biblioteca do NG)
	public void test_01() {
		given()
			.get("URL da api que queremos testar")
		.then()
			statusCode(200) (Isso retornara como PASS se o status foi 200)
			.body("Vai trazer a modificação do BODY pra novos dados que podem aqui serem inseridos")
			.log().all(); (Printa todo console)

	}
5. Continuando com um Teste de POST:
package Rest_Assurd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Test_POST {
	
	@Test
	public void test_1_POST() {


		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("job", "Teacher");
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
		
	}

}
