package com.bannershallmark.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
@PropertySource("classpath:application.properties")
public class ApiKeyAuthFilter extends OncePerRequestFilter {
	

    private String apiKey;
    private String apiSecret;
       
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
    
        // Get the API key and secret from request headers
        String requestApiKey = request.getHeader("x-api-key");
        String requestApiSecret = request.getHeader("If-Match");
        
        System.out.println("Api key ---"+apiKey);
        System.out.println("Api secret --- "+apiSecret);
        
        if(requestApiKey!=null) {
          System.out.println(requestApiKey);
        }
        else {
          System.out.println("Api key is null");	
        }
        if(requestApiSecret!=null) {
            System.out.println(requestApiSecret);
          }
        else {
            System.out.println("Api Secret is null");	
        }
        // Validate the key and secret
        if(requestApiKey!=null && requestApiSecret!=null) {
            if (apiKey.equals(requestApiKey) && apiSecret.equals(requestApiSecret)) {
                // Continue processing the request
            	 System.out.println("Authenticated Successfully ----- --------");
            	 filterChain.doFilter(request, response);
            }     
            
            else {
                 // Reject the request and send an unauthorized error
                 response.setStatus(HttpStatus.UNAUTHORIZED.value());
                 response.getWriter().write("Unauthorized");
            }
        }   
        else {
            // Reject the request and send an unauthorized error
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Unauthorized");
        }
    }

	public ApiKeyAuthFilter(@Value("${api.key}") String apiKey,@Value("${api.secret}") String apiSecret) {
		super();
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
	}
}