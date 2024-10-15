package com.character_collect.mini_project.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class PresentationViewController {

    @GetMapping("/test")
    fun test(): String {
        return "test"
    }
}