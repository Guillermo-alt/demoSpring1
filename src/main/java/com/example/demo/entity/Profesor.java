package com.example.demo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="profesor") //nombre de tabal
public class Profesor implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment
	private Long id;
	
	@Column(name = "nombre") //ASIGNA NOMBRE A COLUMNA
	private String nombre;
	
	@Column (length = 60, unique = true)
	private String email;   //asigna por defaul el nombre de java
	
	private String password;
	
	@Column (length = 2000)
	private String foto;
	
	@Column (name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "profesor_id", referencedColumnName = "id")
	List<Curso> curso = new ArrayList<>();
	
	public List<Curso> getCurso() {
		return curso;
	}


	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}


	@PrePersist
	public void prePersist() {
		createAt = new Date(); //crea fecha actual
	}
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String name) {
		this.nombre = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getFoto() {
		return foto;
	}




	public void setFoto(String foto) {
		this.foto = foto;
	}




	public Date getCreate_at() {
		return createAt;
	}


	public void setCreate_at(Date create_at) {
		this.createAt = create_at;
	}

	/**			
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
}
