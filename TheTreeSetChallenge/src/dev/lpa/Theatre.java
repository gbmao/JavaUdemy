package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Theatre {
    private String name;
    private int seatsInRow;
    private TreeSet<Seat> seats = new TreeSet<>(Comparator.comparing(Seat::getRow).thenComparing(Seat::getNumber));
    private int row;


    public Theatre(String name, int numberOfRow, int numberOfSeats) {
        // the numberOfRow should not exceed 26 / A to Z
        this.name = name;
        this.seatsInRow = numberOfSeats / numberOfRow;
        this.row = numberOfRow;
        createSeat();

    }

    // seatsInRow = numberOfSeats/numberOfRow

    private void createSeat(){
        for (int i = 0; i < row; i++) {

            String letter = "" + ((char) (i + 65));
            for (int j = 0, seatNumber = 1; j < seatsInRow; j++, seatNumber++) {


                seats.add(new Seat(letter, seatNumber, false));
            }
        }
    }

    public void printSeatMap(){

        for (int i = 0; i <row ; i++) {
            String letter = "" + ((char) (i + 65));
        seats.stream().filter(seat -> seat.row.startsWith(letter)).forEach(System.out::print);
            System.out.println();
        }

    }

    public void reserveSeat(String row, int number){
        seats.stream().filter(seat -> seat.row.equalsIgnoreCase(row)).filter(seat ->
                seat.number == number).forEach(seat -> seat.setReserved(true));
    }


    public class Seat {
        private String row;
        private int number;
        private boolean reserved;

        public Seat(String row, int number, boolean reserved) {
            this.row = row;
            this.number = number;
            this.reserved = reserved;
        }

        public String getRow() {
            return row;
        }

        public int getNumber() {
            return number;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        public boolean isReserved() {
            return reserved;
        }

        @Override
        public String toString() {
            String num = "00" + number;
            if(number >= 10) {
                 num = "0" + number;
            }
            if(number >= 100) {
                num = "" + number;
            }
            if(isReserved()){
                String reserved = "(R)";
                return "%-8s".formatted(row + num +reserved);
            }
            return "%-8s".formatted(row + num);
        }

        //        Comparator<Seat> mySort = Comparator.comparing(Seat::getRow).thenComparing(Seat::getNumber);
    }
}
