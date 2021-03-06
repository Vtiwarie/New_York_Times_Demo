package demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces;

import java.util.List;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.MovieReviewsObject;
import io.reactivex.Observable;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public interface iFavoritesPresenterInterface {
    void onCompleted();

    void onError(String message);

    void onMovies(List<Movie> movieResponses);

    Observable<List<Movie>> getMovies();
}
