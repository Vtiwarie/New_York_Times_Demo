package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.favorites;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.List;

import au.com.gridstone.rxstore.Converter;
import au.com.gridstone.rxstore.ListStore;
import au.com.gridstone.rxstore.RxStore;
import au.com.gridstone.rxstore.converters.GsonConverter;
import butterknife.BindView;
import butterknife.ButterKnife;
import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.FavoritesPresenter;
import demo.nytimes.vishaan.com.newyorktimesdemo.presenter.interfaces.iFavoritesPresenterInterface;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.base.BaseFragment;
import demo.nytimes.vishaan.com.newyorktimesdemo.utils.Util;
import io.reactivex.Observable;

/**
 * My Favorites fragment
 */
public class FavoritesFragment extends BaseFragment implements iFavoritesPresenterInterface {

    @BindView(R.id.recycler_favorites)
    RecyclerView recyclerView;

    private FavoritesPresenter favoritesPresenter;

    public FavoritesFragment() {
        // Required empty public constructor
    }

    public static FavoritesFragment newInstance() {
        FavoritesFragment fragment = new FavoritesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);
        ButterKnife.bind(this, view);
        setup();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.title_favorites);

        favoritesPresenter = new FavoritesPresenter(this);
    }

    private void setup() {
        recyclerView.setAdapter(new FavoritesAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setRecycledViewPool(new RecycledViewPool());
    }

    @Override
    public void onResume() {
        super.onResume();
        favoritesPresenter.fetchMovies();
    }

    @Override
    public void onCompleted() {
        //do nothing
    }

    @Override
    public void onError(String message) {
        Util.logError(getClass().getName(), message);
    }

    @Override
    public void onMovies(List<Movie> movieResponses) {
        ((FavoritesAdapter) recyclerView.getAdapter()).addMovies(movieResponses);
    }

    @Override
    public Observable<List<Movie>> getMovies() {
        Converter converter = new GsonConverter();
        ListStore<Movie> movieListStore = RxStore.list(new File(getActivity().getFilesDir() + "/movies"), converter, Movie.class);
        return movieListStore.get().toObservable();
    }
}
