package id.ac.ui.cs.pustakaone.admin.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import id.ac.ui.cs.pustakaone.admin.model.Log;
import id.ac.ui.cs.pustakaone.admin.repository.LogRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class LogUpdateServiceTest {

    @Mock
    private LogRepository logRepository;

    @InjectMocks
    private LogUpdateService logUpdateService;

    @Test
    void testActionReturnsCorrectMessage() {
        Long id = Long.valueOf(456);
        String expectedMessage = "Cart dengan id 456 berhasil diupdate";

        String actualMessage = logUpdateService.action(id);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCreateLog() {
        Long id = Long.valueOf(456);
        Log expectedLog = new Log("Cart dengan id 456 berhasil diupdate", logUpdateService.getCurrentDate());
        when(logRepository.save(any(Log.class))).thenReturn(expectedLog);

        Log result = logUpdateService.createLog(id);

        assertEquals(expectedLog.getAction(), result.getAction());
        assertEquals(expectedLog.getDate(), result.getDate());
    }

    @Test
    void testGetAllLog() {
        List<Log> logs = new ArrayList<>();
        logs.add(new Log("Action 1", "01-01-2024"));
        logs.add(new Log("Action 2", "02-01-2024"));
        when(logRepository.findAll()).thenReturn(logs);

        List<Log> result = logUpdateService.getAllLog();

        assertEquals(2, result.size());
        assertEquals("Action 1", result.get(0).getAction());
        assertEquals("01-01-2024", result.get(0).getDate());
        assertEquals("Action 2", result.get(1).getAction());
        assertEquals("02-01-2024", result.get(1).getDate());
    }
}



