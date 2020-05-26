package com.uca.capas.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="cat_libro")
public class Libro {
	
	@Id
	@Column(name="c_libro")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="cat_libro_codigoLibro_seq")
	private Integer codigoLibro;
	
	@NotEmpty(message="No puede quedar vacio este campo")
	@Size(min=1, max=500, message="No puede ser mayor a 500 caracteres")
	@Column(name="s_titulo")
	private String titulo;
	
	@NotEmpty(message="No puede quedar vacio este campo")
	@Size(min=1, max=150, message="No puede ser mayor a 150 caracteres")
	@Column(name="s_autor")
	private String autor;
	
	@Column(name="f_ingreso")
	private Date fechaIngreso;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@NotEmpty(message="El campo no puede quedar vacio")
	@Size(min = 1, max=10,message="No puede tener mas de 10 caracteres")
	@Column(name="s_isbn")
	private String isbn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Libro() {};
	
	public Integer getCodigoLibro() {
		return codigoLibro;
	}
	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	public String getEstadoDelegate() {
		if(this.estado == null) 
			return "";
		else
			return estado == true ? "Activo":"Inactivo";
	}

}
