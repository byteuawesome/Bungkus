package byteuawesome.bungkus.SectionFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import byteuawesome.bungkus.ActivityStoreDetail.StoreDetail;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/3/2018.
 */

public class SectionFoodUnClicked extends Fragment {

    View rootView;
    TextView tvProcessedFood;

    public SectionFoodUnClicked() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_section_food_unclicked, container, false);

        tvProcessedFood = rootView.findViewById(R.id.tv_SectionFood_Unclicked_ProcessFood);
        tvProcessedFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), StoreDetail.class));
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
