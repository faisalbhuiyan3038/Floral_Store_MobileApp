package com.cse464.floralstore.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.cse464.floralstore.Adapters.OrdersAdapter;
import com.cse464.floralstore.Models.OrdersModel;
import com.cse464.floralstore.R;
import com.cse464.floralstore.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel>list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.pinks,"Essence" , "500", "1830995"));
        list.add(new OrdersModel(R.drawable.purple,"Purple Vibrant" , "650", "1921298"));
        list.add(new OrdersModel(R.drawable.pinks,"Essence" , "500", "1830995"));
        list.add(new OrdersModel(R.drawable.pinks,"Essence" , "500", "1830995"));
        list.add(new OrdersModel(R.drawable.pinks,"Essence" , "500", "1830995"));

        OrdersAdapter adapter = new OrdersAdapter(list , this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}