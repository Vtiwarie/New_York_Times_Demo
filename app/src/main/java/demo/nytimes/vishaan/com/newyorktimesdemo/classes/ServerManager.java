package demo.nytimes.vishaan.com.newyorktimesdemo.classes;

import org.reactivestreams.Subscriber;

/**
 * Created by vishaantiwarie on 12/10/17.
 */

public class ServerManager {
    private static ServerManager instance;
    private RestClient restClient;

    private ServerManager() {
        restClient = RestClient.getInstance();
    }

    public static ServerManager getInstance() {
        if (instance == null) {
            instance = new ServerManager();
        }
        return instance;
    }

    public void getMovieReviews(Subscriber subscriber) {

    }
}
