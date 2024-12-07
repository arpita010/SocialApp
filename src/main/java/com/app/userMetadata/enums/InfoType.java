package com.app.userMetadata.enums;

public enum InfoType {
  USER_PROFILE("");
  private String type;

  InfoType(String type) {
    this.type = type;
  }

  public String toStirng() {
    return this.type;
  }
}
