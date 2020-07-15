package com.tinuade.onboardingscreenchallenge.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.tinuade.onboardingscreenchallenge.R;
import com.tinuade.onboardingscreenchallenge.adapter.OnboardingPagerAdapter;
import com.tinuade.onboardingscreenchallenge.databinding.OnboardingScreenBinding;
import com.tinuade.onboardingscreenchallenge.model.OnboardingListItems;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {
   // declaration of global variables
    OnboardingScreenBinding binding;
    MaterialButton nextButton;
    MaterialButton arrowButton;
    private Animation buttonAnimation;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //show full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        binding = DataBindingUtil.setContentView(this, R.layout.onboarding_screen);

        // initialize views
        arrowButton = findViewById(R.id.arrowButton);
        nextButton = findViewById(R.id.buttonNext);
        buttonAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.onboarding_button_animation);
        // add item to the list
        final List<OnboardingListItems> list = new ArrayList<>();
        list.add(new OnboardingListItems(getString(R.string.keep_calm), getString(R.string.first_screen_text), R.drawable.clock));
        list.add(new OnboardingListItems(getString(R.string.mindfulness), getString(R.string.second_screen_text), R.drawable.yoga));
        list.add(new OnboardingListItems(getString(R.string.stay_focus), getString(R.string.three_screen_text), R.drawable.waiting));

        //Set up view pager
        OnboardingPagerAdapter adapter = new OnboardingPagerAdapter(this, list);
        binding.viewPager.setAdapter(adapter);

        //Set up tabLayout with viewPager
        binding.tabIndicators.setupWithViewPager(binding.viewPager);

        //set the next onClickListener

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = binding.viewPager.getCurrentItem();
                if (position < list.size()) {
                    position++;
                    binding.viewPager.setCurrentItem(position);
                }
                if (position == list.size() - 1) {
                    loadScreen();
                } else {
                    preLoadScreen();
                }
            }
        });

        //set the skip button onClickListener
        binding.skipText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(OnBoardingActivity.this, R.string.skip_toast_message,Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //tabLayout change listener
        binding.tabIndicators.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == list.size() - 1) {
                    loadScreen();
                } else {
                    preLoadScreen();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() == list.size() - 1) {
                    loadScreen();
                } else {
                    preLoadScreen();
                }


            }
        });


    }

    private void loadScreen() {
        nextButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.appPurple));
        nextButton.setText(R.string.get_started_button);
        nextButton.setTextSize(10);
        nextButton.setRippleColorResource(R.color.appWhite);
        nextButton.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        nextButton.setTextColor(getResources().getColor(R.color.appWhite));
        binding.skipText.setVisibility(View.INVISIBLE);
        arrowButton.setVisibility(View.INVISIBLE);
        binding.view.setVisibility(View.INVISIBLE);
        binding.tabIndicators.setVisibility(View.INVISIBLE);
        nextButton.setAnimation(buttonAnimation);
    }

    private void preLoadScreen() {
        nextButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.appWhite));
        nextButton.setText(R.string.next);
        nextButton.setRippleColorResource(R.color.appPurple);
        nextButton.setTextColor(getResources().getColor(R.color.nextText));
        arrowButton.setVisibility(View.VISIBLE);
        binding.view.setVisibility(View.VISIBLE);
        binding.tabIndicators.setVisibility(View.VISIBLE);
        binding.skipText.setVisibility(View.VISIBLE);
        nextButton.setTextSize(14);
        nextButton.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);

    }

}