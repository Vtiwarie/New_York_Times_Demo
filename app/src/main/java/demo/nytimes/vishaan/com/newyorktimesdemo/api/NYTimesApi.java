package demo.nytimes.vishaan.com.newyorktimesdemo.api;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vishaantiwarie on 12/11/17.
 */

public interface NYTimesApi {

    @GET("search/tweets.json")
    Flowable<Movie> getMovieReviews(@Query("q") String query);
}

