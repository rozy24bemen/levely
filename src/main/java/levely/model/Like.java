package levely.model;

import jakarta.persistence.*;
import java.time.Instant;
import levely.model.keys.LikeId;

@Entity
@Table(name = "likes")
public class Like {
    @EmbeddedId
    private LikeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("postId")
    @JoinColumn(name = "post_id")
    private Publicacion post;

    @Column(name = "fecha_like")
    private Instant fechaLike;

    public Like() {}

    public LikeId getId() { return id; }
    public void setId(LikeId id) { this.id = id; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Publicacion getPost() { return post; }
    public void setPost(Publicacion post) { this.post = post; }
    public Instant getFechaLike() { return fechaLike; }
    public void setFechaLike(Instant fechaLike) { this.fechaLike = fechaLike; }
}
