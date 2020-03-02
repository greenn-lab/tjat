package learning.tjat.part1.section00;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AppTest {
  
  @Test
  void create() {
    App app = new App();
    assertNotNull(app);
  }
  
}
