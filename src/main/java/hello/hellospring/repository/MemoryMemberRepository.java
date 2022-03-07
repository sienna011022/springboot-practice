package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //Map정의 store는임의로 우리가 붙여준 이름
    private static Map<Long,Member> store = new HashMap<>();
    //번호를 붙이기 위한 상수 sequence 정의
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        //name은 넘어오고 id만 정의
        member.setId(++sequence);
        //맵 형태의 간이 인터페이스에 정보 넣기
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //store에 있는 id를 가지고옴.->map함수 get
        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        //자바의 한 기능 stream 어떤 조건에 맞는 값을 얻을 수 있다.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //리스트 형식이니 map을 리스트로 형 변환 후 반환해줌.
        return new ArrayList<>(store.values());

    }
}
