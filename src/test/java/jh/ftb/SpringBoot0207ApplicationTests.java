package jh.ftb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import jh.ftb.entity.BootMember;
import jh.ftb.entity.Role;
import jh.ftb.repository.BootMemberRepository;

@SpringBootTest
class SpringBoot0207ApplicationTests {

	@Autowired
	private BootMemberRepository bootMemberRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	void createMember() {
		BootMember m = new BootMember();
		m.setUsername("jjh");
		m.setPasssword(encoder.encode("jjh"));
		m.setName("정재훈");
		m.setRole(Role.ADMIN);
		m.setEnabled(true);
		bootMemberRepository.save(m); // 회원가입
	}

}
