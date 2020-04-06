package learning.tjat.part3.repository;

import learning.tjat.part3.model.entity.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
