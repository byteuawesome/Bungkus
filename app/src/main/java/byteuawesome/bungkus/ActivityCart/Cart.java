package byteuawesome.bungkus.ActivityCart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import byteuawesome.bungkus.ActivityDashboard.Dashboard;
import byteuawesome.bungkus.ActivityTopUp.TopUp;
import byteuawesome.bungkus.Constant;
import byteuawesome.bungkus.R;

public class Cart extends AppCompatActivity implements View.OnClickListener {

    Button btnBungkus;
    TextView tvCart, tvAccountBal, tvTotalOrderPrice, tvAfterBal, tvTopUp;

    RecyclerView recyclerView;
    RecyclerAdapterCart adapter;

    String balance = "9000000";

    public static ArrayList<CartModel> cartModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        tvAccountBal = (TextView) findViewById(R.id.textView_Cart_AccountBalance);
        tvTotalOrderPrice = (TextView) findViewById(R.id.textView_Cart_TotalOrderPrice);
        tvAfterBal = (TextView) findViewById(R.id.textView_Cart_AfterBalance);

        tvTopUp = (TextView) findViewById(R.id.textView_Cart_TopUp);
        tvTopUp.setOnClickListener(this);
        btnBungkus = (Button) findViewById(R.id.button_Cart_Bungkus);
        btnBungkus.setOnClickListener(this);
        tvCart = (TextView) findViewById(R.id.textView_Cart_BackIcon);
        tvCart.setOnClickListener(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_Cart);

        adapter = new RecyclerAdapterCart(getApplicationContext(), fetchRecyclerView());
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        registerBroadcastReceiver();

        calculateTotalPriceAfterBalance();

        tvAccountBal.setText(Constant.formatCurrency(balance));

    }

    private void registerBroadcastReceiver() {

        BroadcastReceiver broadcastReceiverUpdateUI = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (Objects.equals(action, "update_ui")) {
                    calculateTotalPriceAfterBalance();

                }
            }
        };
        registerReceiver(broadcastReceiverUpdateUI, new IntentFilter("update_ui"));

        BroadcastReceiver broadcastReceiverUpdateRecycler = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (Objects.equals(action, "update_recycler")) {
                    adapter.notifyDataSetChanged();
                }
            }
        };
        registerReceiver(broadcastReceiverUpdateRecycler, new IntentFilter("update_recycler"));

    }

    private void calculateTotalPriceAfterBalance() {
        int holder,holder2 = 0;


        for (int i = 0; i < cartModelArrayList.size(); i++) {
            holder = Integer.parseInt(cartModelArrayList.get(i).getSubTotalPrice());
            holder2 = holder2 + holder;

        }

        tvTotalOrderPrice.setText(Constant.formatCurrency(holder2));

        int bal = Integer.parseInt(balance) - holder2;
        if (bal < 0 ){
            tvAfterBal.setTextColor(Color.RED);
            btnBungkus.setEnabled(false);
        } else if (bal == 0){
            tvAfterBal.setTextColor(Color.GRAY);
            tvAfterBal.setText("-");
        } else {
            btnBungkus.setEnabled(true);
            tvAfterBal.setTextColor(Color.GRAY);
        }

        tvAfterBal.setText(Constant.formatCurrency(bal));
    }

    private ArrayList<CartModel> fetchRecyclerView() {

        for (int i = 0; i < cartModelArrayList.size(); i++) {
            Integer productPrice = Integer.parseInt(cartModelArrayList.get(i).getProductPrice());
            Integer transportPrice = Integer.parseInt(cartModelArrayList.get(i).getTransportPrice());
            Integer quantity = Integer.parseInt(cartModelArrayList.get(i).getProductQuantity());

            cartModelArrayList.get(i).setSubTotalPrice(String.valueOf((productPrice * quantity) + transportPrice));
        }

        return cartModelArrayList;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.button_Cart_Bungkus:
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                finish();
                break;
            case R.id.textView_Cart_BackIcon:
                finish();
                break;
            case R.id.textView_Cart_TopUp:
                startActivity(new Intent(getApplicationContext(), TopUp.class));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }


}
