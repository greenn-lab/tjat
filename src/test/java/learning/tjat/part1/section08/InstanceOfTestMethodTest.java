package learning.tjat.part1.section08;

import learning.tjat.part1.section09.SomeTestExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InstanceOfTestMethodTest {
  
  @RegisterExtension
  SomeTestExtension someTestExtension
      = new SomeTestExtension();
  
  @Order(100)
  @Test
  void oneHundred() {
    System.out.println(this);
  }
  
  @Disabled
  @Order(1000)
  @Test
  void OneThousand() {
    System.out.println(this);
  }
  
  @Order(1)
  @Test
  void one() {
    System.out.println(this);
  }
}
