import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

/* 
* retrieves data to display highest rated tv shows for an actor and under "x" binging hours.
* orders the tv shows from highest to lowest.
* retrieves and displays the streaming schedule for a specified show from list.
*/
public class TvMaze {
    /*
     * prompts user for input for actorName and hours
     * calls retrieve data, finding actor information with the user input,
     * temporarily for the program to compile
     * 
     * calls searchActor to get the personId
     * calls retrieveShows to get list of shows
     * calls highestToLowest to reorder list and display top rated shows
     * prompts user to enter a show, then calls retrieveSchedule
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an actor's name:");
        retrieveData(scanner.nextLine());
        scanner.close();
    }

    // retrieves data from the web API
    public static String retrieveData(String actor) throws IOException, InterruptedException {
        String baseURL = "https://api.tvmaze.com/search/people?q=";
        String encodedActor = URLEncoder.encode(actor, StandardCharsets.UTF_8);
        String fullURL = baseURL + encodedActor;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(fullURL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println("Tv-show data received:\n" + response.statusCode());
            System.out.println(response.body());
        } else {
            System.out.println("Data not received. Status code: " + response.statusCode());
        }
        return null;
    }

    // searches for an actor by name
    // returns personId
    public static int searchActor(String actorName) {
        return 0;
    }

    // retrieves tv shows the actor has been in through through the personId
    // from searchActor().
    // returns list of tv shows.
    public static List<Show> retrieveShows(int personId) {
        return null;
    }

    // calls retrieveShows, filters to highest rated shows and reorders the list
    // from highest to lowest ratings.
    // returns the reordered list of tv shows.
    public static List<Show> highestToLowest(List<Show> tvShows, double hours) {
        return null;
    }

    // retrives and displays the streaming schedule of specified show from list.
    public static void retrieveSchedule(int showId) {

    }

    // class to help with modifying the data
    static class Show {
        int id;
        String name;
        double rating;
        int runtime;
    }

}
