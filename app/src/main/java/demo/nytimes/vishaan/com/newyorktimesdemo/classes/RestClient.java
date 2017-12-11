package demo.nytimes.vishaan.com.newyorktimesdemo.classes;

/**
 * Created by vishaantiwarie on 12/10/17.
 */

public class RestClient {
    private static RestClient instance;

    private RestClient() {
    }

    public static RestClient getInstance() {
        if (instance == null) {
            instance = new RestClient();
        }
        return instance;
    }

    public void makeCall() {
    }


}
