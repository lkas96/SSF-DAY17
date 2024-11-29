package sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.constant.Constant;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.model.Carpark;
import sg.edu.nus.iss.VTTP_SSF_DAY17_LECTURE.repository.ListRepo;

@Service
public class CarparkService {

    @Autowired
    ListRepo lr;
    
    //View All Carparks Rates
    //Take String data from redis db, instantiate to carpark object
    //Return the list of carpark objects

    //Add to redis db "carparks"
    public void add(Carpark carpark){
        lr.rightPush(Constant.carpark, carpark.toString());
    }

    public List<Carpark> getAllCarparks(String redisKey){
        List<String> carparks = lr.getList(redisKey);
        List<Carpark> carparkRecords = new ArrayList<>();

        for (String raw : carparks){
            String [] data = raw.split(",");

            Carpark cp = new Carpark(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6]);
            carparkRecords.add(cp);
        }
        return carparkRecords;
    }

    
    
}
