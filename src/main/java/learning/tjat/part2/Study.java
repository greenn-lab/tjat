package learning.tjat.part2;

import learning.tjat.part2.member.model.Member;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {
  
  @Id
  private Long id;
  
  @ManyToOne
  @Setter
  @Getter
  private Member owner;
  
}
