package byteuawesome.bungkus.SectionFood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import byteuawesome.bungkus.ActivityCart.Cart;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/3/2018.
 */

public class SectionFoodMaster extends AppCompatActivity {

    SearchView searchView;
    int count = 0;

    TextView tvCart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_section_food_master_fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_Section_Food, new SectionFoodUnClicked()).commit();

        setUpSearchView();


        tvCart = (TextView) findViewById(R.id.textView_SectionFood_Cart);
        tvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Cart.class));
            }
        });
    }

    private void setUpSearchView() {
        searchView = (SearchView) findViewById(R.id.searchView_Food);
        final ImageView closeButton = searchView.findViewById(R.id.search_close_btn);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                if (query.length() > 2) {
                    Bundle bundle = new Bundle();
                    bundle.putString("query", query);
                    SectionFoodClicked sectionFoodClicked = new SectionFoodClicked();
                    sectionFoodClicked.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_Section_Food, sectionFoodClicked).commit();

                    searchView.clearFocus();
                    count++;
                } else {
                    Toast.makeText(SectionFoodMaster.this, "Submit more than 2 char", Toast.LENGTH_SHORT).show();
                }

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                closeButton.setVisibility(View.VISIBLE);
                return false;
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchView.setQuery("", false);
                getSupportFragmentManager().beginTransaction().replace(R.id.content_Section_Food, new SectionFoodUnClicked()).commit();
                closeButton.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        count--;
        searchView.clearFocus();
        super.onBackPressed();
//        if (count <= 0) {
//            super.onBackPressed();
//            finish();
//        } else {
//            getSupportFragmentManager().beginTransaction().replace(R.id.content_Section_Food, new SectionFoodUnClicked()).commit();
//            count = 0;
//        }
    }
}
