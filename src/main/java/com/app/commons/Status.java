package com.app.commons;

public enum Status {
  SUCCESS("SUCCESS"),
  FAILED("FAILED");

  private String status;

  Status(String status) {
    this.status = status;
  }

  public String toString() {
    return this.status;
  }
}
