package br.com.crescer;

import br.com.crescer.security.CrescerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Carlos H. Nonnemacher
 */
@Configuration
public class CrescerWebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    CrescerUserDetailsService crescerUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .defaultSuccessUrl("/pessoa", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .permitAll().and().csrf().disable();
    }

    @Autowired
    public void setDetailsService(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(crescerUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }
}
