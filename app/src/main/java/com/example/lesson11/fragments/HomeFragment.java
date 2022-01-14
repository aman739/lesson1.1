package com.example.lesson11.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson11.R;
import com.example.lesson11.databinding.FragmentHomeBinding;
import com.example.lesson11.homeAdapter.HomeAdapter;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    String text;
    String number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
        initAdapter();
        initClickers();

    }


    private String getData() {
        if (getArguments() != null) {
            text = getArguments().getString("key");
            number = getArguments().getString("A");
            return text;

        }
        return "";
    }
    private void initAdapter() {
        HomeAdapter homeAdapter = new HomeAdapter();
        binding.homeRecycler.setAdapter(homeAdapter);
        if (!getData().isEmpty()) {
            homeAdapter.addText(text);
            homeAdapter.addText(number);
        }
    }

    private void initClickers() {
        binding.btnOpenCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(requireView()).navigate(R.id.createTaskFragment);
            }
        });
    }
}