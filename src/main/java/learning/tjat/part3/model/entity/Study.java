package learning.tjat.part3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Study {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String name;
  
  @Enumerated(EnumType.STRING)
  private Status status;
  
  @ManyToOne
  private Member owner;
  
  private LocalDateTime opened;
  
  public void open() {
    opened = LocalDateTime.now();
    status = Status.OPENED;
  }
  
  public enum Status {
    READY, OPENED
  }
}
