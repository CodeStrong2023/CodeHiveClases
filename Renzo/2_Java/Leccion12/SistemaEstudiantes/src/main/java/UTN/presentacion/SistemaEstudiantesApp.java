package UTN.presentacion;
import UTN.dominio.Estudiante;
import UTN.datos.EstudianteDAO;
import java.util.Scanner;


public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false; //Variable para settear el bucle
        var consola = new Scanner(System.in); //Lee la informacion en consola

        //se crea una instancia de la clase servicio, esto se hace fuera del ciclo while
        var estudianteDao = new EstudianteDAO(); //Esta instancia debe hacerce 1 vez
        while(!salir){
            try{
                mostrarMenu(); //Aca mostramos el menu
                salir = ejecutarOpciones(consola, estudianteDao); //Este sera el metodo que devolvera un booleano
            }catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar la operacion: "+e.getMessage());
            }//fin Try - Catch
        }//Fin While
    }//fin MAin

    private static void mostrarMenu(){
        System.out.print("""
                
                ************ Sistema de Estudiantes ************
                
                1. Listar Estudiantes
                2. Buscar Estudiantes
                3. Agregar Estudiante
                4. Modificar estudiante
                5. Eliminar estudiante
                6. Salir
                Elige una opcion: 
                
                """);
    }//Fin de mostrarMenu()

    //Metodo para ejecutar las opciones, va a regresar un valor booleano, ya que él que puede
    //modificar el valor de la variable salir, si es verdadero termina el ciclo while
    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { //Listar estudiantes
                System.out.println("Listado de Estudiantes...");
                //No muestra informacion, solo recupera la info y regresa una lista
                var estudiantes = estudianteDAO.listarEstudiantes(); //Recibe el listado
                //vamos a iterar cada objeto de tipo estudiante
                estudiantes.forEach(System.out::println);//Para imprimir la lista
            }//Fin caso 1
            case 2 -> {//Buscar estudiante por id
                System.out.println("Introduce el id_estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("Estudiante NO encontrado: "+estudiante);
            }//Fin caso 2
            case 3 ->{//Agregar un estudiante
                System.out.println("Agregar estudiante: ");
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //Crear objeto estudiante(sin id)
                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: "+estudiante);
                else
                    System.out.println("Estudiante NO agregado: "+estudiante);
            }//Fin case 3
            case 4 -> {//Modificar estudiante
                System.out.println("Modificar estudiante: ");
                //Especificamos el id del objeto a modificar
                System.out.println("Id Estudiante a modificar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.println("Nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Apellido: ");
                var apellido = consola.nextLine();
                System.out.println("Telefono: ");
                var telefono = consola.nextLine();
                System.out.println("Email: ");
                var email = consola.nextLine();
                //Crea el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: "+estudiante);
                else
                    System.out.println("Estudiante NO modificado: "+estudiante);
            }//Fin case 4
            case 5 ->{//Eliminar estudiante
                System.out.println("Eliminar Estudiante");
                System.out.println("Id Estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante Eliminado: "+estudiante);
                else
                    System.out.println("Estudiante NO eliminado: "+estudiante);
            }//Fin case 5
            case 6 ->{//Salir
                System.out.println("Hasta Pronto!!!!");
                salir = true;
            }//Fin case 6
            default -> System.out.println("Opcion no reconocida, ingrese otra opcion");
        }//fin Switch
        return salir;

    }//Fin ejecutarOpciones()
}//Fin de la clase sistemaEstudiantesApp
