package utn.estudiantes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.estudiantes.modelo.Estudiante;


//@Repository //Esta era la manera de usarlo antes ahora solo extendemos de jpaRepository
public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

}
