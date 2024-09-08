package utn.estudiantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.servicio.EstudianteServicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;
	//Esta clase lo que va a hacer es obtener un logger y escribir en consola
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	//Salto de linea Compatible con cualquier sistema operativo
	String nl = System.lineSeparator();


	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion......");
		//Levantamos la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion Finalizada......");
	}

	@Override
	public void run(String... args) throws Exception {
		//Logica de negocio
		//Lo hacemos en este metodo para que todo sea automatico
		logger.info(nl+"Ejecutando el metodo RUN de Spring....."+nl);

	}
}
