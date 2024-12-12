package com.app.followers;

import com.app.followers.request.FollowingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowerRecordService {
  private final FollowerRecordRepo followerRecordRepo;

  public void followUser(FollowingRequest request) {
    FollowerRecord record = request.toFollowerRecord();
    followerRecordRepo.save(record);
  }
}
