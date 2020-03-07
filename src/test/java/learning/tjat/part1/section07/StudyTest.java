package learning.tjat.part1.section07;

import learning.tjat.part1.section03.Study;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudyTest {
  
  @RepeatedTest(5)
  void shouldRepeat() {
    Study study = new Study();
    assertNotNull(study);
  }
  
  @RepeatedTest(5)
  void shouldRepeatWithInfo(RepetitionInfo info) {
    Study study = new Study();
    assertNotNull(study);
  
    final String message = String.format("repeated %d / %d",
        info.getCurrentRepetition(),
        info.getTotalRepetitions());
   
    System.out.println(message);
  }

  @DisplayName("파라미터를 가진 테스트들...")
  @ParameterizedTest(name = "{index}: {displayName}")
  @ValueSource(strings = {"A", "B", "C"})
  @EmptySource
  void shouldGet(@ConvertWith(ABCSongConverter.class) String parameter) {
    System.out.printf("Wow, let's start alphabet song~ %s \n", parameter);
  }
  
  static class ABCSongConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
      return "[ " + source.toString() + " ]";
    }
  }
}
