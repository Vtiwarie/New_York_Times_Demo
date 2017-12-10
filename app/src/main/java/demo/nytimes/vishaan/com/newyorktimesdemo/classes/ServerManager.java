package demo.nytimes.vishaan.com.newyorktimesdemo.classes;

/**
 * Created by vishaantiwarie on 12/10/17.
 */

public class ServerManager {
    private static ServerManager instance;

    private ServerManager() {
    }

    public static ServerManager getInstance() {
        if (instance == null) {
            instance = new ServerManager();
        }
        return instance;
    }
}
