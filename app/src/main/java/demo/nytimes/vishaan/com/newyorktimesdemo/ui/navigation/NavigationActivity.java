package demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import demo.nytimes.vishaan.com.newyorktimesdemo.R;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.base.BaseSingleFragmentActivity;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.favorites.FavoritesFragment;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies.MovieReviewsFragment;

public class NavigationActivity extends BaseSingleFragmentActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_movies:
                    fragment = MovieReviewsFragment.newInstance();
                    break;
                case R.id.navigation_favorites:
                    fragment = FavoritesFragment.newInstance();
                    break;
            }
            if(fragment != null) {
                changeFragment(fragment);
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected Fragment createInitialFragment() {
        return MovieReviewsFragment.newInstance();
    }

    @Override
    protected int getFragmentId() {
        return R.id.fragment_container;
    }
}
