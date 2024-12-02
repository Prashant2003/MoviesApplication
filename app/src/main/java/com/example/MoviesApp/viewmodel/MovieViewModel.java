package com.example.MoviesApp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.MoviesApp.model.Movie;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private final MutableLiveData<List<Movie>> moviesLiveData = new MutableLiveData<>();
    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    public LiveData<List<Movie>> getMovies() {
        return moviesLiveData;
    }

    public void fetchMovies() {
        firestore.collection("movies").get()
                .addOnSuccessListener(querySnapshot -> {
                    List<Movie> movies = querySnapshot.toObjects(Movie.class);
                    moviesLiveData.setValue(movies);
                });
    }

    public void addMovie(Movie movie) {
        firestore.collection("movies").add(movie);
    }

    public void updateMovie(String id, Movie movie) {
        firestore.collection("movies").document(id).set(movie);
    }

    public void deleteMovie(String id) {
        firestore.collection("movies").document(id).delete();
    }
}
