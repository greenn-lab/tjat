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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudyServiceTest {
 
  @Mock
  private MemberService memberService;
  
  @Mock
  private StudyRepository studyRepository;
  
  @Test
  void shouldCreateStudy() {
    final StudyService service = new StudyService(
        memberService, studyRepository);
  
    final Optional<Member> member =
        Optional.of(Member.builder()
            .memberId(1L)
            .email("tester@test.com")
            .age(120).build());
  
    final Study usingTestInJava = new Study();
  
    // GIVEN
    given/*when*/(memberService.getMemberById(1L))
        .willReturn/*thenReturn*/(member);
    given/*when*/(studyRepository.save(usingTestInJava))
        .willReturn/*thenReturn*/(usingTestInJava);
    
    // WHEN
    final Study study = service.createStudy(1L, usingTestInJava);
    
    // THEN
    // verify(memberService, times(1)).notify(study);
    then(memberService).should(times(1)).notify(study);
    //verify(memberService, never()).validate(any());
    then(memberService).should(never()).validate(any());

  }
  
}
