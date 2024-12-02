package com.example.MoviesApp.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.MoviesApp.R;
import com.example.MoviesApp.adapter.MovieAdapter;
import com.example.MoviesApp.viewmodel.MovieViewModel;

public class MovieListActivity extends AppCompatActivity {
    private MovieViewModel viewModel;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.getMovies().observe(this, movies -> adapter.updateMovies(movies));
        viewModel.fetchMovies();
    }
}
