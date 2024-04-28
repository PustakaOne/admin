package id.ac.ui.cs.pustakaone.admin.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.pustakaone.admin.repository.AdminRepository;
import reactor.core.publisher.Mono;
import id.ac.ui.cs.pustakaone.admin.model.Cart;
import id.ac.ui.cs.pustakaone.admin.model.User;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Mono<ResponseEntity<String>> retrievePaymentList() {
        return adminRepository.retrievePaymentList()
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }

    @Override
    public Mono<ResponseEntity<ArrayList<User>>> retrieveUsers(){
        return adminRepository.retrieveUsers()
                .map(paymentList -> ResponseEntity.ok(paymentList))
                .onErrorReturn(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

}
