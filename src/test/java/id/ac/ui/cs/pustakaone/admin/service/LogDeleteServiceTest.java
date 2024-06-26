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
class LogDeleteServiceTest {

    @Mock
    private LogRepository logRepository;

    @InjectMocks
    private LogDeleteService logDeleteService;

    @Test
    void testActionReturnsCorrectMessage() {
        Long id = Long.valueOf(123);
        String expectedMessage = "Review dengan id 123 berhasil dihapus";

        String actualMessage = logDeleteService.action(id);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCreateLog() {
        Long id = Long.valueOf(123);
        Log expectedLog = new Log("Review dengan id 123 berhasil dihapus", logDeleteService.getCurrentDate());
        when(logRepository.save(any(Log.class))).thenReturn(expectedLog);

        Log result = logDeleteService.createLog(id);

        assertEquals(expectedLog.getAction(), result.getAction());
        assertEquals(expectedLog.getDate(), result.getDate());
    }

    @Test
    void testGetAllLog() {
        List<Log> logs = new ArrayList<>();
        logs.add(new Log("Action 1", "01-01-2024"));
        logs.add(new Log("Action 2", "02-01-2024"));
        when(logRepository.findAll()).thenReturn(logs);

        List<Log> result = logDeleteService.getAllLog();

        assertEquals(2, result.size());
        assertEquals("Action 1", result.get(0).getAction());
        assertEquals("01-01-2024", result.get(0).getDate());
        assertEquals("Action 2", result.get(1).getAction());
        assertEquals("02-01-2024", result.get(1).getDate());
    }
}
