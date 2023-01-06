package com.challenge.patient.config;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NotNull HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    ) throws ServletException, IOException {

        FirebaseToken decodedToken = verifyToken(getBearerToken(request));

        if (decodedToken != null) authenticate(decodedToken);

        filterChain.doFilter(request, response);
    }

    private String getBearerToken(HttpServletRequest request) {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (token == null || token.isBlank()) return null;

        return token.replaceAll("Bearer ", "");
    }

    private FirebaseToken verifyToken(String token) {
        try {
            if (token != null)
                return FirebaseAuth.getInstance().verifyIdToken(token);
        }
        catch (FirebaseAuthException exc) {
            log.info("Erro na autorização com Firebase: ", exc);
        }

        return null;
    }
    private void authenticate(FirebaseToken decodedToken) {
        PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(decodedToken, null);
        authentication.setAuthenticated(true);

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
