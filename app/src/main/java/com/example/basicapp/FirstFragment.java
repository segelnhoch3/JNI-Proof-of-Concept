package com.example.basicapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.basicapp.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //This adds an event listener that calls the clicked()-fuction when the button on screen is pressed.
        binding.b2.setOnClickListener(v ->
                clicked()
        );
    }

    /*
    Executes when the button is pressed. Calls the special() native function that is implemented in
    Rust in the file lib.rs and defined in the file HelloWorld.java
     */
    public void clicked(){

        ArrayList<Integer> in = new ArrayList<>();
        in.add(1);
        in.add(2);
        in.add(3);


        String display;
        try {
            // Here, the Rust-function gets called and gets an ArrayList and an int passed along.
            // The Rust function will add the int to the ArrayList
            // (Which is a Vec<i32> in Rust in this case) and return it.
            ArrayList<String> output = HelloWorld.special(in, 5);

            display = "Success! Return value: " + output;
        }catch (Error e){
            display = "Error during build process. Check LogCat for error message";
            e.printStackTrace();
        }

        //Shows the return value on screen
        Toast.makeText(getContext(), display, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}