package sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.model.Carpark;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.service.CarparkRestService;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/carparks")
public class CarparkController {

    @Autowired
    CarparkRestService cprs;

    @GetMapping("")
    public String getCarparkList(Model model) {
        List<Carpark> carparks = new ArrayList<>();
        carparks = cprs.getAllCarparks();

        model.addAttribute("carparks", carparks);
        return "carparklist";
    }
    
}
