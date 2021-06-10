package br.org.generation.blogpessoal.model;

import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostagemModelTeste {

	public Postagem postagem;
	
/* Injeta um Objeto da Classe Validator, responsável pela Validação dos Atributos da Model*/
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	    
	}
	
	

