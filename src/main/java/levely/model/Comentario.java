package levely.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Publicacion post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    private String contenido;

    @Column(name = "fecha_creacion")
    private Instant fechaCreacion;

    public Comentario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Publicacion getPost() { return post; }
    public void setPost(Publicacion post) { this.post = post; }
    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public Instant getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Instant fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
