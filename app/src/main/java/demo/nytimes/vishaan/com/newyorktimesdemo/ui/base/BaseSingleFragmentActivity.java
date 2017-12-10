package demo.nytimes.vishaan.com.newyorktimesdemo.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseSingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeFragment(createInitialFragment());
    }

    protected void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(getFragmentId(), fragment)
                .commit();
    }

    protected abstract Fragment createInitialFragment();
    protected abstract int getFragmentId();
}
