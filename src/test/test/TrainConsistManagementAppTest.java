package test; // must match the package in main file

import static org.junit.jupiter.api.Assertions.*;

import app.TrainConsistManagementApp;
import org.junit.jupiter.api.Test;
import java.util.List;

class TrainConsistManagementAppTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Petroleum"),
                new TrainConsistManagementApp.GoodsBogie("Rectangular", "Coal")
        );
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(TrainConsistManagementApp.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Open", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Box", "Grain")
        );
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of(
                new TrainConsistManagementApp.GoodsBogie("Rectangular", "Coal"),
                new TrainConsistManagementApp.GoodsBogie("Cylindrical", "Coal")
        );
        assertFalse(TrainConsistManagementApp.isTrainSafetyCompliant(bogies));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<TrainConsistManagementApp.GoodsBogie> bogies = List.of();
        assertTrue(TrainConsistManagementApp.isTrainSafetyCompliant(bogies));
    }
}