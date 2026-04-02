package app; // replace with your package or remove if none

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // PassengerBogie class for UC13 testing
    public static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
        public int getCapacity() { return capacity; }
    }

    // Loop-based filtering
    public static List<PassengerBogie> filterBogiesWithLoop(List<PassengerBogie> bogies, int minCapacity) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie bogie : bogies) {
            if (bogie.getCapacity() > minCapacity) {
                result.add(bogie);
            }
        }
        return result;
    }

    // Stream-based filtering
    public static List<PassengerBogie> filterBogiesWithStream(List<PassengerBogie> bogies, int minCapacity) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > minCapacity)
                .collect(Collectors.toList());
    }

    // Main method to benchmark
    public static void main(String[] args) {
        // Example dataset
        List<PassengerBogie> bogies = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            bogies.add(new PassengerBogie("Sleeper", i % 100));
        }

        // Loop-based
        long startLoop = System.nanoTime();
        List<PassengerBogie> loopFiltered = filterBogiesWithLoop(bogies, 60);
        long endLoop = System.nanoTime();
        System.out.println("Loop filtering count: " + loopFiltered.size() + ", Time: " + (endLoop - startLoop) + " ns");

        // Stream-based
        long startStream = System.nanoTime();
        List<PassengerBogie> streamFiltered = filterBogiesWithStream(bogies, 60);
        long endStream = System.nanoTime();
        System.out.println("Stream filtering count: " + streamFiltered.size() + ", Time: " + (endStream - startStream) + " ns");
    }
}