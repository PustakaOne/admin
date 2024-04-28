package id.ac.ui.cs.pustakaone.admin.service;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

import id.ac.ui.cs.pustakaone.admin.model.Cart;
import id.ac.ui.cs.pustakaone.admin.model.User;
import reactor.core.publisher.Mono;

public interface AdminService {
    public Mono<ResponseEntity<String>> retrievePaymentList();
    public Mono<ResponseEntity<ArrayList<User>>> retrieveUsers();    
}
