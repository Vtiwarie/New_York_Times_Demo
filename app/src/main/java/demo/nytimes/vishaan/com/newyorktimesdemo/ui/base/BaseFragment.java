package demo.nytimes.vishaan.com.newyorktimesdemo.ui.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Always good practice to create a base fragment
 */
public abstract class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }

    protected abstract void makeApiCall(int requestCode, Bundle params);
}
