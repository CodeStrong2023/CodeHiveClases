package utn.estudiantes.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
//Boilerplate - Codigo repetitivo ----> Lo simplificamos con los @ de abajo
@Data //Aca crea los metodos get y set
@NoArgsConstructor //Nos va a agregar el constructor vacio
@AllArgsConstructor //Constructor con todos los argumentos
@ToString //Agrega el metodo To String
public class Estudiantes2022 {
    @Id //Este id es para que vaya agregando el orden de la llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto es para llaves autoincrementales
    private Integer idestudiantes2022;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
