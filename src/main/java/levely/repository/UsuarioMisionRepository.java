package levely.repository;

import levely.model.UsuarioMision;
import levely.model.keys.UsuarioMisionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioMisionRepository extends JpaRepository<UsuarioMision, UsuarioMisionId> {
}
