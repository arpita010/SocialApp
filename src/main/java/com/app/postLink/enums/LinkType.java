package com.app.postLink.enums;

public enum LinkType {
  POST_IMAGE("POST_IMAGE");
  private String type;

  LinkType(String type) {
    this.type = type;
  }

  public String toString() {
    return this.type;
  }
}
