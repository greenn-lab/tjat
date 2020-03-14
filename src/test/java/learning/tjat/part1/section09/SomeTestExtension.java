package learning.tjat.part1.section09;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class SomeTestExtension implements BeforeTestExecutionCallback {
  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    System.out.printf("i'll be start %s \n", context.getDisplayName());
  }
}
