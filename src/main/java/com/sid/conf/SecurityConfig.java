package com.sid.conf;

import com.sid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/registration").permitAll()
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .permitAll()
        .and()
        .logout()
        .invalidateHttpSession(true)
        .clearAuthentication(true)
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login?logout")
        .permitAll();
    }

   /* @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication().withUser("falllou22@gmail.com")
                .password("hJ7A1LVTCWTx.").roles("Admin");

        auth.inMemoryAuthentication().withUser("cheikh22@gmail.com")
                .password("9999").roles("Responsable");*/
        /*auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal,nom,password as credentials,prenom from user where email=?")
                .authoritiesByUsernameQuery("select email as principal, id_role as role from user where email=?")
                .passwordEncoder(new BCryptPasswordEncoder()).rolePrefix("ROLE_");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin();
        http.authorizeRequests().antMatchers("/client").hasRole("Admin");
        http.authorizeRequests().antMatchers("/delete","/form").hasRole("Responsable");
        http.exceptionHandling().accessDeniedPage("/403");
    }*/
}
