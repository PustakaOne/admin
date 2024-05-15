package id.ac.ui.cs.pustakaone.admin.controller;

import id.ac.ui.cs.pustakaone.admin.model.Log;
import id.ac.ui.cs.pustakaone.admin.service.AdminService;
import id.ac.ui.cs.pustakaone.admin.service.LogDeleteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;
import static org.hamcrest.Matchers.hasSize;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AdminService adminServiceMock;

    @Mock
    private LogDeleteService logDeleteServiceMock;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testGetPayments() {
        String expectedResponse = "payment data";
        CompletableFuture<ResponseEntity<String>> future = CompletableFuture.completedFuture(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
        when(adminServiceMock.retrievePaymentList()).thenReturn(future);

        ResponseEntity<String> response = adminController.getPayments();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testGetPayments_Exception() {
        CompletableFuture<ResponseEntity<String>> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("Error"));
        when(adminServiceMock.retrievePaymentList()).thenReturn(future);

        ResponseEntity<String> response = adminController.getPayments();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testGetUsers_Exception() {
        CompletableFuture<ResponseEntity<String>> future = new CompletableFuture<>();
        future.completeExceptionally(new RuntimeException("Error"));
        when(adminServiceMock.retrieveUsers()).thenReturn(future);

        ResponseEntity<String> response = adminController.getUsers();

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void testGetUsers() {
        String expectedResponse = "user data";
        CompletableFuture<ResponseEntity<String>> future = CompletableFuture.completedFuture(new ResponseEntity<>(expectedResponse, HttpStatus.OK));
        when(adminServiceMock.retrieveUsers()).thenReturn(future);

        ResponseEntity<String> response = adminController.getUsers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResponse, response.getBody());
    }

    @Test
    public void testGetLogs() throws Exception {
        Log log1 = new Log();
        Log log2 = new Log();
        List<Log> logs = Arrays.asList(log1, log2);

        when(logDeleteServiceMock.getAllLog()).thenReturn(logs);


        mockMvc.perform(get("/admin/logs")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testUpdatePayment() throws Exception {
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Payment Updated", HttpStatus.OK);
        when(adminServiceMock.updatePayment(123L)).thenReturn(expectedResponse);

        mockMvc.perform(post("/admin/update-payment")
                        .contentType("application/json")
                        .content("{\"id\":\"123\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Payment Updated"));
    }

    @Test
    public void testDeleteReview() throws Exception {
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Review Deleted", HttpStatus.OK);
        when(adminServiceMock.deleteReview(456L)).thenReturn(expectedResponse);

        mockMvc.perform(post("/admin/delete-review")
                        .contentType("application/json")
                        .content("{\"id\":\"456\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Review Deleted"));
    }
}

