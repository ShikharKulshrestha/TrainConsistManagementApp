public class TrainConsistManagementApp { class InvalidCapacityException extends Exception {

    public InvalidCapacityException(String message) {
        super(message);
    }
}
    class PassengerBogie {

        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid bogie capacity: " + capacity);
            }

            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }
    }
    public class TrainConsistManagementSystem {

        public static void main(String[] args) {

            try {

                PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
                PassengerBogie bogie2 = new PassengerBogie("AC Chair", -10);

                System.out.println("Bogie created with capacity: " + bogie1.getCapacity());

            } catch (InvalidCapacityException e) {

                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
