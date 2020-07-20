package com.onejava.service.controller;

import com.onejava.service.model.read.Session;
import com.onejava.service.repository.read.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionRepository sessionRepository;

    @PostMapping
    public Session create(@RequestBody Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @GetMapping
    public List<Session> read(){
        return sessionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Session read(@PathVariable Long id){
        return sessionRepository.getOne(id);
    }

    @PutMapping("/{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

    @DeleteMapping
    public void delete(@RequestBody Session session){
         sessionRepository.delete(session);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        sessionRepository.deleteById(id);
    }
}
