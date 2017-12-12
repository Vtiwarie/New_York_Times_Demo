package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import demo.nytimes.vishaan.com.newyorktimesdemo.BuildConfig;
import demo.nytimes.vishaan.com.newyorktimesdemo.NYTimesApplication;
import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.api.NYTimesApi;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.MovieReviewsObject;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.MoviePresenter;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iMoviePresenterInterface;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.base.BaseFragment;
import demo.nytimes.vishaan.com.newyorktimesdemo.utils.Util;
import io.reactivex.Observable;

public class MovieReviewsFragment extends BaseFragment implements iMoviePresenterInterface {
    @Inject
    NYTimesApi nyTimesApi;

    private MoviePresenter moviePresenter;

    public MovieReviewsFragment() {
        // Required empty public constructor
    }

    public static MovieReviewsFragment newInstance() {
        MovieReviewsFragment fragment = new MovieReviewsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie_reviews, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set title
        getActivity().setTitle(R.string.movie_reviews);

        //inject dependencies with Dagger 2
        NYTimesApplication.getComponent().inject(MovieReviewsFragment.this);

        //presentation
        moviePresenter = new MoviePresenter(MovieReviewsFragment.this);
        moviePresenter.onCreate();
    }

    @Override
    public void onStart() {
        super.onStart();
        moviePresenter.fetchMovies();
    }

    @Override
    public void onCompleted() {
        //do nothing for now
    }

    @Override
    public void onError(String message) {
        Util.logDebug(getClass().getName(), message);
    }

    @Override
    public void onMovies(MovieReviewsObject movieResponses) {
        Util.logDebug(getClass().getName(), movieResponses.toString());
    }

    @Override
    public Observable<MovieReviewsObject> getMovies() {
        return nyTimesApi.getMovieReviews(BuildConfig.API_KEY);
    }
}
