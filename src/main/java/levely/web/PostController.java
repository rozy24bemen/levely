package levely.web;

import levely.model.Publicacion;
import levely.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Map<String, Object> body) {
        Long authorId = ((Number) body.get("authorId")).longValue();
        String content = (String) body.getOrDefault("content", "");
        String imagenUrl = (String) body.get("imagenUrl");
        Long categoriaId = body.get("categoriaId") != null ? ((Number) body.get("categoriaId")).longValue() : null;

        Publicacion p = postService.createPost(authorId, content, imagenUrl, categoriaId);
        return ResponseEntity.ok(Map.of(
                "id", p.getId(),
                "authorId", p.getAutor() != null ? p.getAutor().getId() : null,
                "content", p.getContenido(),
                "imagenUrl", p.getImagenUrl(),
                "categoriaId", p.getCategoria() != null ? p.getCategoria().getId() : null,
                "fechaCreacion", p.getFechaCreacion()
        ));
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<Publicacion> posts = postService.listPosts();
        return ResponseEntity.ok(posts.stream().map(p -> Map.of(
                "id", p.getId(),
                "authorId", p.getAutor() != null ? p.getAutor().getId() : null,
                "content", p.getContenido(),
                "imagenUrl", p.getImagenUrl(),
                "categoriaId", p.getCategoria() != null ? p.getCategoria().getId() : null,
                "fechaCreacion", p.getFechaCreacion()
        )).toList());
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<?> like(@PathVariable Long postId, @RequestBody Map<String, Object> body) {
        Long userId = ((Number) body.get("userId")).longValue();
        postService.likePost(postId, userId);
        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}
