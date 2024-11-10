package utn.tienda_libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import utn.tienda_libros.vista.LibroFrom;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TiendaLibrosApplication.class, args);

		ConfigurableApplicationContext contextoSpring =
				new SpringApplicationBuilder(TiendaLibrosApplication.class)
						.headless(false)
						.web(WebApplicationType.NONE)
						.run(args);

		//Ejecutamos el codigo para cargar el formulario
		java.awt.EventQueue.invokeLater(()->{ //Metodo Lambda
			//Obtenemos el objeto from a traves del spring
			LibroFrom libroFrom = contextoSpring.getBean(LibroFrom.class);
			libroFrom.setVisible(true);
		});
	}

}
