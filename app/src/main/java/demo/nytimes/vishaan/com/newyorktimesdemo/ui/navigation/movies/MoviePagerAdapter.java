package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.utils.ImageUtil;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public class MoviePagerAdapter extends PagerAdapter {

    private List<Movie> movieList;

    @BindView(R.id.iv_movie_image)
    ImageView movieImageView;

    @Override
    public int getCount() {
        return movieList != null ? movieList.size() : 0;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Movie movie = getMovieList().get(position);
        final Context context = container.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_movie_item, container, false);
        ButterKnife.bind(this, view);
        ImageUtil.loadImage(context, movieImageView, movie.getMultimedia().getSrc());
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
