package jh.ftb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // 환경설정 파일
public class SecurityConfigration {
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Bean // 패스워드 인코딩을 메모리에 로딩
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf().disable(); //테스트용
		http.authorizeHttpRequests()
			.antMatchers("/", "/member/**").permitAll() // member는 전부 허용
			.antMatchers("/board/**").authenticated()  //인증을 해야한다 board경로는
			
			.and()         //다음으로
			.formLogin()   //사용자가 지정한 로그인폼으로
			.loginPage("/member/login")  // 사용자가 지정한 로그인 폼
			.defaultSuccessUrl("/board/list")     // 로그인이 성공하면
			
			.and()
			.logout()				//사용자가 지정한 로그아웃으로
			.logoutUrl("/member/logout")  // 로그아웃폼
			.logoutSuccessUrl("/");    //로그아웃이 성공하면 가는 경로
		
			http.userDetailsService(userDetailsServiceImpl);  // http 정보를 세팅하기 위함
			
	return http.build();
	}
}
