package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorConvertirTexto {
	
	@RequestMapping("conversor")
	public ModelAndView irAConversorString() {
		return new ModelAndView("convertirstring");
	}
	
	@RequestMapping("mostrarresultado")
	public ModelAndView irAMostrarResultado(@RequestParam String gridRadios, @RequestParam String valor) {
		ModelMap modelo = new ModelMap();
		modelo.put("valor0", valor);
		
		switch(gridRadios) {
			case "option1":
				modelo.put("valor", valor.toUpperCase());
				break;
			case "option2":
				modelo.put("valor", valor.toLowerCase());
				break;
			case "option3":
				modelo.put("valor", valor.length());
				break;
			case "option4":
				modelo.put("valor", invertirCadena(valor));
				break;
		}
		
		return new ModelAndView("mostrarresultado",modelo);
	}
	
	private String invertirCadena(String cadena) {
		String sCadena=cadena;
		String sCadenaInvertida="";
		for(int x=sCadena.length()-1; x>=0; x--) {
			sCadenaInvertida = sCadenaInvertida + sCadena.charAt(x);
		}
		return sCadenaInvertida;
	}
}
