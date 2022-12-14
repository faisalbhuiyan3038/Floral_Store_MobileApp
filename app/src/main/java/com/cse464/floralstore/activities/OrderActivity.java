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

        DBHelper helper  = new DBHelper(this);
        ArrayList<OrdersModel>list = helper.getOrders();

        OrdersAdapter adapter = new OrdersAdapter(list , this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);
    }
}