package com.tinuade.onboardingscreenchallenge.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager2.widget.ViewPager2;

import com.tinuade.onboardingscreenchallenge.R;
import com.tinuade.onboardingscreenchallenge.adapter.OnboardingItemAdapter;
import com.tinuade.onboardingscreenchallenge.databinding.OnboardingScreenBinding;
import com.tinuade.onboardingscreenchallenge.model.OnboardingListItems;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
    OnboardingItemAdapter onboardingItemAdapter;
    OnboardingScreenBinding binding;
    ViewPager2 viewPager2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.onboarding_screen);

        List<OnboardingListItems> listItems = new ArrayList<>();
        listItems.add(new OnboardingListItems(getString(R.string.keep_calm), getString(R.string.first_screen_text), R.drawable.clock));
        listItems.add(new OnboardingListItems(getString(R.string.mindfulness), getString(R.string.second_screen_text), R.drawable.yoga));
        listItems.add(new OnboardingListItems(getString(R.string.stay_focus), getString(R.string.three_screen_text), R.drawable.waiting));

        onboardingItemAdapter = new OnboardingItemAdapter(this, listItems);
        viewPager2=findViewById(R.id.view_pager);
        viewPager2.setAdapter(onboardingItemAdapter);


    }
}