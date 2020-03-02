package learning.tjat.part1.section02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class NamingTest {
  
  @Test
  @DisplayName("학습 테스트에요.")
  void test() {
    Naming naming = new Naming();
    assertNotNull(naming);
  }
  
  @Test
  @DisplayName("또다른 학습 테스트에요.")
  void test2() {
    Naming naming = new Naming();
    assertNotNull(naming);
  }
  
}
