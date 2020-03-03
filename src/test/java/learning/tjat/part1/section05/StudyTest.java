package learning.tjat.part1.section05;

import learning.tjat.part1.section03.Study;
import learning.tjat.part1.section03.StudyStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("all-for-test")
class StudyTest {
  
  @Test
  @DisplayName("tagging test")
  @Tag("for-unit-test")
  void should_execute_for_unit_test() {
    Study study = new Study();
    assertNotNull(study);
  }
  
  @Test
  @DisplayName("tagging test")
  @Tag("for-TDD")
  void should_execute_for_tdd() {
    Study study = new Study();
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
}
