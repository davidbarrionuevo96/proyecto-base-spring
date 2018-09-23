package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;

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
	
	
	@Test
	@Transactional
	@Rollback
	public void TestQueBuscaCiudadesDelHemisferioSur() {

		Ubicacion ubicacion1 = new Ubicacion();
		ubicacion1.setLatitud(4000.9);
		ubicacion1.setLongitud(215.3);
		
		Ciudad ciudad1 = new Ciudad();
		ciudad1.setNombre("Bs As");
		ciudad1.setUbicacionGeografica(ubicacion1);
		
		Ubicacion ubicacion2 = new Ubicacion();
		ubicacion2.setLatitud(45.4);
		ubicacion2.setLongitud(75.69);
		
		Ciudad ciudad2 = new Ciudad();
		ciudad2.setNombre("Ottawa");//Capital de Canada
		ciudad2.setUbicacionGeografica(ubicacion2);
		

		Session session = getSession();
		session.save(ubicacion1);
		session.save(ciudad1);
		session.save(ubicacion2);
		session.save(ciudad2);

		List<Ciudad> ciudadesHemisferioSur = getSession()
				.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica","ub")
				.add(Restrictions.le("ub.latitud", 200.6))
				//Restrictions.le es menor que o igual
				.list();

		assertThat(ciudadesHemisferioSur).isNotNull();
		assertThat(ciudadesHemisferioSur.size()).isEqualTo(1);
	}
	
}
