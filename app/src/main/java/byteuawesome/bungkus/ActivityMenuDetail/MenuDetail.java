package byteuawesome.bungkus.ActivityMenuDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import byteuawesome.bungkus.ActivityCart.Cart;
import byteuawesome.bungkus.ActivityCart.CartModel;
import byteuawesome.bungkus.ActivityStoreDetail.StoreDetail;
import byteuawesome.bungkus.Constant;
import byteuawesome.bungkus.R;

public class MenuDetail extends AppCompatActivity implements View.OnClickListener {

    Button btnOrder;
    TextView tvCart, tvBack;

    Button btnIncrease, btnDecrease;
    TextView tvQuantity;

    TextView tvMenuNameDown,tvMenuNameUp, tvMenuPrice, tvDescription, tvStoreName, tvStoreImg;

    int Quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        viewInitialization();
        String holderName = getIntent().getStringExtra("MENU_NAME"),
                holderPrice = getIntent().getStringExtra("MENU_PRICE"),
                holderDesc = getIntent().getStringExtra("MENU_DESCRIPTION"),
                holderStore = getIntent().getStringExtra("STORE_NAME");

        tvMenuNameDown.setText(holderName);
        tvMenuNameUp.setText(holderName);
        tvMenuPrice.setText(Constant.formatCurrency(holderPrice));
        tvDescription.setText(holderDesc);
        tvStoreName.setText(holderStore);

        if (Quantity == 0) {
            btnOrder.setEnabled(false);
            btnDecrease.setEnabled(false);
            tvQuantity.setText("-");
        }
        else {
            btnOrder.setEnabled(true);
            btnDecrease.setEnabled(true);
        }
    }

    private void viewInitialization() {

        tvMenuNameDown = (TextView) findViewById(R.id.textView_MenuDetail_MenuNameDown);
        tvMenuNameUp = (TextView) findViewById(R.id.textView_MenuDetail_MenuNameUp);
        tvMenuPrice = (TextView) findViewById(R.id.textView_MenuDetail_MenuPrice);
        tvDescription = (TextView) findViewById(R.id.textView_MenuDetail_MenuDescription);
        tvStoreName = (TextView) findViewById(R.id.textView_MenuDetail_StoreName);

        btnIncrease = (Button) findViewById(R.id.button_MenuDetail_Increase);
        btnIncrease.setOnClickListener(this);
        btnDecrease = (Button) findViewById(R.id.button_MenuDetail_Decrease);
        btnDecrease.setOnClickListener(this);
        tvQuantity = (TextView) findViewById(R.id.textView_MenuDetail_Quantity);

        btnOrder = (Button) findViewById(R.id.button_MenuDetail_Order);
        btnOrder.setOnClickListener(this);

        tvCart = (TextView) findViewById(R.id.textView_MenuDetail_CartIcon);
        tvCart.setOnClickListener(this);
        tvBack = (TextView) findViewById(R.id.textView_MenuDetail_BackIcon);
        tvBack.setOnClickListener(this);

        tvStoreImg = (TextView) findViewById(R.id.textView_MenuDetail_StoreImg);
        tvStoreImg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.button_MenuDetail_Order:
                String holderName = getIntent().getStringExtra("MENU_NAME"),
                        holderPrice = getIntent().getStringExtra("MENU_PRICE"),
                        holderDesc = getIntent().getStringExtra("MENU_DESCRIPTION"),
                        holderStore = getIntent().getStringExtra("STORE_NAME");

                CartModel add = new CartModel(
                        "",
                        ""+holderStore,
                        "",
                        ""+holderName,
                        ""+Quantity,
                        "0",
                        "0",
                        ""+holderPrice
                        );

                Cart.cartModelArrayList.add(add);

                Quantity = 0;
                tvQuantity.setText(String.valueOf(Quantity));
                if (Quantity == 0) btnOrder.setEnabled(false);

                startActivity(new Intent(getApplicationContext(), Cart.class)
                        .putExtra("MENU_NAME", holderName)
                        .putExtra("MENU_PRICE", holderPrice)
                        .putExtra("MENU_DESCRIPTION", holderDesc)
                        .putExtra("STORE_NAME", holderStore));

                break;

            case R.id.button_MenuDetail_Increase:
                calculateQuantity(1);
                if (Quantity == 0) {
                    tvQuantity.setText("-");
                    btnOrder.setEnabled(false);
                    btnDecrease.setEnabled(false);
                }
                else {
                    btnOrder.setEnabled(true);
                    btnDecrease.setEnabled(true);
                }
                break;

            case R.id.button_MenuDetail_Decrease:
                calculateQuantity(2);
                if (Quantity == 0) {
                    tvQuantity.setText("-");
                    btnOrder.setEnabled(false);
                    btnDecrease.setEnabled(false);
                }
                else {
                    btnOrder.setEnabled(true);
                    btnDecrease.setEnabled(true);
                }
                break;

            case R.id.textView_MenuDetail_CartIcon:
                Quantity = 0;
                String holder = "x"+String.valueOf(Quantity);
                tvQuantity.setText(holder);
                if (Quantity == 0) btnOrder.setEnabled(false);
                startActivity(new Intent(getApplicationContext(), Cart.class));
                break;
            case R.id.textView_MenuDetail_BackIcon:
                finish();
                break;
            case R.id.textView_MenuDetail_StoreImg:
                startActivity(new Intent(getApplicationContext(), StoreDetail.class));
                finish();
                break;
        }

    }

    private void calculateQuantity(int increase_1_decrease_2) {

        if (Quantity < 0) {
            Quantity = 0;
        }

        if (increase_1_decrease_2 == 1) {
            Quantity++;
        } else if (increase_1_decrease_2 == 2) {
            //remove
            Quantity--;
        }

        if (Quantity < 0) {
            Quantity = 0;
        }
        String holder = "x"+String.valueOf(Quantity);
        tvQuantity.setText(holder);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (Quantity == 0) {
            btnOrder.setEnabled(false);
            btnDecrease.setEnabled(false);
            tvQuantity.setText("-");
        }
        else {
            btnOrder.setEnabled(true);
            btnDecrease.setEnabled(true);
        }
    }
}

