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
            .antMatchers("/").access("hasAnyAuthority('USERS', 'ADMIN')")
            // .antMatchers("/admin").access("hasAnyAuthority('ADMIN')")
            .anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login").permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO: Se pa é com esse withUser usado multiplas vezes que conseguiremos adicionar vários usuários, bastando trazer o userList
        auth.inMemoryAuthentication().withUser("user")
            .password(passwordEncoder().encode("password")).authorities("USER");
        auth.inMemoryAuthentication().withUser("sera")
            .password(passwordEncoder().encode("senha")).authorities("USER");
        auth.inMemoryAuthentication().withUser("qualquercoisa")
            .password(passwordEncoder().encode("senha")).authorities("USER");
        System.out.println("Bora fi");

        for (User user : BackAppController.userDB.getMap().values()) {
            // System.out.println(id);
            auth.inMemoryAuthentication().withUser(user.getEmail())
                .password(passwordEncoder().encode(user.getPassword())).authorities("USER");
        }
    }


}
