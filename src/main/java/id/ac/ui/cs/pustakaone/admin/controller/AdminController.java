package id.ac.ui.cs.pustakaone.admin.controller;
import id.ac.ui.cs.pustakaone.admin.service.AdminService;
import id.ac.ui.cs.pustakaone.admin.service.LogDeleteService;
import reactor.core.publisher.Mono;
import id.ac.ui.cs.pustakaone.admin.model.*;

import java.util.ArrayList;
import java.util.List;

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
    public Mono<ResponseEntity<String>> getPayments() {
        return service.retrievePaymentList();
    } 

    @GetMapping("/admin/users")
    public Mono<ResponseEntity<ArrayList<User>>> getUsers() {
        return service.retrieveUsers();
    } 

    @GetMapping("/admin/logs")
    public List<Log> getLogs() {
        return logService.getAllLog();
    }
}