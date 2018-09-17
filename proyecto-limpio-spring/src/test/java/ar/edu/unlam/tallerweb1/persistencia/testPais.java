package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Pais;

public class testPais extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	
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
		
//		barrio01.setComuna(comuna);
//		barrio01.setNombre("Catan");
//		
//		getSession().save(barrio01);
//		
//		Barrio barrio02=new Barrio();
//		
//		barrio02.setComuna(comuna);
//		barrio02.setNombre("Catan2");
//		
//		getSession().save(barrio02);
		
		
		List<Pais> nvaLista=getSession().createCriteria(Pais.class)
				.add(Restrictions.like("idioma", "ingles"))
				.list();
		
		assertThat(nvaLista.size()).isEqualTo(4);
		
		
	}
	  
	//como hacer para obtener todas las direcciones que pertenezcan a la comuna1
	//los .create
	
}
