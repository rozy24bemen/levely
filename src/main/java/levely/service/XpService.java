package levely.service;

import levely.model.Usuario;
import levely.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class XpService {
    private final UsuarioRepository usuarioRepository;

    public XpService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public long addXp(Usuario usuario, long amount) {
        long updated = Math.max(0, usuario.getXpTotal() + amount);
        usuario.setXpTotal(updated);
        usuarioRepository.save(usuario);
        return updated;
    }

    public int getLevel(Usuario usuario) {
        double xp = usuario.getXpTotal();
        return 1 + (int)Math.floor(Math.sqrt(xp / 100.0));
    }
}
