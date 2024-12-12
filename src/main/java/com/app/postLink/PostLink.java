package com.app.postLink;

import com.app.commons.SuperEntity;
import com.app.postLink.enums.LinkType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PostLink extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "longtext")
  private String link;

  @Enumerated(EnumType.STRING)
  private LinkType linkType;
}
