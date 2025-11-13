package levely.repository;

import levely.model.Seguimiento;
import levely.model.keys.SeguimientoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguimientoRepository extends JpaRepository<Seguimiento, SeguimientoId> {
}
