package com.onejava.ecommerce.controller;

import com.onejava.ecommerce.jpa.entity.Profile;
import com.onejava.ecommerce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @RequestMapping
    public List<Profile> getProfiles() {
        return profileService.getProfiles();
    }
}
