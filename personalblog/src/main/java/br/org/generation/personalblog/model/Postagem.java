package br.org.generation.personalblog.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity //usamos para dizer que a nossa classe se trata de uma entidade e serÃ¡ mapeada como tabela em nosso banco
@Table(name = "postagem") //diz que essa vai ser a tabela e o nome dela vai ser esse 
public class Postagem {
	
	
	@Id// define essa String id como o Id da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) ///diz que o Id vai ser chave primÃ¡ria auto incremento
	private long id;
	
	
	@NotNull //diz que esse campo nÃ£o pode ser nulo
	@Size (min = 5, max=100) // Diz o tamanho que vai ter o campo
	private String titulo;
	
	
	@NotNull //diz que esse campo nÃ£o pode ser nulo
	@Size (min = 10, max=500) // Diz o tamanho que vai ter o campo
	private String texto;
	
	
	@Temporal(TemporalType.TIMESTAMP) // diz qual o tipo de tempo vai utilizar para o jpa h
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
