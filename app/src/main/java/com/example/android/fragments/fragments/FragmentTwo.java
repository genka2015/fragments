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
public class FragmentTwo extends Fragment implements View.OnClickListener{

    private FTwoCallback callback;
    Button sayHiToOne;
    Button sayByeToOne;
    TextView resultTVTwo;

    public FragmentTwo() {
        // Required empty public constructor
    }

    public interface FTwoCallback{
        void sayHiToOne(String greeting);
        void sayByeToOne(String farewell);
        void onMessageReceived(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (FTwoCallback) getActivity();

        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString() + " must implement FTwoCallback");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_two, container, false);
        sayHiToOne = (Button) view.findViewById(R.id.hi_from_two);
        sayByeToOne = (Button) view.findViewById(R.id.bye_from_two);
        sayHiToOne.setOnClickListener(this);
        sayByeToOne.setOnClickListener(this);
        resultTVTwo = (TextView) view.findViewById(R.id.result_tv_two);
        return view;
    }


    public void setGreetingMessage(String message){
        resultTVTwo.setText(message);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.hi_from_two:
                callback.sayHiToOne("Hi from Fragment Two!");
                break;
            case R.id.bye_from_two:
                callback.sayByeToOne("Bye From Fragment Two!");
        }
    }
}
