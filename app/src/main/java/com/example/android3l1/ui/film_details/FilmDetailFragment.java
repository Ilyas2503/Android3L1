package com.example.android3l1.ui.film_details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android3l1.App;
import com.example.android3l1.data.models.Films;
import com.example.android3l1.databinding.FragmentFilmDetailBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        String id = getArguments().getString("key");
        App.api.getFilm(id).enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                setData(response.body());
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {

            }
        });

    }

    private void setData(Films body) {
        binding.title.setText(body.getTitle());
        binding.description.setText(body.getDescription());
        binding.director.setText(body.getDirector());
        binding.originalTitle.setText(body.getOriginalTitle());
        binding.releaseDate.setText(body.getReleaseDate());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFilmDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}