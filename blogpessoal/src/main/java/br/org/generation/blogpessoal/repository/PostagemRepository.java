package br.org.generation.blogpessoal.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Postagem;


@Repository //Diz que Ã© uma classe de repositÃ³rio
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); //buscar todos pelo titulo que Ã© o nome do atributo da entidade que Ã© Titulo, containing seria mesma coisa do like, tuddo que estiver dentro ele vai trazer, padroniza tudo pra minusculo com ignore case, nÃ£o leva em consideraÃ§Ã£o maisuculo ou minusculo
	

}
