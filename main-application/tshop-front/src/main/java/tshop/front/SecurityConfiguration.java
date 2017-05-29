package tshop.front;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import tshop.back.services.security.UserService;


/**
 * Created by Роднуля on 14.04.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    @Autowired
    private UserDetailsService userService;



    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);//.passwordEncoder(passwordEncoder())

    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.authorizeRequests().antMatchers("/", "/goods","/cart").permitAll()
                .antMatchers(HttpMethod.GET,"/data/goods").permitAll()
                .antMatchers("/categories","/newcategory","/categorydetailed").hasAuthority("ADMIN")
                .antMatchers("/neworder").hasAuthority("CLIENT")
//                .antMatchers("/orders","/orderdetailed").hasAuthority("ADMIN")
//                .antMatchers("/data/**").hasAnyAuthority("ADMIN","CLIENT")
                .and().formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("userpassword")
                .and().exceptionHandling().accessDeniedPage("/accessDenied")
                .and().csrf().disable();
    }
}
