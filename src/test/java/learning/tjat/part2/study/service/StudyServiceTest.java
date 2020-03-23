package learning.tjat.part2.study.service;

import learning.tjat.part2.Study;
import learning.tjat.part2.member.model.Member;
import learning.tjat.part2.member.service.MemberService;
import learning.tjat.part2.study.repository.StudyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
 
  @Mock
  private MemberService memberService;
  
  @Mock
  private StudyRepository studyRepository;
  
  @Test
  void shouldCreateStudy() {
    
    final Study java = new Study();
    final StudyService service = new StudyService(
        memberService, studyRepository);
  
    final Optional<Member> member =
        Optional.of(Member.builder()
            .memberId(1L)
            .email("tester@test.com")
            .age(120).build());
    
    when(memberService.getMemberById(1L))
        .thenReturn(member);
  
    final Study study = service.createStudy(1L, java);
  }
  
}
