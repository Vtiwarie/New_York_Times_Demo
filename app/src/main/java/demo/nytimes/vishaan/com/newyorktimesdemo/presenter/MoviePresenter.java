package demo.nytimes.vishaan.com.newyorktimesdemo.presenter;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.MovieReviewsObject;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iMoviePresenterInterface;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies.MovieReviewsFragment;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MoviePresenter extends BasePresenter implements Observer<MovieReviewsObject> {

    private iMoviePresenterInterface iMoviePresenterInterface;

    public MoviePresenter(iMoviePresenterInterface viewInterface) {
        iMoviePresenterInterface = viewInterface;
    }

    @Override
    public void onError(Throwable e) {
        iMoviePresenterInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(MovieReviewsObject movieReviewsObject) {
        iMoviePresenterInterface.onMovies(movieReviewsObject);
    }

    public void fetchMovies() {
        unSubscribeAll();
        subscribe(iMoviePresenterInterface.getMovies(), MoviePresenter.this);
    }

    @Override
    public void onSubscribe(Disposable d) {
        //nothing for now
    }

    @Override
    public void onComplete() {
        iMoviePresenterInterface.onCompleted();
    }
}
