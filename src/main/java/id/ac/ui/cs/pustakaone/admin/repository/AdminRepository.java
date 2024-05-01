package id.ac.ui.cs.pustakaone.admin.repository;


import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class AdminRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> retrievePaymentList() {
        String url = "http://localhost:8080/all-cart";
        return restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    public ResponseEntity<String> retrieveUsers() {
        String url = "https://identity.pustakaone.my.id/auth/getAllUser";
        return restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    }

    public ResponseEntity<String> updatePayment(String idCart) {
        String url = "http://localhost:8080/all-logs";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(createJsonBody(idCart), headers);

        return restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }

    public ResponseEntity<String> deleteReview(String idReview){
        String url = "http://localhost:8080/testing";
        ResponseEntity<String> idBookResponse = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String idBook = idBookResponse.getBody();

        String url2 = String.format("http://localhost:8080/review/%s/%s/delete", idBook, idReview);
        return restTemplate.exchange(url2, HttpMethod.DELETE, null, String.class);
    }

    private String createJsonBody(String idCart) {
        return "{\"id\":\"" + idCart + "\"}";
    }
}


