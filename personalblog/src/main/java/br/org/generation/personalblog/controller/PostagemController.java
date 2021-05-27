package br.org.generation.personalblog.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.personalblog.model.Postagem;
import br.org.generation.personalblog.repository.PostagemRepository;


//=============== Find All ============
@RestController //indica que essa classe Ã© controller
@RequestMapping("/postagens") //indica o endpoint que vai ser acessado essa classe, ou seja, define a rota, a URL
@CrossOrigin("*") //diz que essa classe vai aceitar requisiÃ§Ãµes de qualquer origem, como react e etc.
public class PostagemController {
	
	
	@Autowired //Atribui todas as permissÃµes e responsabilidades para instanciar as coisas para o Spring
	private PostagemRepository repository;


	@GetMapping //sempre que vier requisiÃ§Ãµes externas atravÃ©s da URL, se o mÃ©todo for GET, irÃ¡ disparar este mÃ©todo abaixo
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	//==================Fin By Id=================
	@GetMapping("/{id}") //informar qual vai ser o parametro enviado para quem estÃ¡ fazendo a requisiÃ§Ã£o
public ResponseEntity<Postagem> GetById(@PathVariable long id){//captura valor que vem pela URL
		return repository.findById (id)
				.map(resp -> ResponseEntity.ok(resp)) //retorna ok se o objeto for encontrado
				.orElse(ResponseEntity.notFound().build());//retorna not found se o objeto nÃ£o for encontrado se tiver erro na requisiÃ§Ã£o ou se a resposta vier nula.
		
		
	}
	
	//==============Find By Titulo =====================================================
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	//===============controller post=====================================================
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
		
	}
	//======================controller put==============================================
	@PutMapping
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
		
	}
	
	//============================controller================
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}






