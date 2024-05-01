package id.ac.ui.cs.pustakaone.admin.controller;
import id.ac.ui.cs.pustakaone.admin.service.AdminService;
import id.ac.ui.cs.pustakaone.admin.service.LogDeleteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Mono;
import id.ac.ui.cs.pustakaone.admin.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AdminController {

    @Autowired
    private AdminService service;

    @Autowired
    private LogDeleteService logService;

    @GetMapping("/admin/payments")
    public ResponseEntity<String> getPayments() {
        return service.retrievePaymentList();
    } 

    @GetMapping("/admin/users")
    public ResponseEntity<String> getUsers() {
        return service.retrieveUsers();
    } 

    @GetMapping("/admin/logs")
    public List<Log> getLogs() {
        return logService.getAllLog();
    }

    @PostMapping("/admin/update-payment")
    public ResponseEntity<String> updatePayment(@RequestBody HashMap<String, String> body) {
        String idCart = body.get("id");
        return service.updatePayment(idCart);
    }

    @PostMapping("/admin/delete-review")
    public ResponseEntity<String> deleteReview(@RequestBody HashMap<String, String> body) {
        String idReview = body.get("id");
        return service.deleteReview(idReview);
    }
}