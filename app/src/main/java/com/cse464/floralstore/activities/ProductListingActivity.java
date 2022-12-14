package com.cse464.floralstore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cse464.floralstore.Adapters.MainAdapter;
import com.cse464.floralstore.Models.MainModel;
import com.cse464.floralstore.R;
import com.cse464.floralstore.databinding.ActivityFlowerProductListingBinding;
import com.cse464.floralstore.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ProductListingActivity extends AppCompatActivity {
    ActivityFlowerProductListingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFlowerProductListingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.myOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductListingActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.pinks, "Essence" , "500" , "Essence is all about beautiful and light scent."));
        list.add(new MainModel(R.drawable.purple, "Purple Vibrant" , "650" , "Make a day with this bright and vibrant collection of flowers, beautifully presented in a gift box."));
        list.add(new MainModel(R.drawable.white, "Ava" , "600" , "A creamy selection of blossoming buds in shades of white."));
        list.add(new MainModel(R.drawable.pw, "Pretty in pink" , "550" , "Our Pretty Pink Bouquet is the perfect assortment of roses, carnations,and statice."));
        list.add(new MainModel(R.drawable.sun, "Athena" , "400" , "Simple single-sunflower bouquet, option to add a ring or chamomile."));

        MainAdapter adapter = new MainAdapter(list , this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }
}