package com.example.tokaibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tokaibase.repository.ShelterRepository;

@Controller
public class ShelterController {

    private final ShelterRepository shelterRepository;

    public ShelterController(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    @GetMapping("/shelters/search")
    public String searchForm() {
        return "shelter/search";
    }

    @GetMapping("/shelters/result")
    public String searchResult(
            @RequestParam(required = false) String prefecture,
            @RequestParam(required = false) String keyword,
            Model model) {

        var result = shelterRepository.search(prefecture, keyword);
        model.addAttribute("shelters", result);

        return "shelter/result";
    }
}
