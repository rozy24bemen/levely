package levely.model;

import jakarta.persistence.*;
import java.time.Instant;
import levely.model.keys.UsuarioLogroId;

@Entity
@Table(name = "usuarios_logros")
public class UsuarioLogro {
    @EmbeddedId
    private UsuarioLogroId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("logroId")
    @JoinColumn(name = "logro_id")
    private Logro logro;

    @Column(name = "fecha_desbloqueo")
    private Instant fechaDesbloqueo;

    public UsuarioLogro() {}

    public UsuarioLogroId getId() { return id; }
    public void setId(UsuarioLogroId id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Logro getLogro() { return logro; }
    public void setLogro(Logro logro) { this.logro = logro; }
    public Instant getFechaDesbloqueo() { return fechaDesbloqueo; }
    public void setFechaDesbloqueo(Instant fechaDesbloqueo) { this.fechaDesbloqueo = fechaDesbloqueo; }
}
