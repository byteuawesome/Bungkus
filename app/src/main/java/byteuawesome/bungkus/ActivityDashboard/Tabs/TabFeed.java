package byteuawesome.bungkus.ActivityDashboard.Tabs;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/2/2018.
 */

public class TabFeed extends android.support.v4.app.Fragment{

    View rootView;

    public TabFeed() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_dashboard_feed, container, false);


        return rootView;

    }
}
