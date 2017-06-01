package com.example.android.fragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements View.OnClickListener{

    private FOneCallback callback;
    Button sayHiToTwo;
    Button sayByeToTwo;
    TextView resultTVOne;

    public interface FOneCallback{
        void sayHiToTwo(String greeting);
        void sayByeToTwo(String farewell);
        void onMessageReceived(String message);
    }

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (FOneCallback) getActivity();

        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " must implement FOneCallback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        sayHiToTwo = (Button) view.findViewById(R.id.hi_from_one);
        sayByeToTwo = (Button) view.findViewById(R.id.bye_from_one);
        sayHiToTwo.setOnClickListener(this);
        sayByeToTwo.setOnClickListener(this);
        resultTVOne = (TextView) view.findViewById(R.id.result_tv_one);
        return view;
    }

    public void setGreetingMessage(String message){
        resultTVOne.setText(message);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.hi_from_one:
                callback.sayHiToTwo("Hi from Fragment One!");
                break;
            case R.id.bye_from_one:
                callback.sayByeToTwo("Bye From Fragment One!");
        }
    }

}
