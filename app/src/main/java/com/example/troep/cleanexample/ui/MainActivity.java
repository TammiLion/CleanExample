package com.example.troep.cleanexample.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.troep.cleanexample.App;
import com.example.troep.cleanexample.R;
import com.example.troep.cleanexample.network.PokeApi;
import com.example.troep.cleanexample.network.pojo.Pokemon;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    PokeApi mApi;

    private Disposable mDisposable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.get().getInjector().inject(this);

        test();
    }

    private void test() {
        mDisposable = mApi.getPokemon(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pokemon -> {
                    Timber.d(pokemon.name);
                    for (Pokemon.Stats stat : pokemon.stats) {
                        Timber.d(stat.stat.name + " -> " + stat.base_stat);
                    }
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
