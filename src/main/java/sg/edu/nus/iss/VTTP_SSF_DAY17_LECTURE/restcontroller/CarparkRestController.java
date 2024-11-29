package sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.model.Carpark;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.service.CarparkRestService;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.service.CarparkService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/api/rates", produces = "application/json")
public class CarparkRestController {

    @Autowired
    CarparkService cps;

    @Autowired
    CarparkRestService cprs;

    @GetMapping("/view")
    public ResponseEntity<String> getAllCarparks() {
        List<Carpark> carpark = cprs.getAllCarparks();

        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Carpark cp : carpark) {
            JsonObject jsonObj = Json.createObjectBuilder()
                    .add("id", cp.getId())
                    .add("name", cp.getName())
                    .add("category", cp.getCategory())
                    .add("weekdayOneDate", cp.getWeekdayOneRate())
                    .add("weekdayTwoRate", cp.getWeekdayTwoRate())
                    .add("saturdayRate", cp.getSaturdayRate())
                    .add("sundayPhRate", cp.getSundayPhRate())
                    .build();

            jab.add(jsonObj);
        }
        String builtData = jab.build().toString();

        return ResponseEntity.ok().body(builtData);

    }

}
