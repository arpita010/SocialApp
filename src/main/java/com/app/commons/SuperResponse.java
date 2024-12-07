package com.app.commons;

import lombok.Data;

@Data
public class SuperResponse {
  private Status status;

  public SuperResponse() {
    this.status = Status.SUCCESS;
  }

  public SuperResponse(Status status) {
    this.status = status;
  }
}
