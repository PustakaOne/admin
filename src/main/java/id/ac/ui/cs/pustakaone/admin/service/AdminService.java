package id.ac.ui.cs.pustakaone.admin.service;

import org.springframework.http.ResponseEntity;

import reactor.core.publisher.Mono;

public interface AdminService {
    public ResponseEntity<String> retrievePaymentList();
    public ResponseEntity<String> retrieveUsers();
    public ResponseEntity<String> updatePayment(String idCart);
    public ResponseEntity<String> deleteReview(String idReview);
}
