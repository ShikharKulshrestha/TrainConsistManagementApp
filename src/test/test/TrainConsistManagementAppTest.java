package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import app.TrainConsistManagementApp;

import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        Assertions.assertEquals(true, TrainConsistManagementApp.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("TRAIN12"));
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("TRN12A"));
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertEquals(true, TrainConsistManagementApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("PET-ab"));
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("PET123"));
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("TRN-123"));
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("PET-Ab"));
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertEquals(false, TrainConsistManagementApp.isValidTrainID(""));
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertEquals(false, TrainConsistManagementApp.isValidTrainID("TRN-1234-EXTRA"));
        assertEquals(false, TrainConsistManagementApp.isValidCargoCode("PET-AB123"));
    }
}