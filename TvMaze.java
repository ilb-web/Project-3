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
* program uses TVMaze API to retrieve two shows that are randomly generated
* from a list of show ids and
* prompts the user to guess which one has a higher rating.
*/
public class TvMaze {
    /*
     * creates list of show ids
     * calls retrieveShows to get two random show ids
     * calls retrieveData() for each id and to print the show names
     * prompts user to guess which show has a higher rating
     * prints whether user was correct or not
     * calls retrieveSchedule() to get streaming schedule of the correct show
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an show's name:");
        retrieveData(scanner.nextLine());
        scanner.close();
    }

    // retrieves data from the web API with id
    // temporarily for skeleton program: retrieves and displays show information
    // with name
    public static String retrieveData(String show) throws IOException, InterruptedException {
        String baseURL = "https://api.tvmaze.com//singlesearch/shows?q=";
        String encodedShow = URLEncoder.encode(show, StandardCharsets.UTF_8);
        String fullURL = baseURL + encodedShow;

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

    // gets tv shows id list to randomly choose two ids
    // returns the two ids as an array
    public static int[] retrieveShows(List<Integer> showIds) {
        return null;
    }

    // retrieves rating of a show
    // returns rating
    public static double retrieveRating(String ratingData) {
        return 0.0;
    }

    // compares the two shows ratings
    // returns id of the higher rated show
    // calls retrieveData() and retriveRating() for the ids
    public static double retrieveRating(int showId1, int showId2) throws IOException, InterruptedException {
        return 0.0;
    }

    // retrives and displays the streaming schedule of the correct show from the
    // user's quiz.
    public static void retrieveSchedule(int showId) throws IOException, InterruptedException {
    }

}
