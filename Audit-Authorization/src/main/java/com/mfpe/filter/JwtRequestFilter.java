package com.mfpe.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mfpe.model.ProjectManagerDetails;
import com.mfpe.service.JwtService;
import com.mfpe.service.ProjectManagerDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{

	@Autowired
	private ProjectManagerDetailsService projectManagerDetailsService;

	@Autowired
	private JwtService jwtService;

	// an added security layer to authorize all the requests if they have valid jwt or not
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String jwtRequestHeader = request.getHeader("Authorization");
		
		System.out.println("Inside JwtRequestFilter : " + request.getRequestURI());
		
		String jwt = null, username = null;
		if (jwtRequestHeader != null && jwtRequestHeader.startsWith("Bearer ")) {
			jwt = jwtRequestHeader.substring(7);
			try {
				username = jwtService.extractUsername(jwt);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("Problem with JWT token obtained from Request-Header.\nJWT--> "+jwt);
		}
		
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			ProjectManagerDetails projectManagerDetails = projectManagerDetailsService.loadUserByUsername(username);
			if (jwtService.validateToken(jwt, projectManagerDetails)) {
				UsernamePasswordAuthenticationToken 
					usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
															projectManagerDetails, null, 
															projectManagerDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}
