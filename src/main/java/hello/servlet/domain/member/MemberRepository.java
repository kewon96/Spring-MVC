package hello.servlet.domain.member;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음, 
 * 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {};

    /**
     * 객체 저장
     * @param member
     */
    public Member save(Member member) {
        member.setId((++sequence));
        store.put(member.getId(), member);

        return member;
    }

    /**
     * id값 가지고 객체 조회
     * @param id
     */
    public Member findById(Long id) {
        return store.get(id);
    }

    /**
     * 전체조회
     * @return store에 있는 데이터를 직접적으로 건들기싫어서 복사
     */
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    /** 테스트용 store 초기화 */
    public void clearStore() {
        store.clear();
    }
}
