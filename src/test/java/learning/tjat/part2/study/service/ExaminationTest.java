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
class ExaminationTest {
  
  @Test
  void shouldGetMember(
      @Mock MemberService memberService,
      @Mock StudyRepository studyRepository) {

    final Member member = Member.builder()
        .memberId(1L)
        .age(120)
        .email("tester@test.com")
        .build();
    
    final Study study = Study.builder()
        .id(123L)
        .owner(member)
        .build();

    when(memberService.getMemberById(1L))
        .thenReturn(Optional.of(member));
  
    when(studyRepository.save(study))
        .thenReturn(study);
  
    final StudyService studyService = new StudyService(
        memberService,
        studyRepository);
  
    final Study created = studyService.createStudy(1L, study);
    assertEquals(1L, created.getOwner().getMemberId());
    
  }

}
