package com.uca.capas.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {
	
	@Id
	@Column(name="c_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="cat_categoria_codigoCategoria_seq")
	private Integer codigoCategoria;

	@NotEmpty(message="El campo no puede quedar vacio")
	@Size(min=1,max=50, message="El campo no puede tener mas de 50 caracteres")
	@Column(name="s_categoria")
	private String categoria;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	private List<Libro> libros;
	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public Categoria() {};
	
	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}
