package id.ac.ui.cs.pustakaone.admin.controller;
import id.ac.ui.cs.pustakaone.admin.service.AdminService;
import id.ac.ui.cs.pustakaone.admin.service.LogDeleteService;
import org.springframework.web.bind.annotation.*;
import id.ac.ui.cs.pustakaone.admin.model.*;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private LogDeleteService logService;

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public ResponseEntity<String> getPayments() {
        ResponseEntity<String> result;
        try {
            result = service.retrievePaymentList().get();
        } catch (Exception e) {
            result = ResponseEntity.badRequest().build();
        }
        return result;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<String> getUsers() {
        ResponseEntity<String> result;
        try {
            result = service.retrieveUsers().get();
        } catch (Exception e) {
            result = ResponseEntity.badRequest().build();
        }
        return result;
    }

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public List<Log> getLogs() {
        return logService.getAllLog();
    }

    @RequestMapping(value = "/update-payment", method = RequestMethod.POST)
    public ResponseEntity<String> updatePayment(@RequestBody HashMap<String, String> body) {
        Long idCart = Long.valueOf(body.get("id"));
        return service.updatePayment(idCart);
    }

    @RequestMapping(value = "/delete-review", method = RequestMethod.POST)
    public ResponseEntity<String> deleteReview(@RequestBody HashMap<String, String> body) {
        Long idReview = Long.valueOf(body.get("id"));
        return service.deleteReview(idReview);
    }
}