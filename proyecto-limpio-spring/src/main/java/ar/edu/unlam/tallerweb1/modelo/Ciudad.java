package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	
	@ManyToOne
	private Pais pais;
	
	@OneToOne
	private Ubicacion ubicacionGeografica;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Ubicacion getUbicacionGeografica() {
		return ubicacionGeografica;
	}
	public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	

}
