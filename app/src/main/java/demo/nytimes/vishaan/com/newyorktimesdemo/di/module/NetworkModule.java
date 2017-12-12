package demo.nytimes.vishaan.com.newyorktimesdemo.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import demo.nytimes.vishaan.com.newyorktimesdemo.BuildConfig;
import demo.nytimes.vishaan.com.newyorktimesdemo.api.RetrofitInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 *
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new RetrofitInterceptor()).build();
    }

    @Provides
    @Singleton
    GsonConverterFactory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

    @Provides
    @Singleton
    Retrofit provideNYTimesMovieData(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                 .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
