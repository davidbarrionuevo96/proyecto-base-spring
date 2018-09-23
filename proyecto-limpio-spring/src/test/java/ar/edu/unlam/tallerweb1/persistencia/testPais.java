package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

public class testPais extends SpringTest{

	@Test
	@Transactional
	@Rollback(true)	
	public void testQueBuscaPaisesDeHablaInglesa(){
		
		Pais pais1= new Pais();
		pais1.setIdioma("ingles");
		getSession().save(pais1);
		
		Pais pais2= new Pais();
		pais2.setIdioma("ingles");
		getSession().save(pais2);
		
		Pais pais3= new Pais();
		pais3.setIdioma("ingles");
		getSession().save(pais3);
		
		Pais pais4= new Pais();
		pais4.setIdioma("ingles");
		getSession().save(pais4);
		
		Pais pais5= new Pais();
		pais5.setIdioma("español");
		getSession().save(pais5);
		
		Pais pais6= new Pais();
		pais6.setIdioma("portugues");
		getSession().save(pais6);
		
		
		List<Pais> nvaLista=getSession().createCriteria(Pais.class)
				.add(Restrictions.like("idioma", "ingles"))
				.list();
		
		assertThat(nvaLista.size()).isEqualTo(4);
		
	}
	  
	//como hacer para obtener todas las direcciones que pertenezcan a la comuna1
	//los .create
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaPaisesDeContinenteEuropeo(){
		
		Continente conti1 = new Continente();
		conti1.setNombre("europeo");
		
		Continente conti2 = new Continente();
		conti2.setNombre("americano");
		
		Pais pais1= new Pais();
		pais1.setContinente(conti1);
		pais1.setIdioma("ingles");
		getSession().save(pais1);
		
		Pais pais2= new Pais();
		pais2.setContinente(conti1);
		pais2.setIdioma("ingles");
		getSession().save(pais2);
		
		Pais pais3= new Pais();
		pais3.setContinente(conti1);
		pais3.setIdioma("ingles");
		getSession().save(pais3);
		
		Pais pais4= new Pais();
		pais4.setContinente(conti2);
		pais4.setIdioma("ingles");
		getSession().save(pais4);
		
		Pais pais5= new Pais();
		pais5.setContinente(conti2);
		pais5.setIdioma("español");
		getSession().save(pais5);
		
		Pais pais6= new Pais();
		pais6.setContinente(conti2);
		pais6.setIdioma("portugues");
		getSession().save(pais6);
		
		List<Pais> nvaLista=getSession().createCriteria(Pais.class)
				.createAlias("continente", "continentejoin")
				.add(Restrictions.like("continentejoin.nombre", "europeo"))
				.list();
		
		assertThat(nvaLista.size()).isEqualTo(3);
		
	}
	
	/*@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaCapitalesQueEstanAlNorteDelTropicoDeCancer(){
		// Linea del Ecuador	<-- es latitud.
		// Tropico de Cancer 23.5º
		// Tropico de Capricornio -23.5º
		
		// Meridiano de Greenwich <-- es longitud.
		
		Ubicacion ubi1 = new Ubicacion();
		ubi1.setLatitud(38.906324);
		ubi1.setLongitud(-77.035714);
		
		Ubicacion ubi2 = new Ubicacion();
		ubi2.setLatitud(45.421752);
		ubi2.setLongitud(-75.698992);
		
		Ubicacion ubi3 = new Ubicacion();
		ubi3.setLatitud(-34.603326);
		ubi3.setLongitud(-58.381886);
		
		Ciudad ciu1 = new Ciudad();
		ciu1.setNombre("Washington");
		ciu1.setUbicacionGeografica(ubi1);
		
		Ciudad ciu2 = new Ciudad();
		ciu2.setNombre("Ottawa");
		ciu2.setUbicacionGeografica(ubi2);
		
		Ciudad ciu3 = new Ciudad();
		ciu3.setNombre("Buenos Aires");
		ciu3.setUbicacionGeografica(ubi3);

		Pais pais1 = new Pais();
		pais1.setNombre("Estados Unidos");
		pais1.setCapital(ciu1);
		
		Pais pais2 = new Pais();
		pais2.setNombre("Canada");
		pais2.setCapital(ciu2);
		
		Pais pais3 = new Pais();
		pais3.setNombre("Argentina");
		pais3.setCapital(ciu3);
		
		getSession().save(pais1);
		getSession().save(pais2);
		getSession().save(pais3);
		
		// Dame todos los paises que tengan su Ciudad capital al norte del Tropico de cancer.
		List<Pais> nvaLista = getSession().createCriteria(Pais.class)
				.createAlias("pais", "paisjoin")
				.createAlias("paisjoin", "capital")
				.createAlias("capital", "ubicacion")
				.add(Restrictions.gt("ubicacion", "23.5"))
				.list();
		
		assertThat(nvaLista.size()).isEqualTo(2);

	}*/
	
}
