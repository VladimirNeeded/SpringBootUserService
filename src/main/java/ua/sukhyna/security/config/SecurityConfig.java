package ua.sukhyna.security.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       // http.authorizeRequests().antMatchers("/users/**").permitAll(); <- могут попасть все пользователи
        http
                .authorizeRequests()
                    .antMatchers("/users/**").hasAuthority("ADMIN") //<- на страницу  "юзерс" могут попасть только аутенфицированные пользователи
                    .antMatchers("/signUp/**").permitAll()
                    .antMatchers("/").authenticated()
                .and()
                .formLogin()
                    .usernameParameter("login")
                    .passwordParameter("password")
                    .defaultSuccessUrl("/")
                    .loginPage("/login").permitAll();
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}