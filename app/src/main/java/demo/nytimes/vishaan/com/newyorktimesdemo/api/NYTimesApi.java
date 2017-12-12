package demo.nytimes.vishaan.com.newyorktimesdemo.api;

import java.util.List;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vishaantiwarie on 12/11/17.
 */

public interface NYTimesApi {

    @GET("svc/movies/v2/reviews/search.json")
    Observable<List<Movie>> getMovieReviews(@Query("api-key") String query);
}

