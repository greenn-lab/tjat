package learning.tjat.part1.section03;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

public class Study {
  
  @Getter
  private final int limit;
  
  @Getter
  private StudyStatus status;

  public Study() {
    this.limit = 1;
  }
  
  public Study(final int limit) {
    if (limit < 0) {
      throw new IllegalArgumentException("greater then zero.");
    }
    
    this.limit = limit;
  }
  
}
