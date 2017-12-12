package demo.nytimes.vishaan.com.newyorktimesdemo.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.nytimes.vishaan.com.newyorktimesdemo.api.NYTimesApi;
import retrofit2.Retrofit;

/**
 *
 *
 */
@Module
public class NYTimesModule {

    @Provides
    @Singleton
    NYTimesApi provideRetrofit(Retrofit retrofit) {
        return retrofit.create(NYTimesApi.class);
    }
}
