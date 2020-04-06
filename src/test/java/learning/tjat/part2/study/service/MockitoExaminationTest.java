package learning.tjat.part2.study.service;

import learning.tjat.part2.Study;
import learning.tjat.part2.member.service.MemberService;
import learning.tjat.part2.study.repository.StudyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
public class MockitoExaminationTest {
  
  @Test
  void shouldOpenStudyIsShowAbleToAnotherUsers(
      @Mock final MemberService memberService,
      @Mock final StudyRepository studyRepository) {

    // GIVEN
    final StudyService studyService = new StudyService(memberService, studyRepository);
    final Study theJavaTest = Study.builder()
        .id(1L)
        .name("더 자바, 테스트")
        .build();
  
    given(studyRepository.save(theJavaTest))
        .willReturn(theJavaTest);
  
    // WHEN
    studyService.openStudy(theJavaTest);
  
    // THEN
    // TODO study의 status가 OPENED로 변경됐는지 확인
    //assertEquals(Study.Status.OPENED, theJavaTest.getStatus());
    
    // TODO study의 openedDataTime이 null이 아닌지 확인
    assertNotNull(theJavaTest.getOpened());
    
    // TODO memberService의 notify(study)가 호출 됐는지 확인.
    then(memberService).should().notify(theJavaTest);
  
  }
}
