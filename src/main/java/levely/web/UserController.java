package levely.web;

import levely.model.Usuario;
import levely.repository.UsuarioRepository;
import levely.service.XpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UsuarioRepository usuarioRepository;
    private final XpService xpService;

    public UserController(UsuarioRepository usuarioRepository, XpService xpService) {
        this.usuarioRepository = usuarioRepository;
        this.xpService = xpService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> body) {
        Usuario u = new Usuario();
        u.setNombre(body.getOrDefault("nombre", ""));
        u.setEmail(body.getOrDefault("email", ""));
        u.setPassword(body.getOrDefault("password", ""));
        u.setBiografia(body.getOrDefault("biografia", ""));
        u.setFotoPerfil(body.getOrDefault("fotoPerfil", ""));
        u.setFechaRegistro(Instant.now());
        u.setXpTotal(0);
        Usuario saved = usuarioRepository.save(u);
        return ResponseEntity.ok(Map.of(
                "id", saved.getId(),
                "nombre", saved.getNombre(),
                "email", saved.getEmail(),
                "xp", saved.getXpTotal(),
                "level", xpService.getLevel(saved)
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(u -> ResponseEntity.ok(Map.of(
                        "id", u.getId(),
                        "nombre", u.getNombre(),
                        "email", u.getEmail(),
                        "biografia", u.getBiografia(),
                        "xp", u.getXpTotal(),
                        "level", xpService.getLevel(u)
                )))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> listUsers() {
        List<Usuario> all = usuarioRepository.findAll();
        return ResponseEntity.ok(all.stream().map(u -> Map.of(
                "id", u.getId(),
                "nombre", u.getNombre(),
                "email", u.getEmail(),
                "xp", u.getXpTotal(),
                "level", xpService.getLevel(u)
        )).toList());
    }
}
