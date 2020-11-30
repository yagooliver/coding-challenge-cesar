package com.cesar.demo.application.config;

import com.cesar.demo.application.oauth.HttpCookieOAuth;
import com.cesar.demo.application.oauth.services.AuthenticationSuccessHandler;
import com.cesar.demo.application.oauth.services.UserService;
import com.cesar.demo.application.oauth.token.TokenFilter;
import com.cesar.demo.application.oauth.token.TokenJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true,
        prePostEnabled = true
)
@EnableOAuth2Client
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private TokenJwt tokenJwt;

    @Autowired
    private HttpCookieOAuth httpCookieOAuth;

    @Bean
    public HttpCookieOAuth cookieAuthorizationRequestRepository() {
        return new HttpCookieOAuth();

    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Bean
    public TokenFilter tokenAuthenticationFilter() {
        return new TokenFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login( oauth2 -> oauth2.userInfoEndpoint(userInfo -> userInfo.userService(userService) )).oauth2Login()
                .authorizationEndpoint()
                .baseUri("/login/google")
                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
                .and()
                .redirectionEndpoint()
                .baseUri("/")
                .and()
                .userInfoEndpoint()
                .userService(userService).and().successHandler(successHandler);
        http.addFilterBefore(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
