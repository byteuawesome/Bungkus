package byteuawesome.bungkus.ActivityDashboard.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import byteuawesome.bungkus.ActivityDashboard.SectionPager;
import byteuawesome.bungkus.ActivityDashboard.Tabs.TabOrderTabs.TabOrderCompleted;
import byteuawesome.bungkus.ActivityDashboard.Tabs.TabOrderTabs.TabOrderProcessing;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/2/2018.
 */

public class TabOrder extends android.support.v4.app.Fragment {

    View rootView;

    SectionPager sectionPager;
    ViewPager viewpager;

    public TabOrder() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_dashboard_order, container, false);
        sectionPager = new SectionPager(getActivity().getSupportFragmentManager());

        viewpager = rootView.findViewById(R.id.viewPager_Order);

        TabLayout tabLayout = rootView.findViewById(R.id.tabsLayout_Order);

        viewpager.setOffscreenPageLimit(2);
        setupViewPager(viewpager);
        tabLayout.setupWithViewPager(viewpager);

        return rootView;

    }

    private void setupViewPager(ViewPager viewPager){
        SectionPager adapter = new SectionPager(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TabOrderProcessing(), "Processing");
        adapter.addFragment(new TabOrderCompleted(), "Completed");
        viewPager.setAdapter(adapter);
    }
}
