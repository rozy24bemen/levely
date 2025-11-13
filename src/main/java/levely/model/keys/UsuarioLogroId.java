package levely.model.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioLogroId implements Serializable {
    private Long usuarioId;
    private Long logroId;

    public UsuarioLogroId() {}

    public UsuarioLogroId(Long usuarioId, Long logroId) {
        this.usuarioId = usuarioId;
        this.logroId = logroId;
    }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getLogroId() { return logroId; }
    public void setLogroId(Long logroId) { this.logroId = logroId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioLogroId that = (UsuarioLogroId) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(logroId, that.logroId);
    }

    @Override
    public int hashCode() { return Objects.hash(usuarioId, logroId); }
}
