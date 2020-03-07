package learning.tjat.part1.section07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LectureTest {
  
  @Test
  void shouldCreateLecture() {
    final Lecture lecture = new Lecture("TDD", 34);
  }
  
  @ParameterizedTest
  @CsvSource({"'Test Driven Development1', 11", "JUnit5, 13"})
  void shouldCreateByCvsSource(ArgumentsAccessor accessor) {
    final Lecture lecture = new Lecture(
        accessor.getString(0),
        accessor.getInteger(1));
    
    assertNotNull(lecture);
  }
  
  @ParameterizedTest
  @CsvSource({"'Test Driven Development1', 11", "JUnit5, 13"})
  void shouldCreateByCvsSourceElegantly(
      @AggregateWith(LectureAggregator.class) Lecture lecture) {
    
    assertNotNull(lecture);
  }
  
  static class LectureAggregator implements ArgumentsAggregator {
    @Override
    public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
      final String lectureName = accessor.getString(0);
      final Integer lectureChapter = accessor.getInteger(1);
      
      return new Lecture(lectureName, lectureChapter);
    }
  }
  
}
