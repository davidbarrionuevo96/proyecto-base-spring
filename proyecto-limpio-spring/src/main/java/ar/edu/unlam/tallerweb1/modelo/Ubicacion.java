package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ubicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long longitud;
	private Long latitud;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLongitud() {
		return longitud;
	}
	public void setLongitud(Long longitud) {
		this.longitud = longitud;
	}
	public Long getLatitud() {
		return latitud;
	}
	public void setLatitud(Long latitud) {
		this.latitud = latitud;
	}
}
