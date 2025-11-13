package levely.model.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioMisionId implements Serializable {
    private Long usuarioId;
    private Long misionId;

    public UsuarioMisionId() {}

    public UsuarioMisionId(Long usuarioId, Long misionId) {
        this.usuarioId = usuarioId;
        this.misionId = misionId;
    }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getMisionId() { return misionId; }
    public void setMisionId(Long misionId) { this.misionId = misionId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioMisionId that = (UsuarioMisionId) o;
        return Objects.equals(usuarioId, that.usuarioId) && Objects.equals(misionId, that.misionId);
    }

    @Override
    public int hashCode() { return Objects.hash(usuarioId, misionId); }
}
