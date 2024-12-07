package com.app.commons;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@MappedSuperclass
public class SuperEntity {
  @CurrentTimestamp private Date createdAt;
  @UpdateTimestamp private Date updatedAt;
}
