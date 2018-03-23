package byteuawesome.bungkus.ActivityStoreDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import byteuawesome.bungkus.ActivityCart.Cart;
import byteuawesome.bungkus.R;

public class StoreDetail extends AppCompatActivity implements View.OnClickListener {

    TextView tvBackIcon, tvStoreName, tvCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_detail);

        tvBackIcon = (TextView) findViewById(R.id.textView_StoreDetail_BackIcon);
        tvStoreName = (TextView) findViewById(R.id.textView_StoreDetail_MenuNameUp);
        tvCart = (TextView) findViewById(R.id.textView_StoreDetail_CartIcon);

        tvBackIcon.setOnClickListener(this);

        tvCart.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.textView_StoreDetail_BackIcon:
                finish();
                break;
            case R.id.textView_StoreDetail_CartIcon:
                startActivity(new Intent(getApplicationContext(), Cart.class));
                break;

        }

    }
}
