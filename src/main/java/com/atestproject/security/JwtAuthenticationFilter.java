package com.atestproject.security;

import com.atestproject.domain.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import static com.atestproject.util.UtilContants.*;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException {
        try {
            if (req.getMethod().equalsIgnoreCase("OPTIONS"))
                return null;

            Account
                    creds = new ObjectMapper().readValue(req.getInputStream(), Account.class);

            return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
                    creds.getPassword(), Collections.emptyList()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {

        final Claims claims = Jwts.claims().setSubject(((User) auth.getPrincipal()).getUsername());
        if (((User) auth.getPrincipal()).getAuthorities() != null
                && !((User) auth.getPrincipal()).getAuthorities().isEmpty()) {
            claims.put("role",
                    ((User) auth.getPrincipal()).getAuthorities().iterator().next().getAuthority().toUpperCase());
        }
        String token = Jwts.builder().setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        res.getWriter().write(token);
        res.getWriter().flush();
        res.getWriter().close();
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }

}
