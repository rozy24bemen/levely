package levely.domain;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario autor;

    @Column(nullable = false, length = 2000)
    private String contenido;

    @Column(nullable = false)
    private Instant fechaCreacion = Instant.now();

    @Column(nullable = false)
    private long likesCount = 0;

    // getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Usuario getAutor() { return autor; }
    public void setAutor(Usuario autor) { this.autor = autor; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public Instant getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Instant fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public long getLikesCount() { return likesCount; }
    public void setLikesCount(long likesCount) { this.likesCount = likesCount; }
}
