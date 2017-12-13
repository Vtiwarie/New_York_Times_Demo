package demo.nytimes.vishaan.com.newyorktimesdemo.presenter;

import java.util.List;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.MovieReviewsObject;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iFavoritesPresenterInterface;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iMoviePresenterInterface;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Presenter class for displaying favorites
 */
public class FavoritesPresenter extends BasePresenter implements Observer<List<Movie>> {

    private iFavoritesPresenterInterface iFavoritesPresenterInterface;

    public FavoritesPresenter(iFavoritesPresenterInterface viewInterface) {
        iFavoritesPresenterInterface = viewInterface;
    }

    @Override
    public void onError(Throwable e) {
        iFavoritesPresenterInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<Movie> movieReviewsObject) {
        iFavoritesPresenterInterface.onMovies(movieReviewsObject);
    }

    public void fetchMovies() {
        subscribe(iFavoritesPresenterInterface.getMovies(), FavoritesPresenter.this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        //nothing for now
    }

    @Override
    public void onComplete() {
        iFavoritesPresenterInterface.onCompleted();
    }
}
