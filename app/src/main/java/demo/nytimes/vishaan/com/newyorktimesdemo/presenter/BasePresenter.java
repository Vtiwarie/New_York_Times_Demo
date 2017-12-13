package demo.nytimes.vishaan.com.newyorktimesdemo.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public abstract class BasePresenter {

    protected <F> void subscribe(Observable<F> observable, Observer<F> observer) {
       observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
