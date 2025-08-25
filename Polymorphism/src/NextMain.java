import java.security.UnrecoverableKeyException;

public class NextMain {

    public static void main(String[] args) {

        Movie movie = Movie.getMovie("A","Jaws");
        movie.watchMovie();



        var comedy = Comedy.getMovie("C", "Airplane");

        comedy.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        Object unknownObject = Movie.getMovie("S", "Airplane");
        if(unknownObject.getClass().getSimpleName() == "Comedy"){
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof  ScienceFiction syfy) {
            syfy.watchScience();
        }




    }
}
