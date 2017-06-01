package com.example.android.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.fragments.fragments.FragmentOne;
import com.example.android.fragments.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements FragmentOne.FOneCallback, FragmentTwo.FTwoCallback {

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOne = new FragmentOne();
        fragmentTwo = new FragmentTwo();

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.first_container, fragmentOne);
        transaction.add(R.id.second_container, fragmentTwo);
        transaction.commit();
    }

    @Override
    public void sayHiToTwo(String greeting) {
        fragmentTwo.setGreetingMessage(greeting);
    }

    @Override
    public void sayByeToTwo(String farewell) {
        fragmentTwo.setGreetingMessage(farewell);
    }

    @Override
    public void onMessageReceived(String message) {

    }

    @Override
    public void sayHiToOne(String greeting) {
        fragmentOne.setGreetingMessage(greeting);
    }

    @Override
    public void sayByeToOne(String farewell) {
        fragmentOne.setGreetingMessage(farewell);
    }
}
