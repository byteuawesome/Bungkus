package byteuawesome.bungkus.ActivityDashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import byteuawesome.bungkus.ActivityDashboard.Tabs.TabFeed;
import byteuawesome.bungkus.ActivityDashboard.Tabs.TabHelp;
import byteuawesome.bungkus.ActivityDashboard.Tabs.TabHome;
import byteuawesome.bungkus.ActivityDashboard.Tabs.TabOrder;
import byteuawesome.bungkus.ActivityTopUp.TopUp;
import byteuawesome.bungkus.R;


public class DashboardTabsMaster extends Fragment implements View.OnClickListener {

    SectionPager sectionPager;

    ViewPager viewpager;

    Button btnTopUp;
    LinearLayout linearLayoutNameCash;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("BUNGKUS");

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tabs_master_dashboard, viewGroup, false);

        btnTopUp = (Button) rootView.findViewById(R.id.Button_Top_Up);
        btnTopUp.setOnClickListener(this);

        linearLayoutNameCash = (LinearLayout) rootView.findViewById(R.id.LinearLayout_MasterDashboard_NameCash);
        linearLayoutNameCash.setOnClickListener(this);


        sectionPager = new SectionPager(getActivity().getSupportFragmentManager());

        viewpager = rootView.findViewById(R.id.containerMaster);
        viewpager.setOffscreenPageLimit(2);
        setupViewPager(viewpager);

        TabLayout tabLayout = rootView.findViewById(R.id.tabsMaster);
        tabLayout.setupWithViewPager(viewpager);

        return rootView;
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPager adapter = new SectionPager(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TabHome(), "Home");
        adapter.addFragment(new TabFeed(), "Feed");
        adapter.addFragment(new TabOrder(), "Order");
        adapter.addFragment(new TabHelp(), "Help");
        viewPager.setAdapter(adapter);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.Button_Top_Up:
                startActivity(new Intent(getContext(), TopUp.class));
                break;
            case R.id.LinearLayout_MasterDashboard_NameCash:
                startActivity(new Intent(getContext(), TopUp.class));
                break;

        }
    }
}
