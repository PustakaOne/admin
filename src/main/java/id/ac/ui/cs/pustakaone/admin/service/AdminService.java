package id.ac.ui.cs.pustakaone.admin.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;


public interface AdminService {
    CompletableFuture<ResponseEntity<String>> retrievePaymentList();
    CompletableFuture<ResponseEntity<String>> retrieveUsers();
    ResponseEntity<String> updatePayment(Long idCart);
    ResponseEntity<String> deleteReview(Long idReview);
}