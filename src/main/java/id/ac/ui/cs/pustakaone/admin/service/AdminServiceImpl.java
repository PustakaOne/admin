package id.ac.ui.cs.pustakaone.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.pustakaone.admin.repository.AdminRepository;
import reactor.core.publisher.Mono;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public ResponseEntity<String> retrievePaymentList() {
        return adminRepository.retrievePaymentList();
    }

    @Override
    public ResponseEntity<String> retrieveUsers(){
        return adminRepository.retrieveUsers();
    }

    @Override
    public ResponseEntity<String> updatePayment(String idCart){
        return adminRepository.updatePayment(idCart);
    }

    @Override
    public ResponseEntity<String> deleteReview(String idReview){
        return adminRepository.deleteReview(idReview);
    }

}
