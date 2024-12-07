package com.app.chatRoom;

import com.app.chatRoom.enums.RoomType;
import com.app.commons.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatRoom extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roomId;

  private String roomRef; // always unique

  private String name;

  @Enumerated(EnumType.STRING)
  private RoomType type;

  @Column(columnDefinition = "tinyint(1) default true")
  private Boolean isActive = true;

  // list of users who joined that room
}
