package com.onejava.service.controller;

import com.onejava.service.model.write.Speaker;
import com.onejava.service.repository.write.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @PostMapping
    public Speaker create(@RequestBody Speaker speaker){
        return speakerRepository.saveAndFlush(speaker);
    }

    @GetMapping
    public List<Speaker> read(){
        return speakerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Speaker read(@PathVariable Long id){
        return speakerRepository.getOne(id);
    }

    @PutMapping("/{id}")
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker){
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping
    public void delete(@RequestBody Speaker speaker){
        speakerRepository.delete(speaker);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }
}
