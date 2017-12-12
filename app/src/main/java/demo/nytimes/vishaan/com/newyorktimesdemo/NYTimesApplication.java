package demo.nytimes.vishaan.com.newyorktimesdemo;

import android.app.Application;

import demo.nytimes.vishaan.com.newyorktimesdemo.di.component.AppComponent;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.component.DaggerAppComponent;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.AppModule;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.NYTimesModule;
import demo.nytimes.vishaan.com.newyorktimesdemo.di.module.NetworkModule;

/**
 * Created by vishaantiwarie on 12/11/17.
 */

public class NYTimesApplication extends Application {
    private static AppComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .nYTimesModule(new NYTimesModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
