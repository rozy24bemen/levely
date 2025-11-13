package levely.repository;

import levely.model.UsuarioLogro;
import levely.model.keys.UsuarioLogroId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLogroRepository extends JpaRepository<UsuarioLogro, UsuarioLogroId> {
}
