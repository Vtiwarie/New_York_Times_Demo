package demo.nytimes.vishaan.com.newyorktimesdemo.presenter;

import java.util.List;

import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iMoviePresenterInterface;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MoviePresenter extends BasePresenter implements Observer<List<Movie>> {

    private iMoviePresenterInterface iMoviePresenterInterface;

    public MoviePresenter(iMoviePresenterInterface viewInterface) {
        iMoviePresenterInterface = viewInterface;
    }

    @Override
    public void onError(Throwable e) {
        iMoviePresenterInterface.onError(e.getMessage());
    }

    @Override
    public void onNext(List<Movie> movieResponse) {
        iMoviePresenterInterface.onMovies(movieResponse);
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
