package id.ac.ui.cs.pustakaone.admin.repository;

import id.ac.ui.cs.pustakaone.admin.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LogRepositoryTest {

    @Autowired
    private LogRepository logRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateLog() {
        Log log = new Log("Review dengan id 6 berhasil dihapus", "2024-04-24T12:00:00Z");
        Log createdLog = logRepository.save(log);
        assertNotNull(createdLog);
        assertEquals(log.getAction(), createdLog.getAction());
        assertEquals(log.getDate(), createdLog.getDate());
    }

    @Test
    void testAllLog() {
        Log log = new Log("Review dengan id 8 berhasil dihapus", "2024-04-24T12:00:00Z");
        Log log2 = new Log("Review dengan id 20 berhasil dihapus", "2024-04-24T12:00:00Z");
        logRepository.save(log);
        logRepository.save(log2);
        List<Log> allLogs = logRepository.findAll();
        assertEquals(2, allLogs.size());
    }
}