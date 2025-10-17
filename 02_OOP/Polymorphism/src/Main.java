import java.util.Scanner;

public class Main {

    public static void main(String[] args){

//        Movie theMovie = new Movie("Run!");
//
//        Terror theTerror = new Terror("Godzilla");
//
//        theMovie.watchMovie();
//
//        theTerror.watchMovie();

//        Comedy theComedy = new Comedy("LOTR");
//
//        theComedy.watchMovie();
//
//        ScienceFiction scifi = new ScienceFiction("Alien Attacks");
//
//        scifi.watchMovie();

//        Movie theMovie = Movie.getMovie("Adventure", "Star Wars");
//        theMovie.watchMovie();
//        Movie.getMovie("comedy","lotr" );

        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("Enter Type ( A for adventure, C for Comedy, " +
                    "S for science fiction, or Q to quit: ");
            String type = s.nextLine();
            if ("Qq".contains(type)){
                break;
            }
            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type,title);
            movie.watchMovie();
        }




    }
}
