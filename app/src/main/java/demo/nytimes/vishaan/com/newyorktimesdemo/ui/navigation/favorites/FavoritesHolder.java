package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.favorites;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.model.Movie;
import demo.nytimes.vishaan.com.newyorktimesdemo.utils.ImageUtil;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public class FavoritesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_favorite_image)
    ImageView favoriteMovieImage;

    @BindView(R.id.txt_title)
    TextView titleTextView;

    @BindView(R.id.txt_summary)
    TextView summaryTextView;

    public FavoritesHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Movie movie) {
        final View view = itemView;
        ImageUtil.loadImage(view.getContext(), favoriteMovieImage, movie.getMultimedia().getSrc());
        titleTextView.setText(movie.getDisplayTitle());
        summaryTextView.setText(movie.getSummary_short());
    }
}