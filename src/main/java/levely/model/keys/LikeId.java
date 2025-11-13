package levely.model.keys;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LikeId implements Serializable {
    private Long usuarioId;
    private Long postId;

    public LikeId() {}

    public LikeId(Long usuarioId, Long postId) {
        this.usuarioId = usuarioId;
        this.postId = postId;
    }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
    public Long getPostId() { return postId; }
    public void setPostId(Long postId) { this.postId = postId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikeId likeId = (LikeId) o;
        return Objects.equals(usuarioId, likeId.usuarioId) && Objects.equals(postId, likeId.postId);
    }

    @Override
    public int hashCode() { return Objects.hash(usuarioId, postId); }
}
