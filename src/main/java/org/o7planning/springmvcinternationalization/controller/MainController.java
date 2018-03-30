package org.o7planning.springmvcinternationalization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/login1")
	public String login1(Model model) {
		return "login1";
	}
	
	@RequestMapping(value = "/{locale:en|fr|vi}/login2")
    public String login2(Model model) {
        return "login2";
    }
}