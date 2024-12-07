package com.app.chatRoom.enums;

public enum RoomType {
  PEER_TO_PEER("PEER_TO_PEER"),
  GROUP("GROUP");

  private String type;

  RoomType(String type) {
    this.type = type;
  }

  public String toString() {
    return this.type;
  }
}
