package plgym.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import plgym.BackAppController;
import plgym.domain.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/signup", "/js/**", "/css/**", "/assets/**").permitAll()
                .antMatchers("/dashboard").access("hasAnyAuthority('USER')")
                .antMatchers("/myworkout").access("hasAnyAuthority('USER')")
                .antMatchers("/discover").access("hasAnyAuthority('USER')")
                .antMatchers("/suggestions").access("hasAnyAuthority('USER')")
                .antMatchers("/profile").access("hasAnyAuthority('USER')")
//              .antMatchers("/admin").access("hasAnyAuthority('ADMIN')")
            .anyRequest()
                .authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll()
            .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        for (User user : BackAppController.userDB.getMap().values()) {
            auth.inMemoryAuthentication()
                .withUser(user.getEmail())
                .password(passwordEncoder().encode(user.getPassword()))
                .authorities("USER");
        }
    }


}
