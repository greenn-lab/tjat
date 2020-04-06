package learning.tjat.part3.service;

import learning.tjat.part3.model.entity.Member;
import learning.tjat.part3.model.entity.Study;
import learning.tjat.part3.repository.MemberRepository;
import learning.tjat.part3.repository.StudyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class StudyServiceTest {
  
  @Autowired
  private MemberService memberService;
  
  @Autowired
  private StudyService studyService;
  
  @Test
  void shouldCreateStudyWithMember() {
    final Optional<Member> member = Optional.of(
        Member.builder()
            .name("cobid")
            .age(19)
            .gender(Member.Gender.UNKNOWN)
            .build()
    );
    
    // GIVEN
    memberService.save(member.get());
    
    // WHEN
    Study tdd = studyService.createStudy("TDD", 1L);
    
    // THEN
    assertNotNull(tdd);
  }
  
}
