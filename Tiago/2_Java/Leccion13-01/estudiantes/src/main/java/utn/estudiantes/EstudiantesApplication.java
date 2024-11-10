package utn.estudiantes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.servicio.EstudianteServicio;

import java.util.List;
import java.util.Scanner;

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
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin del ciclo while

	}

	private void mostrarMenu(){
		//logger.info(nl);
		logger.info("""
				****** Sistema de Estudiantes ******
				1. Listar Estudiantes
				2. Buscar Estudiante
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				
				Elija una Opcion: """);
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> {//Listar Estudiantes
				logger.info(nl+"Listado de estudiantes: "+nl);
				List<Estudiantes2022> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));
			}//fin case 1
			case 2 -> {//Buscar estudiante por id
				logger.info("Digite el id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiantes2022 estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null)
					logger.info("Estudiante encontrado: "+estudiante + nl);
				else
					logger.info("Estudiante NO encontrado: "+ estudiante + nl);
			}//fin case 2
			case 3 -> {//Agregar estudiante
				logger.info("Agregar Estudiante: "+nl);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Telefono: ");
				var telefono = consola.nextLine();
				logger.info("email: ");
				var email = consola.nextLine();

				//Crear el objeto estudiante sin el id
				var estudiante = new Estudiantes2022();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante agregado: "+ estudiante+ nl);
			}//fin case 3
			case 4 ->{//Modificar Estudiante
				logger.info("Modificar Estudiante: "+nl);
				logger.info("Ingrese el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());

				//Buscamos el estudiante a modificar
				Estudiantes2022 estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Telefono: ");
					var telefono = consola.nextLine();
					logger.info("email: ");
					var email = consola.nextLine();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: "+estudiante+nl);
				}else{
					logger.info("Estudiante NO encontradocon el id: "+idEstudiante+nl);
				}//Fin if - else
			}//fin case 4
			case 5 ->{//Eliminar estudiante
				logger.info("Eliminar estudiante "+nl);
				logger.info("Digite el id estudiante: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());

				//Buscamos el id estudiante a eliminar
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: "+estudiante+nl);

				}else{
					logger.info("Estudiante NO encontrado con el id: "+idEstudiante+nl);
				}
			}//fin case 5
			case 6 ->{//Salir
				logger.info("Hasta pronto!..."+nl+nl);
				salir = true;
			}
			default -> logger.info("Opcion no reconocida: "+opcion+nl);
		}//Fin del switch
		return salir;
	}//Fin metodo ejecutar Opciones


}
