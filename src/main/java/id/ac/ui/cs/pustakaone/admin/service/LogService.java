package id.ac.ui.cs.pustakaone.admin.service;
import id.ac.ui.cs.pustakaone.admin.repository.LogRepository;
import id.ac.ui.cs.pustakaone.admin.model.Log;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class LogService {

    @Autowired
    private LogRepository logRepository;
    
    public Log createLog(String id){
        String date = getCurrentDate();
        String action = action(id);
        Log log = new Log(action, date);
        return logRepository.save(log);
    }

    public abstract String action(String id);

    public String getCurrentDate(){
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }

    public List<Log> getAllLog(){
        return logRepository.findAll();
    }

}
