package com.onejava.ecommerce.service;

import com.onejava.ecommerce.jpa.entity.Profile;
import com.onejava.ecommerce.jpa.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    @Autowired
    private ProfileRepository profileRepository;

    public List<Profile> getProfiles() {
        return profileRepository.findAll();
    }
}
