package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.classes.ServerManager;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.base.BaseFragment;

public class MovieReviewsFragment extends BaseFragment {

    public static final int REQUEST_CODE_GET_MOVIE_REVIEWS = 0x0000;

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
        getActivity().setTitle(R.string.movie_reviews);
        makeApiCall(REQUEST_CODE_GET_MOVIE_REVIEWS, null);
    }

    @Override
    protected void makeApiCall(int requestCode, Bundle params) {
        switch (requestCode) {
            case REQUEST_CODE_GET_MOVIE_REVIEWS:
                break;
        }
    }
}
