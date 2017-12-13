package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import au.com.gridstone.rxstore.Converter;
import au.com.gridstone.rxstore.ListStore;
import au.com.gridstone.rxstore.RxStore;
import au.com.gridstone.rxstore.ValueStore;
import au.com.gridstone.rxstore.converters.GsonConverter;
import butterknife.BindView;
import butterknife.ButterKnife;
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
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class MovieReviewsFragment extends BaseFragment implements iMoviePresenterInterface {
    private MoviePresenter moviePresenter;
    private MovieReviewsObject movieReviewsObject;

    @Inject
    NYTimesApi nyTimesApi;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @BindView(R.id.txt_title)
    TextView titleTextView;

    @BindView(R.id.txt_summary)
    TextView summaryTextView;

    @BindView(R.id.btn_save)
    Button saveButton;

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
        ButterKnife.bind(this, view);
        setUpViewPager();
        setUpButtonHandler();
        return view;
    }

    private void setUpButtonHandler() {
        saveButton.setOnClickListener(view -> {
            Converter converter = new GsonConverter();

            ListStore<Movie> moviesStore = RxStore.list(new File(getActivity().getFilesDir() + "/movies"), converter, Movie.class);
            moviesStore.observe().subscribe(people -> {
            });
            final Movie currentMovie = movieReviewsObject.getResults().get(viewPager.getCurrentItem());
            moviesStore.addOrReplace(currentMovie, Schedulers.trampoline(), value -> value.hashCode() == currentMovie.hashCode());
            Util.toast(getActivity(), "Saved Movie");
        });
    }

    private void setUpViewPager() {
        //initialize viewpager
        viewPager.setAdapter(new MoviePagerAdapter());
        viewPager.addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (movieReviewsObject != null) {
                    final List<Movie> movies = movieReviewsObject.getResults();
                    if (movies != null) {
                        bind(movies.get(position));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
        Util.logError(getClass().getName(), message);
    }

    @Override
    public void onMovies(MovieReviewsObject movieResponses) {
        this.movieReviewsObject = movieResponses;
        //save the movie response object
        if (this.movieReviewsObject != null) {
            //update the viewpager title and images via its adapter
            final MoviePagerAdapter moviePagerAdapter = (MoviePagerAdapter) viewPager.getAdapter();
            moviePagerAdapter.setMovieList(movieResponses.getResults());
            bind(movieResponses.getResults().get(0));
            moviePagerAdapter.notifyDataSetChanged();
        } else {
            //TODO send errors and crash reports to backend when created
            Util.logError(getClass().getName(), "Could not load movie reviews.");
        }
    }

    private void bind(Movie movie) {
        titleTextView.setText(movie.getDisplayTitle());
        summaryTextView.setText(movie.getSummary_short());
    }

    @Override
    public Observable<MovieReviewsObject> getMovies() {
        return nyTimesApi.getMovieReviews(BuildConfig.API_KEY);
    }
}
