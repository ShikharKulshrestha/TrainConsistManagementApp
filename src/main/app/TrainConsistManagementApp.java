package app; // replace with your actual package, or remove if none

import java.util.List;

public class TrainConsistManagementApp {

    // GoodsBogie class
    public static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }
    }

    // UC12: Safety Compliance Check
    public static boolean isTrainSafetyCompliant(List<GoodsBogie> goodsBogies) {
        return goodsBogies.stream()
                .allMatch(bogie -> {
                    if ("Cylindrical".equalsIgnoreCase(bogie.getType())) {
                        return "Petroleum".equalsIgnoreCase(bogie.getCargo());
                    }
                    return true; // other bogies are flexible
                });
    }

    // Demo main method
    public static void main(String[] args) {
        List<GoodsBogie> bogies = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Open", "Grain")
        );

        boolean isSafe = isTrainSafetyCompliant(bogies);
        System.out.println("Train safety compliant: " + (isSafe ? "Yes" : "No"));
    }
}