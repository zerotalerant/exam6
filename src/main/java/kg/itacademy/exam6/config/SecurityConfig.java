package kg.itacademy.exam6.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Override
    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception
    {
        auth.jdbcAuthentication ()
                .dataSource ( dataSource )
                .usersByUsernameQuery ( "SELECT u.user_login, u.user_password, u.user_email, u.is_active FROM users u WHERE u.user_login = ?" )
                .authoritiesByUsernameQuery (
                        "SELECT u.user_login, r.name_role " +
                        "FROM users_roles ur " +
                        "INNER JOIN users u " +
                        "   on ur.user_id = u.id " +
                        "INNER JOIN roles r " +
                        "   on ur.role_id = r.id " +
                        "WHERE u.login = ? AND u.is_active = 1"
                );
    }

    @Override
    protected void configure ( HttpSecurity http ) throws Exception
    {
        http
                .sessionManagement ()
                .sessionCreationPolicy ( SessionCreationPolicy.STATELESS )
                .and ()
                .csrf ().disable ()
                .authorizeRequests ()

                .antMatchers ( HttpMethod.GET, "/api/v1/country/*" ).permitAll ()
                .antMatchers ( HttpMethod.POST, "/api/v1/country/*" ).hasRole ( "Admin" )
                .antMatchers ( HttpMethod.PUT, "/api/v1/country/*" ).hasRole ( "Admin" )
                .antMatchers ( HttpMethod.DELETE, "/api/v1/country/*" ).hasRole ( "Admin" )
                .antMatchers ( HttpMethod.GET, "/api/v1/user/*" ).permitAll ()
                .antMatchers ( HttpMethod.POST, "/api/v1/user/*" ).permitAll ()
                .antMatchers ( HttpMethod.PUT, "/api/v1/user/*" ).permitAll ()
                .antMatchers ( HttpMethod.DELETE, "/api/v1/user/*" ).hasRole ( "Admin" )
                .antMatchers ( "/api/v1/user" ).permitAll ()
                .antMatchers ( "/api/v1/role" ).hasRole ( "Admin" )

                .and ()
                .httpBasic ();
    }

    @Bean
    public PasswordEncoder passwordEncoder ()
    {
        return new BCryptPasswordEncoder ();
    }
}