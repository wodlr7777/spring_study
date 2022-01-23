package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member=new Member();
        member.setName("spring");
        repository.save(member);
        Member result=repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByname(){
        Member member1=new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2=new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result=repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member3=new Member();
        member3.setName("spring1");
        repository.save(member3);

        Member member4=new Member();
        member4.setName("spring2");
        repository.save(member4);

        List<Member> list=repository.findAll();
        assertThat(list.size()).isEqualTo(2);
    }

}
