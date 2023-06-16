package com.devops.coach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class StartApplication {

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("title", "Hello J..As discussed, I have created VM in AZURE, installed jenkins, set-up CI-CD pipeline");
        model.addAttribute("build docker image of spring boot application and deployed it to AKS cluster using HELM and jenkins pipeline","Hope this is ok!!!!!");
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
