package levely.model.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SeguimientoId implements Serializable {
    private Long seguidorId;
    private Long seguidoId;

    public SeguimientoId() {}

    public SeguimientoId(Long seguidorId, Long seguidoId) {
        this.seguidorId = seguidorId;
        this.seguidoId = seguidoId;
    }

    public Long getSeguidorId() { return seguidorId; }
    public void setSeguidorId(Long seguidorId) { this.seguidorId = seguidorId; }
    public Long getSeguidoId() { return seguidoId; }
    public void setSeguidoId(Long seguidoId) { this.seguidoId = seguidoId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeguimientoId that = (SeguimientoId) o;
        return Objects.equals(seguidorId, that.seguidorId) && Objects.equals(seguidoId, that.seguidoId);
    }

    @Override
    public int hashCode() { return Objects.hash(seguidorId, seguidoId); }
}
