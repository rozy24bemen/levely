package levely;

import levely.model.Publicacion;
import levely.model.Usuario;
import levely.repository.PublicacionRepository;
import levely.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class LevelyApplication {

    public static void main(String[] args) {
        SpringApplication.run(LevelyApplication.class, args);
    }

    // Punto 7: semillas de datos mínimas
    @Bean
    CommandLineRunner seedData(UsuarioRepository usuarios, PublicacionRepository posts) {
        return args -> {
            if (usuarios.count() > 0) return; // evitar duplicados si ya existen

            Usuario a = new Usuario();
            a.setNombre("Alice");
            a.setEmail("alice@example.com");
            a.setBiografia("Exploradora de niveles");
            a.setXpTotal(0);
            a.setFechaRegistro(Instant.now());

            Usuario b = new Usuario();
            b.setNombre("Bob");
            b.setEmail("bob@example.com");
            b.setBiografia("Buscador de XP");
            b.setXpTotal(0);
            b.setFechaRegistro(Instant.now());

            usuarios.save(a);
            usuarios.save(b);

            Publicacion p1 = new Publicacion();
            p1.setAutor(a);
            p1.setContenido("Mi primer post en Levely ✨");
            p1.setFechaCreacion(Instant.now());

            Publicacion p2 = new Publicacion();
            p2.setAutor(b);
            p2.setContenido("Hola mundo desde Levely! 🎮");
            p2.setFechaCreacion(Instant.now());

            posts.save(p1);
            posts.save(p2);
        };
    }
}
package levely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LevelyApplication {
    public static void main(String[] args) {
        SpringApplication.run(LevelyApplication.class, args);
    }
}
