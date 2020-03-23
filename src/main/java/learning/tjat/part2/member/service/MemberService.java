package learning.tjat.part2.member.service;

import learning.tjat.part2.member.model.Member;

import java.util.Optional;

public interface MemberService {

  Optional<Member> getMemberById(Long memberId);

}
