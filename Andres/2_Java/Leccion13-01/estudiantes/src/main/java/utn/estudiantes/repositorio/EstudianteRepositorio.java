package utn.estudiantes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import utn.estudiantes.modelo.Estudiantes2022;


//@Repository //Esta era la manera de usarlo antes ahora solo extendemos de jpaRepository
public interface EstudianteRepositorio extends JpaRepository<Estudiantes2022, Integer> {

}
