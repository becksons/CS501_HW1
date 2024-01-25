package com.example.helloworld;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.helloworld.databinding.FragmentSecondBinding;


public class World extends Fragment {
    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(World.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        ImageView imageView = view.findViewById(R.id.myGifImageView);
        Glide.with(this).asGif().load(R.drawable.helloturtle).into(imageView);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}