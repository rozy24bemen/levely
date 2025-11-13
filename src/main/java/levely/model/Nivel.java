package levely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "niveles")
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private long xpMinima;

    public Nivel() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public long getXpMinima() { return xpMinima; }
    public void setXpMinima(long xpMinima) { this.xpMinima = xpMinima; }
}
