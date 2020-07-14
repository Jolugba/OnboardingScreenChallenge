package com.tinuade.onboardingscreenchallenge.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.tinuade.onboardingscreenchallenge.R;
import com.tinuade.onboardingscreenchallenge.model.OnboardingListItems;

import java.util.List;

public class OnboardingItemAdapter extends PagerAdapter {
    Context context;
    List<OnboardingListItems> itemsList;

    public OnboardingItemAdapter(Context context, List<OnboardingListItems> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen = inflater.inflate(R.layout.layout_screen, null);

        TextView title = layoutScreen.findViewById(R.id.onboardingTitle);
        TextView description = layoutScreen.findViewById(R.id.onboardingDescription);
        ImageView image = layoutScreen.findViewById(R.id.onBoardingImage);

        title.setText(itemsList.get(position).getTitle());
        description.setText(itemsList.get(position).getDescription());
        image.setImageResource(itemsList.get(position).getImage());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
