package com.springboot.jewellerysystem;

import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

public class SpringSecurity {
//
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/**").permitAll()
//                .antMatchers("/admin/**").hasAnyRole("ADMIN")
//                .and();
////                .formLogin(
//                         form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/login")
//                        .defaultSuccessUrl("/admin/posts")
//                        .permitAll()
//                ).logout(
//                           logout -> logout
//	                       .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	                       .permitAll()
//	                       );
//        return http.build();
//	}
}
