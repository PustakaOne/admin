package id.ac.ui.cs.pustakaone.admin.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.pustakaone.admin.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private LogDeleteService logDelService;

    @Autowired
    private LogUpdateService logUpService;

    @Override
    public CompletableFuture<ResponseEntity<String>> retrievePaymentList() {
        return adminRepository.retrievePaymentList();
    }

    @Override
    public CompletableFuture<ResponseEntity<String>> retrieveUsers(){
        return adminRepository.retrieveUsers();
    }

    @Override
    public ResponseEntity<String> updatePayment(Long idCart){
        logUpService.createLog(idCart);
        return adminRepository.updatePayment(idCart);
    }

    @Override
    public ResponseEntity<String> deleteReview(Long idReview){
        logDelService.createLog(idReview);
        return adminRepository.deleteReview(idReview);
    }
}