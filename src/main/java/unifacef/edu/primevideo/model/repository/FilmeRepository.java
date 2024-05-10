package unifacef.edu.primevideo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unifacef.edu.primevideo.model.entity.FilmeEntity;

public interface FilmeRepository extends JpaRepository<FilmeEntity, Long> {
    // herda todos os métodos de crud relacionados a FilmeEntity
}
