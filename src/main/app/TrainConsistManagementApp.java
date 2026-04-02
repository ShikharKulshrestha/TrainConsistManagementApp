package app;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {

    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static boolean isValidTrainID(String trainId) {
        if (trainId == null || trainId.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }
}