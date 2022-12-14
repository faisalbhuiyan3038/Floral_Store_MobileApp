package com.cse464.floralstore.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

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
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.nameTitle.setText(name);
        binding.detailDescription.setText(description);
    }
}