package learning.tjat.part3.service;

import learning.tjat.part3.model.entity.Member;
import learning.tjat.part3.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
  
  private final MemberRepository memberRepository;
  
  public Optional<Member> findMember(final Long id) {
    return Optional.of(memberRepository.getOne(id));
  }
  
  public void save(Member member) {
    memberRepository.save(member);
  }
}
