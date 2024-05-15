package id.ac.ui.cs.pustakaone.admin.service;

import id.ac.ui.cs.pustakaone.admin.repository.AdminRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SpringBootTest
public class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepositoryMock;

    @Mock
    private LogDeleteService logDeleteServiceMock;

    @Mock
    private LogUpdateService logUpdateServiceMock;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    void setUp() {
    }


    @Test
    public void testRetrievePaymentList() throws ExecutionException, InterruptedException {
        // Setup
        String expectedResponse = "payment list";
        CompletableFuture<ResponseEntity<String>> mockedFuture = CompletableFuture.completedFuture(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
        when(adminRepositoryMock.retrievePaymentList()).thenReturn(mockedFuture);

        // Execution
        CompletableFuture<ResponseEntity<String>> future = adminService.retrievePaymentList();
        ResponseEntity<String> response = future.get();

        // Verification
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testRetrieveUsers() throws ExecutionException, InterruptedException {
        // Setup
        String expectedResponse = "user list";
        CompletableFuture<ResponseEntity<String>> mockedFuture = CompletableFuture.completedFuture(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
        when(adminRepositoryMock.retrieveUsers()).thenReturn(mockedFuture);

        // Execution
        CompletableFuture<ResponseEntity<String>> future = adminService.retrieveUsers();
        ResponseEntity<String> response = future.get();

        // Verification
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }
    @Test
    public void testUpdatePayment() {
        // Arrange
        Long idCart = Long.valueOf(123);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Payment Updated", HttpStatus.OK);
        when(adminRepositoryMock.updatePayment(idCart)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> result = adminService.updatePayment(idCart);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Payment Updated", result.getBody());
    }

    @Test
    public void testDeleteReview() {
        // Arrange
        Long idReview = Long.valueOf(456);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Review Deleted", HttpStatus.OK);
        when(adminRepositoryMock.deleteReview(idReview)).thenReturn(expectedResponse);

        // Act
        ResponseEntity<String> result = adminService.deleteReview(idReview);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("Review Deleted", result.getBody());
    }
}
