package jh.ftb.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BootMember {

	@Id
	private String username;  //ID
	private String passsword;
	private String name; //이름
	@Enumerated(EnumType.STRING)  //열거형 타입 스트링으로 선언
	private Role role;
	private boolean enabled;
	
}
