package com.hw.userservice.commons.security.model;

public class AuthenticationRequest {

  private String userId;
  private String password;

  public AuthenticationRequest() {}

  public AuthenticationRequest(String userId, String password) {
    this.userId = userId;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }
}
