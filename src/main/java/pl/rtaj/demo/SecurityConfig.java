package pl.rtaj.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;

//@Configuration
////klasy które coś dostarczają /@Bean/; uczy Springa jak tworzyć obiekt danej klasy; inne sposoby to ->@Services
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private DataSource dataSource;
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/add", "/edit")
//                .authenticated().anyRequest().permitAll()
//                .anyRequest()
//                .permitAll()
//                .and()
//                .formLogin();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.jdbcAuthentication().dataSource(dataSource)
//                .usersByUsernameQuery("selectusername,password, enabledfrom userwhereusername=?")
//                .authoritiesByUsernameQuery();
////                .UserByUsernameQuery("selectusername,password, enabledfrom userwhereusername=?")
////                .aut
//    }
//}
