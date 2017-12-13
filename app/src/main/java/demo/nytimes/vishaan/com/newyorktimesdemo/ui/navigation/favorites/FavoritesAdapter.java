package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.favorites;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesHolder> {

    private List<Movie> mMoviesList;

    public FavoritesAdapter() {
        mMoviesList = new ArrayList<>();
    }

    @Override
    public FavoritesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_favorite_item, parent, false);
        return new FavoritesHolder(view);
    }

    @Override
    public void onBindViewHolder(FavoritesHolder holder, int position) {
        holder.bind(mMoviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public void addMovies(List<Movie> movies) {
        mMoviesList.addAll(movies);
        notifyDataSetChanged();
    }
}
