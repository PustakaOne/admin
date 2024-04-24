package id.ac.ui.cs.pustakaone.admin.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetHello() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello admin!"));
    }

    @Test
    public void testGetPayments() throws Exception {
        mockMvc.perform(get("/admin/payments"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello admin!"));
    }

    @Test
    public void testUpdatePayment() throws Exception {
        mockMvc.perform(post("/admin/update-payment"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello admin!"));
    }

    @Test
    public void testGetUsers() throws Exception {
        mockMvc.perform(get("/admin/users"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello admin!"));
    }
    
    @Test
    public void testDeleteReview() throws Exception {
        mockMvc.perform(post("/admin/delete-review"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello admin!"));
    }

}
