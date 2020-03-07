package learning.tjat.part1.section06;

import learning.tjat.part1.section03.Study;
import learning.tjat.part1.section03.StudyStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag("all-for-test")
class StudyTest {
  
  @ForUnitTest
  @DisplayName("tagging test")
  void should_execute_for_unit_test() {
    Study study = new Study();
    assertNotNull(study);
  }
  
  @ForTDDTest
  @DisplayName("tagging test")
  void should_execute_for_tdd() {
    Study study = new Study();
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
}
