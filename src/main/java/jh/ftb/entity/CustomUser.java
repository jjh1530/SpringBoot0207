package jh.ftb.entity;


import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

@Data
public class CustomUser extends User{

	private BootMember member;
	public CustomUser(BootMember member) {
		super(member.getUsername(), member.getPasssword(),
				AuthorityUtils.createAuthorityList("ROLE_"+ member.getRole().toString()));
		this.member=member;
	}

	
}
