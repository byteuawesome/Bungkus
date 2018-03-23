package byteuawesome.bungkus.ActivityDashboard.NavFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/3/2018.
 */

public class FragmentAbout extends android.support.v4.app.Fragment{

    View rootView;

    public FragmentAbout() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);


        return rootView;

    }
}
