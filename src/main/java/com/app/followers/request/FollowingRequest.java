package com.app.followers.request;

import com.app.followers.FollowerRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowingRequest {
  private Long followerId;
  private Long followeeId;

  public FollowerRecord toFollowerRecord() {
    FollowerRecord record = new FollowerRecord();
    record.setFollowerId(this.followerId);
    record.setFolloweeId(this.followeeId);
    return record;
  }
}
