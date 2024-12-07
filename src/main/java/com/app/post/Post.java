package com.app.post;

import com.app.comment.Comment;
import com.app.commons.SuperEntity;
import com.app.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String title;

  @Column(columnDefinition = "longtext")
  private String content;

  private Long upVotes;
  private Long downVotes;
  // list of tags
  // list of comments
  // comment on comment
  // list of bookmarked by
  @OneToMany private List<Comment> commentList;
  @OneToMany private List<User> bookmarkedBy;
}
