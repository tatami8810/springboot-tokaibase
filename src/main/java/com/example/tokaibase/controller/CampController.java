package com.example.tokaibase.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tokaibase.repository.CampRepository;

@Controller
public class CampController {

    private final CampRepository campRepository;

    public CampController(CampRepository campRepository) {
        this.campRepository = campRepository;
    }

    @GetMapping("/camps/search")
    public String searchForm() {
        return "camp/search";
    }

    @GetMapping("/camps/result")
    public String searchResult(
            @RequestParam(required = false) String prefecture,
            @RequestParam(required = false) String keyword,
            Model model) {

        var result = campRepository.search(prefecture, keyword);
        model.addAttribute("camps", result);

        return "camp/result";
    }
}
