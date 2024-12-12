package com.app.followers;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRecordRepo extends CrudRepository<FollowerRecord, Long> {}
