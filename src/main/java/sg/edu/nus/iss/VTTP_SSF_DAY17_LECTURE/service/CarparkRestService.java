package sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.constant.Url;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.model.Carpark;

@Service
public class CarparkRestService {

    RestTemplate restTemplate = new RestTemplate();

    // Access the external api
    // Pulling the data from the web, the data.gov.sg databank
    // Need to know the json format in the external api data
    // Create the carpark object
    // Return the list of carpark objects

    public List<Carpark> getAllCarparks() {
        String data = restTemplate.getForObject(Url.carparkUrl, String.class);

        JsonReader jreader = Json.createReader(new StringReader(data));
        JsonObject job = jreader.readObject();

        // result object, the list of records is an array
        //{    xxx:xxxx,
        //     yyy:yyy,
        //     result: records[{id:ttt, cpname: name, rate1:xxx}, {id:ttt, cpname: name, rate1:xxx}, {id:ttt, cpname: name, rate1:xxx}]
        // }
        JsonArray jdataObject = job.getJsonObject("result").getJsonArray("records");

        List<Carpark> carparks = new ArrayList<>();

        for (int i = 0; i < jdataObject.size(); i++) {
            Carpark cp = new Carpark();
            cp.setId(jdataObject.get(i).asJsonObject().getInt("_id"));
            cp.setName(jdataObject.get(i).asJsonObject().getString("carpark"));
            cp.setCategory(jdataObject.get(i).asJsonObject().getString("category"));
            cp.setWeekdayOneRate(jdataObject.get(i).asJsonObject().getString("weekdays_rate_1"));
            cp.setWeekdayTwoRate(jdataObject.get(i).asJsonObject().getString("weekdays_rate_2"));
            cp.setSaturdayRate(jdataObject.get(i).asJsonObject().getString("saturday_rate"));
            cp.setSundayPhRate(jdataObject.get(i).asJsonObject().getString("sunday_publicholiday_rate"));
            carparks.add(cp);
        }

        return carparks;
    }
}
