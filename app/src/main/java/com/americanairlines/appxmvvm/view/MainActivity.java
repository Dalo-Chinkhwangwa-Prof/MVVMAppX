package com.americanairlines.appxmvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.americanairlines.appxmvvm.R;
import com.americanairlines.appxmvvm.model.Result;
import com.americanairlines.appxmvvm.viewmodel.AnimeViewModel;

import java.util.List;

import static com.americanairlines.appxmvvm.util.DebugLogger.logDebug;

public class MainActivity extends AppCompatActivity {

    private AnimeViewModel animeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animeViewModel = new ViewModelProvider(
                this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()))
                .get(AnimeViewModel.class);

        animeViewModel.searchForAnime("Goku").observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                logDebug(results.get(0).getTitle() + "");
            }
        });
    }
}