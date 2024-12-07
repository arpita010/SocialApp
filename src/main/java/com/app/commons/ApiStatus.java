package com.app.commons;

public enum ApiStatus {
  SUCCESS("SUCCESS"),
  FAILED("FAILED");

  private String status;

  ApiStatus(String status) {
    this.status = status;
  }

  public String toString() {
    return this.status;
  }
}
