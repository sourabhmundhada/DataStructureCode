import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 *
 * @author sourabhmundhada
 */
public class Movies {

    private String name;
    private float rating;
    private List<Movies> relatedMovies;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movies> getRelatedMovies() {
        return relatedMovies;
    }

    public void setRelatedMovies(List<Movies> relatedMovies) {
        this.relatedMovies = relatedMovies;
    }

    private List<String> moviesName = new ArrayList<String>();

    //Below code will return list of related Movies
    public List<String> traverseMoviesListandReturnName(Movies movies) {
        if (movies.getRelatedMovies() == null) {
            moviesName.add(movies.getName());
            return moviesName;
        } else {
            for (Movies movie : movies.getRelatedMovies()) {
                List<String> childMovies = traverseMoviesListandReturnName(movie);
            }
            moviesName.add(movies.getName());
            return moviesName;
        }
    }

    //Below Code will return sorted map of movies and rating. sorting is done on rating
    public Map<?, ?> traverseMoviesListandReturnRatedMovies(Movies movies) {
        Map<Float, Movies> movieList = new TreeMap<>();
        Queue<Movies> queueList = new LinkedList<>();
        queueList.add(movies);
        while (!queueList.isEmpty()) {
            Movies tempMovie = queueList.poll();
            System.out.print(tempMovie.getName());
            movieList.put(tempMovie.getRating(), movies);
            if (tempMovie.getRelatedMovies() != null) {
                for (Movies movie : tempMovie.getRelatedMovies()) {
                    queueList.add(movie);
                }
            }
        }
        return movieList;
    }

    //Below code will return the list of related movies and the list is restricted by number of movies
    public List<Movies> getLimitedRelatedListofMovies(Movies movies, int numberOfMovies) {
        List<Movies> movieList = new ArrayList<>();
        Queue<Movies> queueList = new LinkedList<>();
        queueList.add(movies);
        while (!queueList.isEmpty()) {
            Movies tempMovie = queueList.poll();
            System.out.print(tempMovie.getName());
            if (movieList.isEmpty() || movieList.size() != numberOfMovies) {
                movieList.add(tempMovie);
            } else {
                Collections.sort(movieList, new Comparator<Movies>() {
                    @Override
                    public int compare(Movies o1, Movies o2) {
                        return o1.getRating() > o2.getRating() ? 1 : -1;
                    }
                }
                );
                Movies firstSortedMovie = movieList.iterator().next();
                if (firstSortedMovie.getRating() < tempMovie.getRating()) {
                    movieList.remove(firstSortedMovie);
                    movieList.add(tempMovie);
                }
            }
            if (tempMovie.getRelatedMovies() != null) {
                for (Movies movie : tempMovie.getRelatedMovies()) {
                    queueList.add(movie);
                }
            }
        }
        return movieList;
    }

    private int tempCount = 0;
    // Below code will print movie tree for non development users from the list of movies. 
    public void printListOfMoviesForNonDevelopmentUser(Movies movies){    
        System.out.println();
        for(int i = 0; i < tempCount; i++){
            System.out.print(" ");
        }
        System.out.print("-"+movies.getName());
        if(movies.relatedMovies != null){
            for(Movies movie : movies.relatedMovies){
                tempCount++;
                printListOfMoviesForNonDevelopmentUser(movie);
            }
            tempCount--;
        } else {
            tempCount--;
        }
    }
    
    // Below code will print movie tree for non development users from the list of movies witout using temporary variable.
    public void printListOfMoviesForNonDevelopmentUser(Movies movies, int count) {
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
        System.out.print("-" + movies.getName());
        if (movies.relatedMovies != null) {
            for (Movies movie : movies.relatedMovies) {
                printListOfMoviesForNonDevelopmentUser(movie, count+1);
            }
        }
    }

}
