package test; // must match main class package

import app.TrainConsistManagementApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

class TrainConsistManagementAppTest {

    @Test
    void testLoopFilteringLogic() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = List.of(
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 50),
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 70),
                new TrainConsistManagementApp.PassengerBogie("First Class", 80)
        );
        List<TrainConsistManagementApp.PassengerBogie> filtered = TrainConsistManagementApp.filterBogiesWithLoop(bogies, 60);
        assertEquals(2, filtered.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = List.of(
                new TrainConsistManagementApp.PassengerBogie("Sleeper", 50),
                new TrainConsistManagementApp.PassengerBogie("AC Chair", 70),
                new TrainConsistManagementApp.PassengerBogie("First Class", 80)
        );
        List<TrainConsistManagementApp.PassengerBogie> filtered = TrainConsistManagementApp.filterBogiesWithStream(bogies, 60);
        assertEquals(2, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            bogies.add(new TrainConsistManagementApp.PassengerBogie("Sleeper", i));
        }
        List<TrainConsistManagementApp.PassengerBogie> loopResult = TrainConsistManagementApp.filterBogiesWithLoop(bogies, 60);
        List<TrainConsistManagementApp.PassengerBogie> streamResult = TrainConsistManagementApp.filterBogiesWithStream(bogies, 60);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            bogies.add(new TrainConsistManagementApp.PassengerBogie("AC Chair", i % 100));
        }

        long start = System.nanoTime();
        TrainConsistManagementApp.filterBogiesWithLoop(bogies, 60);
        long end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<TrainConsistManagementApp.PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 100_000; i++) {
            bogies.add(new TrainConsistManagementApp.PassengerBogie("Sleeper", i % 100));
        }

        List<TrainConsistManagementApp.PassengerBogie> filtered = TrainConsistManagementApp.filterBogiesWithStream(bogies, 60);
        assertFalse(filtered.isEmpty());
    }
}