package org.insta.application.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    configure 메소드를 통해 정적 자원들에 대해서는 Security를 적용하지 않음을 추가한다.
//    configure 메소드를 통해 어떤 요청에 대해서는 로그인을 요구하고, 어떤 요청에 대해서 로그인을 요구하지 않을지 설정한다.
//    form 기반의 로그인을 활용하는 경우 로그인 URL, 로그인 성공시 전달할 URL, 로그인 실패 URL 등에 대해서 설정한다.

    /**
     * /index 에 대해서는 로그인이 성공한 경우에만 접근가능하고, /admin에 대해서는 로그인 후에 ROLE_ADMIN 역할을 갖고 있는 경우에만 접근가능하도록 설정해준다.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable().authorizeRequests()
//                .antMatchers("/index").authenticated()
                .antMatchers("/index").permitAll()
                // /admin 요청에 대해서는 ROLE_ADMIN 역할을 가지고 있어야 함
                .antMatchers("/admin").hasRole("ADMIN")
//                .anyRequest().authenticated() -> 나머지는 모두 인증해야한다!라는 로직
                // 나머지 요청에 대해서는 로그인을 요구하지 않음
                .and()
                // 로그인하는 경우에 대해 설정함
                .formLogin()
                // 로그인 페이지를 제공하는 URL을 설정함
                .loginPage("/auth/login")
                // 로그인 성공 URL을 설정함
                .loginProcessingUrl("/auth/loginProc")
                // 로그인 실패 URL을 설정함
                .failureForwardUrl("/index")
                .permitAll()
                .and()
                .addFilterBefore(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManager());
        customAuthenticationFilter.setFilterProcessesUrl("/user/login");
        customAuthenticationFilter.setAuthenticationSuccessHandler(customLoginSuccessHandler());
        customAuthenticationFilter.afterPropertiesSet();
        return customAuthenticationFilter;
    }

    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
}
