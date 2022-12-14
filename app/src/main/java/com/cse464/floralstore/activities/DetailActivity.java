package com.cse464.floralstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cse464.floralstore.R;
import com.cse464.floralstore.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image = getIntent().getIntExtra("image",0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);

    }
}