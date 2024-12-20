package UTN.datos;

import UTN.dominio.Estudiante;
import static UTN.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class EstudianteDAO {
    //Metodo listar
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        //Creamos algunos objetos que sin necesarios para comunicarnos con la base de datos
        PreparedStatement ps; //Envia la sentencia a la base de datos
        ResultSet rs; //Nos permite almacenar lo que nos da la sentencia
        //Creamos un objeto de tipo Conexion
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setNombre(rs.getString("apellido"));
                estudiante.setNombre(rs.getString("telefono"));
                estudiante.setNombre(rs.getString("email"));
                //Lo agregamos a la lista estudiantes
                estudiantes.add(estudiante);
            }//Fin While
        } catch (Exception e) {
            System.out.println("Ocurrio un ERROR al seleccionar Datos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un ERROR al cerrar la conexion: " + e.getMessage());
            }
        }//Fin Finally

        return estudiantes;
    }//Fin metodo Listar

    //Metodo por id -> find by id
    public boolean buscarEstudiantePorId(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022 = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            rs = ps.executeQuery();
            if (rs.next()) {
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                return true;
            }//Fin if
        } catch (Exception e) {
            System.out.println("Ocurrio un ERROR al buscar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un ERROR al Cerrar la conexion: " + e.getMessage());
            }//Fin catch
        }//Fin Finally
        return false;
    }//fin del metodo buscarEstudiantePorId


    //Metodo agregar un nuevo estudiante
    public boolean agregarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();
        String sql = "INSERT INTO estudiantes2022(nombre, apellido, telefono, email) VALUES(?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Ocurrio un ERROR al agregar el estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.printf("Ocurrio un ERROR al cerrar la conexion: " + e.getMessage());
            }//Fin catch
        }//fin Finally
        return false;
    }//Fin metodo agregarEstudiante

    //Metodo para Modificar Estudiantes
    public boolean modificarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre =?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR al modificar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un ERROR al cerrar la conexion: " + e.getMessage());
            }//Fin catch
        }//Fin finally
        return false;
    }//Fin del metodo modificarEstudiante

    //Metodo para Eliminar Estudiante
    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        }//Fin try - catch
        finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }//Fin try - catch
        }//Fin Finally
        return false;
    }//Fin Eliminar estudiante


    public static void main(String[] args) {
        //Listar los estudiantes
        var estudianteDao = new EstudianteDAO();
//        System.out.println("Listado de estudiantes: ");
//        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
//        estudiantes.forEach(System.out::println);//Funcion lambda para imprimir

        //Buscar por ID
//        var estudiante1 = new Estudiante(1);
//        System.out.println("Estudiante antes de la busqueda: "+estudiante1);
//        var encontrado = new EstudianteDAO().buscarEstudiantePorId(estudiante1);
//        if(encontrado){
//            System.out.println("Estudiante encontrado!! -> " + estudiante1);
//        }else{
//            System.out.printf("No Se encontro el estudiante: " + estudiante1);
//        }

        //Agregar Estudiante
//        var nuevoEstudiante = new Estudiante("Carlos", "Lara", "5492604587934", "carlosl@mail.com");
//        var agregado = estudianteDao.agregarEstudiante(nuevoEstudiante);
//        if(agregado){
//            System.out.println("Estudiante agregado: "+nuevoEstudiante);
//        }else{
//            System.out.println("No se han agregado estudiante: "+nuevoEstudiante);
//        }

//        //Modificar estudiante
//        var estudianteModificado = new Estudiante(1,"Juan Carlos", "Juarez", "5492604852169", "jcjuarez@mail.com");
//        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);
//        if(modificado){
//            System.out.println("Estudiante MODIFICADO: "+estudianteModificado);
//        }else{
//            System.out.println("Estudiante NO MODIFICADO: "+estudianteModificado);

        //Eliminar estudiante con id 3
        var estudianteEliminar = new Estudiante(3);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if (eliminado)
            System.out.println("Estudiante eliminado: " + estudianteEliminar);
        else
            System.out.println("No se elimino estudiante: " + estudianteEliminar);

        //Listar los estudiantes
        System.out.printf("Listado de estudiantes: ");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);//Funcion lambda para imprimir


    }//Fin Main

}//Fin Clase EstudianteDAO


