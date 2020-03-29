package learning.tjat.part2.study.service;

import learning.tjat.part2.Study;
import learning.tjat.part2.member.model.Member;
import learning.tjat.part2.member.service.MemberService;
import learning.tjat.part2.study.repository.StudyRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class StudyService {
  
  private final MemberService memberService;
  
  private final StudyRepository studyRepository;
  
  public Study createStudy(Long memberId, Study study) {
    Optional<Member> member = memberService.getMemberById(memberId);
  
    study.setOwner(
        member.orElseThrow(()
            -> new IllegalArgumentException("member must not be null"))
    );
  
    final Study newStudy = studyRepository.save(study);

    memberService.notify(newStudy);
  
    return newStudy;
  }

  public Study openStudy(Study study) {
    study.open();
    Study openedStudy = studyRepository.save(study);
    memberService.notify(openedStudy);
    
    return openedStudy;
  }
  
  
}
