package com.oviana.hulkstore.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oviana.hulkstore.vo.UserDetailVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequest credenciales = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
			log.info("credenciales.getPassword(): {}" , credenciales.getPassword());
			return this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(credenciales.getUsername(), credenciales.getPassword()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		UserDetailVO userLogged = (UserDetailVO) auth.getPrincipal();
		String token = JwtTokenUtil.generateToken(userLogged);
		response.setHeader("Access-Control-Expose-Headers", JwtTokenUtil.HEADER_AUTHORIZACION_KEY);
		response.addHeader(JwtTokenUtil.HEADER_AUTHORIZACION_KEY, JwtTokenUtil.TOKEN_BEARER_PREFIX + " " + token);
	}
}
