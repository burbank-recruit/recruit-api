package com.burbank.recruit.repository;

import com.burbank.recruit.model.RecruitUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RecruitUser, Long> {

    RecruitUser findByUsername(String username);
}
