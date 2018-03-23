package byteuawesome.bungkus.SectionFood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import byteuawesome.bungkus.Constant;
import byteuawesome.bungkus.R;
import byteuawesome.bungkus.RequestHandler;

/**
 * Created by Laptop on 2/3/2018.
 */

public class SectionFoodClicked extends android.support.v4.app.Fragment {

    View rootView;

    RecyclerView recyclerView;
    RecyclerAdapterSectionFood adapterSectionFood;

    ArrayList<SectionFoodModel> items = new ArrayList<>();

    ProgressDialog progressDialog;
    TextView tvDataNotFound, tvSortName, tvSortPrice, tvSortRating;

    String search_Holder;

    Integer clickName = 0, clickPrice = 0, clickRating = 0;

    public SectionFoodClicked() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_section_food_clicked_search, container, false);
        search_Holder = getArguments().getString("query");

        tvDataNotFound = rootView.findViewById(R.id.textView_SectionFood_Clicked_DataNotFound);
        tvDataNotFound.setVisibility(View.INVISIBLE);

        setTextViewSort();


//        progressDialog = new ProgressDialog(rootView.getContext());
//        progressDialog.setMessage("Searching data");
//        progressDialog.show();

        recyclerView = rootView.findViewById(R.id.recyclerView_SectionFood);
        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(), 2));
        fetchArrayListDummy();
        adapterSectionFood = new RecyclerAdapterSectionFood(rootView.getContext(), items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterSectionFood);

        return rootView;
    }

    private void setTextViewSort() {
        final int colorDefault = getResources().getColor(R.color.grey_800);
        final int colorAccent = getResources().getColor(R.color.colorAccent);

        tvSortName = rootView.findViewById(R.id.textView_SectionFood_Clicked_SortByName);
        tvSortPrice = rootView.findViewById(R.id.textView_SectionFood_Clicked_SortByPrice);
        tvSortRating = rootView.findViewById(R.id.textView_SectionFood_Clicked_SortByRating);
        tvSortName.setTextColor(colorDefault);
        tvSortPrice.setTextColor(colorDefault);
        tvSortRating.setTextColor(colorDefault);


        tvSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "Sort by Name", Toast.LENGTH_SHORT).show();
                tvSortName.setTextColor(colorAccent);
                tvSortPrice.setTextColor(colorDefault);
                tvSortRating.setTextColor(colorDefault);

                clickName++;
                switch (clickName) {
                    case 1:
                        Collections.sort(items, SectionFoodModel.SORT_BY_NAME);
                        break;
                    case 2:
                        Collections.reverse(items);
                        clickName = 0;
                        break;
                }

                adapterSectionFood.notifyDataSetChanged();

            }
        });
        tvSortPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "Sort by Price", Toast.LENGTH_SHORT).show();
                tvSortName.setTextColor(colorDefault);
                tvSortPrice.setTextColor(colorAccent);
                tvSortRating.setTextColor(colorDefault);

                clickPrice++;
                switch (clickPrice) {
                    case 1:
                        Collections.sort(items, SectionFoodModel.SORT_BY_PRICE);
                        break;
                    case 2:
                        Collections.reverse(items);
                        clickPrice = 0;
                        break;
                }
                adapterSectionFood.notifyDataSetChanged();
            }
        });
        tvSortRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(rootView.getContext(), "Sort by Rating", Toast.LENGTH_SHORT).show();
                tvSortName.setTextColor(colorDefault);
                tvSortPrice.setTextColor(colorDefault);
                tvSortRating.setTextColor(colorAccent);
//                TODO tamba sort rating
            }
        });
    }

    private ArrayList<SectionFoodModel> fetchArrayListDummy() {


        SectionFoodModel item1 = new SectionFoodModel(
                "Ikan Bakar Rumah",
                "200000",
                "bisa membakar rumah anda",
                "processed Food",
                "Blessing");
        items.add(item1);

        SectionFoodModel item2 = new SectionFoodModel(
                "Babi Garo Panta",
                "400000",
                "membuat Panta anda gatalll",
                "processed Food",
                "Bapontar");
        items.add(item2);

        SectionFoodModel item3 = new SectionFoodModel(
                "panta Garo babi",
                "400000",
                "jenis babi gilaaaaa",
                "processed Food",
                "Bapontar");
        items.add(item3);

        SectionFoodModel item4 = new SectionFoodModel(
                "Ayam Kile-kile",
                "700000",
                "bagian ayam yang terlezat (blackie)",
                "processed Food",
                "Bapontar");
        items.add(item4);

        SectionFoodModel store1 = new SectionFoodModel(
                "Ayam Kile-kile",
                "700000",
                "bagian ayam yang terlezat (blackie)",
                "processed Food",
                "Bapontar");
        store1.setStoreState(true);
        items.add(store1);

        SectionFoodModel store2 = new SectionFoodModel(
                "Ayam Kile-kile",
                "700000",
                "bagian ayam yang terlezat (blackie)",
                "processed Food",
                "Ribebss");
        store2.setStoreState(true);
        items.add(store2);


        return items;
    }

    private ArrayList<SectionFoodModel> fetchArrayList() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Constant.URL_SEARCH_PRODUCT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject obj = new JSONObject(response);

                    if (!obj.getBoolean("error")) {

                        int counter = 1;
                        for (int i = 0; i < obj.length() - 2; i++) {
                            JSONObject product = obj.getJSONObject("product-" + counter);

                            SectionFoodModel sectionFoodModel = new SectionFoodModel(
                                    product.getString("name"),
                                    product.getString("price"),
                                    product.getString("description"),
                                    product.getString("process-type"),
                                    product.getString("store")
                            );

                            items.add(sectionFoodModel);
                            counter++;
                        }
                    } else {
                        Toast.makeText(rootView.getContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                        tvDataNotFound.setVisibility(View.VISIBLE);
                    }

                    adapterSectionFood.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(rootView.getContext(), "OnException " + e.getMessage(), Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(rootView.getContext(), "OnError " + error.getMessage() + error.getNetworkTimeMs(), Toast.LENGTH_SHORT).show();

            }
        }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("search_string", search_Holder);
                return params;
            }
        };

        RequestHandler.getInstance(rootView.getContext()).addToRequestQueue(stringRequest);
        return items;
    }
}
