package learning.tjat.part2;

import learning.tjat.part2.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Study {
  
  @Id
  private Long id;
  
  private String name;
  
  @Getter
  private Status status = Status.READY;
  
  @ManyToOne
  @Setter
  @Getter
  private Member owner;
  
  @Getter
  private LocalDateTime opened;
  
  public void open() {
    opened = LocalDateTime.now();
    status = Status.OPENED;
  }
  
  public static enum Status {
    READY, OPENED
  }
}
