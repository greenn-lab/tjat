package learning.tjat.part1.section04;

import learning.tjat.part1.section03.Study;
import learning.tjat.part1.section03.StudyStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class StudyTest {
  
  
  @Test
  @DisplayName("assumptions")
  void should_ignore_this_os() {
    final String ANDROMEDA = "Andromeda";

    System.setProperty("OS", ANDROMEDA);
    assumeTrue(ANDROMEDA.equals(System.getProperty("OS")));
    
    Study study = new Study();
    
    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
  @Test
  @DisplayName("assumptions #2")
  @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9})
  void should_ignore_this_jre() {
    Study study = new Study();
    
    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
  @Test
  @DisplayName("assumptions #3")
  @EnabledIfEnvironmentVariable(named = "HOME", matches = "(/\\w+)+")
  void should_ignore_this_env() {
    Study study = new Study();
    
    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
}
