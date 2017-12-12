package demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.MovieReviewsObject;
import io.reactivex.Observable;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public interface iMoviePresenterInterface {
    void onCompleted();

    void onError(String message);

    void onMovies(MovieReviewsObject movieResponses);

    Observable<MovieReviewsObject> getMovies();
}
