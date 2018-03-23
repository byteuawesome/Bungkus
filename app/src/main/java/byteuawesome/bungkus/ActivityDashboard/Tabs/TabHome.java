package byteuawesome.bungkus.ActivityDashboard.Tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import byteuawesome.bungkus.SectionBills.SectionBills;
import byteuawesome.bungkus.SectionFood.SectionFoodMaster;
import byteuawesome.bungkus.SectionTransport.SectionTransport;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/2/2018.
 */

public class TabHome extends android.support.v4.app.Fragment implements View.OnClickListener {

    View rootView;

    TextView tvBillsSection;

    ImageView ivTransportSection,tvFoodSection;

    public TabHome() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_dashboard_home, container, false);

        tvFoodSection = rootView.findViewById(R.id.iv_Dashboard_Home_Food);
        ivTransportSection = rootView.findViewById(R.id.iv_Dashboard_Home_Transport);
        tvBillsSection = rootView.findViewById(R.id.tv_Dashboard_Home_Bills);

        tvFoodSection.setOnClickListener(this);
        ivTransportSection.setOnClickListener(this);
        tvBillsSection.setOnClickListener(this);


        return rootView;

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.iv_Dashboard_Home_Food:
                startActivity(new Intent(getContext(), SectionFoodMaster.class));
//                getActivity().finish();

                break;

            case R.id.iv_Dashboard_Home_Transport:
                startActivity(new Intent(getContext(), SectionTransport.class));
//                getActivity().finish();

                break;

            case R.id.tv_Dashboard_Home_Bills:
                startActivity(new Intent(getContext(), SectionBills.class));
//                getActivity().finish();

                break;

        }


    }
}
