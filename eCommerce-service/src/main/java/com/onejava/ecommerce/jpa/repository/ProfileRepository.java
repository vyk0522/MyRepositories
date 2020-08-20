package com.onejava.ecommerce.jpa.repository;

import com.onejava.ecommerce.jpa.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
