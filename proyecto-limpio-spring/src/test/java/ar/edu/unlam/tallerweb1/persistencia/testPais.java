package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;

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
	
}
