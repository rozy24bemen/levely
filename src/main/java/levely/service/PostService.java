package levely.service;

import levely.model.*;
import levely.model.keys.LikeId;
import levely.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Comparator;
import java.util.List;

@Service
public class PostService {
    private final PublicacionRepository publicacionRepository;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaRepository categoriaRepository;
    private final LikeRepository likeRepository;
    private final XpService xpService;

    public PostService(PublicacionRepository publicacionRepository,
                       UsuarioRepository usuarioRepository,
                       CategoriaRepository categoriaRepository,
                       LikeRepository likeRepository,
                       XpService xpService) {
        this.publicacionRepository = publicacionRepository;
        this.usuarioRepository = usuarioRepository;
        this.categoriaRepository = categoriaRepository;
        this.likeRepository = likeRepository;
        this.xpService = xpService;
    }

    @Transactional
    public Publicacion createPost(Long authorId, String contenido, String imagenUrl, Long categoriaId) {
        Usuario autor = usuarioRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + authorId));
        Categoria categoria = null;
        if (categoriaId != null) {
            categoria = categoriaRepository.findById(categoriaId)
                    .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada: " + categoriaId));
        }
        Publicacion p = new Publicacion();
        p.setAutor(autor);
        p.setContenido(contenido);
        p.setImagenUrl(imagenUrl);
        p.setCategoria(categoria);
        p.setFechaCreacion(Instant.now());
        Publicacion saved = publicacionRepository.save(p);
        xpService.addXp(autor, 100);
        return saved;
    }

    @Transactional
    public void likePost(Long postId, Long userId) {
        Publicacion post = publicacionRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post no encontrado: " + postId));
        Usuario user = usuarioRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + userId));

        LikeId id = new LikeId(user.getId(), post.getId());
        if (!likeRepository.existsById(id)) {
            Like like = new Like();
            like.setId(id);
            like.setUsuario(user);
            like.setPost(post);
            like.setFechaLike(Instant.now());
            likeRepository.save(like);
            // +1 XP al autor del post
            xpService.addXp(post.getAutor(), 1);
        }
    }

    @Transactional(readOnly = true)
    public List<Publicacion> listPosts() {
        List<Publicacion> all = publicacionRepository.findAll();
        all.sort(Comparator.comparing(Publicacion::getFechaCreacion, Comparator.nullsLast(Comparator.naturalOrder())).reversed());
        return all;
    }
}
