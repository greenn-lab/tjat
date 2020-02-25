package learning.tjat.section01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudyTest {
  
  @Test
  void test() {
    Study study = new Study();
    
    assertNotNull(study);
  }
  
  @BeforeAll
  public static void setup() {
    System.out.println("@BeforeAll");
  }
  
  @AfterAll
  public static void cleanup() {
    System.out.println("@AfterAll");
  }
  
  @BeforeEach
  public void before() {
    System.out.println("@BeforeEach");
  }
  
  @AfterEach
  public void after() {
    System.out.println("@AfterEach");
  }
}
