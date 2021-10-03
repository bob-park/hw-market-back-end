package com.hw.userservice.commons.security.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SecurityAuthenticationToken extends AbstractAuthenticationToken {

  private Object principal;

  private String credentials;

  public SecurityAuthenticationToken(String principal, String credentials) {
    super(null);
    super.setAuthenticated(false);

    this.principal = principal;
    this.credentials = credentials;
  }

  public SecurityAuthenticationToken(
          Object principal, String credentials, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    super.setAuthenticated(true);

    this.principal = principal;
    this.credentials = credentials;
  }

  public AuthenticationRequest authenticationRequest() {
    return new AuthenticationRequest(String.valueOf(principal), credentials);
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }

  @Override
  public String getCredentials() {
    return credentials;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated)
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");

    super.setAuthenticated(false);
  }

  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
    credentials = null;
  }
}
