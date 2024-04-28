package id.ac.ui.cs.pustakaone.admin.repository;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

import id.ac.ui.cs.pustakaone.admin.model.Cart;
import id.ac.ui.cs.pustakaone.admin.model.User;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Repository
public class AdminRepository {

    private WebClient webClient = WebClient.create();

    public void setWebClient(WebClient webClientAlter) {
        webClient = webClientAlter;
    }

    public Mono<ResponseEntity<String>> retrievePaymentList() {
        return webClient.get()
                .uri("http://localhost:8080/all-cart")
                .retrieve()
                .toEntity(String.class);
    }  

    public Mono<ArrayList<User>> retrieveUsers() {
        return webClient.get()
                .uri("https://identity.pustakaone.my.id/auth/getAllUser")
                .retrieve()
                .bodyToFlux(User.class) 
                .collectList() 
                .map(ArrayList::new); 
    }
}

