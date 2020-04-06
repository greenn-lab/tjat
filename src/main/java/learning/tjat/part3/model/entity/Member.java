package learning.tjat.part3.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Member {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String name;
  private int age;
  private Gender gender;
  
  @OneToMany(mappedBy = "owner")
  private List<Study> studies = new ArrayList<>();
  
  public enum Gender {
    MALE, FEMALE, UNKNOWN
  }
  
  @Converter(autoApply = true)
  public static class GenderAttribute implements AttributeConverter<Gender, String> {
  
    @Override
    public String convertToDatabaseColumn(Gender attribute) {
      return attribute.toString();
    }
  
    @Override
    public Gender convertToEntityAttribute(String dbData) {
      return Gender.valueOf(dbData);
    }
  }
}
