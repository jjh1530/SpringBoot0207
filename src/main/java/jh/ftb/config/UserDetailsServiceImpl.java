package jh.ftb.config;

import org.springframework.stereotype.Service;

import jh.ftb.entity.BootMember;
import jh.ftb.entity.CustomUser;
import jh.ftb.repository.BootMemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private BootMemberRepository bootMemberRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 BootMember bootMember = bootMemberRepository.findById(username).get();  
		if (bootMember == null) {
			throw new UsernameNotFoundException(username + " 없음");
		}
		return new CustomUser(bootMember); // User(3가지 권한 정보) + Member정보(다른 정보들)
	}
}
