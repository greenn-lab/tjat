package learning.tjat.part2.study.repository;

import learning.tjat.part2.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {
}
