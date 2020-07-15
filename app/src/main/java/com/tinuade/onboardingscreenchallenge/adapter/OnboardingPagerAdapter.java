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

public class OnboardingPagerAdapter extends PagerAdapter {

    private Context context;
    private List<OnboardingListItems> list;

    public OnboardingPagerAdapter(Context context, List<OnboardingListItems> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View layoutScreen=inflater.inflate(R.layout.layout_screen,null);

        ImageView imgSlide = layoutScreen.findViewById(R.id.onBoardingImage);
        TextView title = layoutScreen.findViewById(R.id.onboardingTitle);
        TextView description = layoutScreen.findViewById(R.id.onboardingDescription);

        title.setText(list.get(position).getTitle());
        description.setText(list.get(position).getDescription());
        imgSlide.setImageResource(list.get(position).getImage());

        container.addView(layoutScreen);

        return layoutScreen;

    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
