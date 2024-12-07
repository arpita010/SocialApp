package com.app.message;

import com.app.commons.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Message extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String content;

  private Long userId; // foreign key
  private Long roomId; // foreign key

  @Column(columnDefinition = "tinyint(1) default false")
  private Boolean isDeleted = false;
}
