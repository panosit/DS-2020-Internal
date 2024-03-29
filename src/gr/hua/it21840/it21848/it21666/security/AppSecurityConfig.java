package gr.hua.it21840.it21848.it21666.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	   @Autowired
	   DataSource dataSource;
	
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 

     auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                     .usersByUsernameQuery("select username,password, enabled from user where username=?")
                     .authoritiesByUsernameQuery("select username, authority from authorities where username=?");
 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
                 http.authorizeRequests()
                 .anyRequest().authenticated()
                 .and()
                 .formLogin().loginPage("/login")
                 .loginProcessingUrl("/authUser")
                 .permitAll()
                 .and()
                 .logout().permitAll()
                 .and()
                 .csrf().disable();
 }
 @Override
 public void configure(WebSecurity web) throws Exception {
 	web.ignoring()
     .antMatchers("/resources/**");
  //   .antMatchers("/api/**");
  }
 
 @Bean
 public PasswordEncoder passwordEncoder() {
         PasswordEncoder encoder = new BCryptPasswordEncoder();
         return encoder;
 }

}
