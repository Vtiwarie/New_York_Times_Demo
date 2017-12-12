package demo.nytimes.vishaan.com.newyorktimesdemo.di.component;

/**
 * Created by vishaantiwarie on 12/11/17.
 */

import javax.inject.Singleton;

import dagger.Component;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.AppModule;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.NYTimesModule;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.NetworkModule;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.NavigationActivity;
import demo.nytimes.vishaan.com.newyorktimesdemo.ui.navigation.movies.MovieReviewsFragment;

/**
 *
 *
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, NYTimesModule.class})
public interface AppComponent {

    void inject(MovieReviewsFragment fragment);
}
