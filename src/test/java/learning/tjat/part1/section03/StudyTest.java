package learning.tjat.part1.section03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
  
  @Test
  @DisplayName("스터디를 만들어요. #1")
  void should_create_study() {
    Study study = new Study();
    
    assertNotNull(study);
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        "스터디를 처음 만들면, DRAFT 상태여야 하겠죠.");
  }
  
  @Test
  @DisplayName("스터디를 만들어요. #2")
  void should_create_study_II() {
    final Study study = new Study();
    
    assertEquals(StudyStatus.DRAFT, study.getStatus(),
        () -> "스터디 처음 만들때 DRAFT 라고요!");
  }
  
  @Test
  @DisplayName("스터디 정원을 설정해요.")
  void should_set_limits() {
    final Study study = new Study(-10);
    
    assertAll(
        () -> assertEquals(StudyStatus.DRAFT, study.getStatus()),
        () -> assertTrue(study.getLimit() > 0)
    );
  }
  
  @Test
  @DisplayName("스터디 정원을 설정해요.#2")
  void should_set_limits_II() {
    
    assertThrows(IllegalArgumentException.class,
        () -> new Study(-10));
    
  }
  
}
