package com.app.userMetadata;

import com.app.commons.SuperEntity;
import com.app.userMetadata.enums.InfoType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserMetadata extends SuperEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId; // foreign key

  @Enumerated(EnumType.STRING)
  private InfoType type;

  private String description;
}
