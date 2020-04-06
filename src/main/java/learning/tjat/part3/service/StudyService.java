package learning.tjat.part3.service;

import learning.tjat.part3.model.entity.Member;
import learning.tjat.part3.model.entity.Study;
import learning.tjat.part3.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudyService {

  private final StudyRepository studyRepository;

  private final MemberService memberService;

  public Study createStudy(final String name, final Long memberId) {
    Optional<Member> member = memberService.findMember(memberId);
    
    final Study study = Study.builder()
        .name(name)
        .owner(member.get())
        .status(Study.Status.READY)
        .build();

    return studyRepository.save(study);
  }
  
}
