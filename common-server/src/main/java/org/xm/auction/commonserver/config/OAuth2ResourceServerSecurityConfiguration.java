package org.xm.auction.commonserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.xm.auction.commonserver.utils.HttpRequest;

import javax.ws.rs.core.Request;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.interfaces.RSAPublicKey;
import java.util.stream.Collectors;

//@Configuration
@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
//    String jwkSetUri;
    String jwkSetUri = "http://localhost:31001/oauth2/jwks";

//    @Value("${spring.security.oauth2.resourceserver.jwt.public-key-location}")
//    RSAPublicKey key;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .antMatchers(HttpMethod.GET, "/message/**").hasAuthority("SCOPE_message:read")
                        .antMatchers(HttpMethod.POST, "/message/**").hasAuthority("SCOPE_message:write")
                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri(this.jwkSetUri).build();
//        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    /**
     * 读取classpath下的公钥内容
     * 用于解密JwtToken信息
     * @return
     */
    private String getPublicKey() {
        ClassPathResource resource = new ClassPathResource("simple.pub");
        try (InputStreamReader reader = new InputStreamReader(resource.getInputStream())) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
