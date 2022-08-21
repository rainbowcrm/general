package com.primus.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    DefaultAuthenticationProvider defaultAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider((AuthenticationProvider)defaultAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
          http.authorizeRequests().antMatchers("/scripts/support.js").permitAll().antMatchers("/assets/wp1.jpg").permitAll()
                  .antMatchers("/assets/logo.PNG").permitAll().antMatchers(("/stockapi/user/setOTP")).permitAll().antMatchers(("/stockapi/user/saveOTP"))
                  .permitAll().antMatchers("/index.html").permitAll().antMatchers(("/stockapi/user/sendPassword")).permitAll()
                  .anyRequest().authenticated().and().formLogin().and().httpBasic().authenticationEntryPoint(new NoPopupBasicAuthenticationEntryPoint()).and().headers().
                  frameOptions().sameOrigin().and().csrf()
                 .and().formLogin().loginPage("/bologin.html").failureUrl("/bologin.html?error=true")
                  .loginProcessingUrl("/bologin.html").permitAll();

          http.logout().logoutSuccessUrl("/bologin.html");
          /*
          .failureHandler(new AuthenticationFailureHandler() {
              @Override
              public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                  UrlPathHelper urlPathHelper =new UrlPathHelper();
                  String contextPath = urlPathHelper.getContextPath(request);
                  response.sendRedirect(contextPath + "/bologin.html?error=true");
              }
          });
           */


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("https://maxcdn.bootstrapcdn.com/**","https://stackpath.bootstrapcdn.com/**",
                "**/scripts/support.js","https://cdnjs.cloudflare.com/**","https://fonts.googleapis.com/**",
                "https://ajax.googleapis.com/**");
    }
}
