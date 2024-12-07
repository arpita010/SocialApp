package com.app.comment;

import com.app.commons.SuperEntity;
import com.app.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String content;

  private Long postId;
  private Long commentId;
  @ManyToOne private User postedBy;
}
