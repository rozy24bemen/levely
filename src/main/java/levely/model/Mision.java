package levely.model;

import jakarta.persistence.*;

@Entity
@Table(name = "misiones")
public class Mision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private long xpRecompensa;
    private String condicion;

    public Mision() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public long getXpRecompensa() { return xpRecompensa; }
    public void setXpRecompensa(long xpRecompensa) { this.xpRecompensa = xpRecompensa; }
    public String getCondicion() { return condicion; }
    public void setCondicion(String condicion) { this.condicion = condicion; }
}
