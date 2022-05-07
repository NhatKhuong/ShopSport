package com.se.config;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder user = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//		.withUser(user.username("john").password("123").roles("EMPLOYEE"))
//		.withUser(user.username("mary").password("123").roles("EMPLOYEE","MANAGER"))
//		.withUser(user.username("susan").password("123").roles("EMPLOYEE","ADMIN"));
		
		auth.jdbcAuthentication().dataSource(securityDataSource)
		.usersByUsernameQuery("select email, matKhau, trangThai from nguoiDung where email = ?")
		.authoritiesByUsernameQuery("select NguoiDung.email , quyen from phanQuyen join NguoiDung on PhanQuyen.maNguoiDung = NguoiDung.maNguoiDung where email = ?");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 CharacterEncodingFilter filter = new CharacterEncodingFilter();
		    filter.setEncoding("UTF-8");
		    filter.setForceEncoding(true);
		   		    http.addFilterBefore(filter,CsrfFilter.class);
		   		    
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/resources/css/**").permitAll()
		.antMatchers("resources/js**").permitAll()
		.antMatchers("/").permitAll()
		.antMatchers("/").permitAll()
//		.antMatchers("/").hasRole("KHACH")
		.antMatchers("/don-hang/**").hasRole("KHACH")
		.antMatchers("/quanly/**").hasRole("QUANLY")
		.antMatchers("/quanly/**").authenticated()
		.and()
		.formLogin()
		.loginPage("/dang-nhap")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout()
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
		http.csrf().disable();
	}

}
