package byteuawesome.bungkus.ActivityCart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import byteuawesome.bungkus.Constant;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/18/2018.
 */

public class RecyclerAdapterCart extends RecyclerView.Adapter<RecyclerAdapterCart.MyViewHolder>  /*implements View.OnClickListener*/ {

    private Context context;
    private ArrayList<CartModel> items;

    private Integer Quantity;

    public RecyclerAdapterCart(Context context, ArrayList<CartModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_cart, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.tvStoreName.setText(items.get(position).getStoreName());
        holder.tvProductName.setText(items.get(position).getProductName());
        holder.tvProductPrice.setText(Constant.formatCurrency(items.get(position).getProductPrice()));
        final String x = "x";
        holder.tvQuantity.setText(x.concat(items.get(position).getProductQuantity()));
        holder.tvSubTotalPrice.setText(Constant.formatCurrency(items.get(position).getSubTotalPrice()));
        holder.tvTransportPrice.setText(Constant.formatCurrency(items.get(position).getTransportPrice()));

        holder.tvX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "item deleted!", Toast.LENGTH_SHORT).show();
                items.remove(holder.getAdapterPosition());
                context.sendBroadcast(new Intent("update_recycler"));
                context.sendBroadcast(new Intent("update_ui"));
            }
        });

        holder.btnInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(items.get(holder.getAdapterPosition()).getProductQuantity());
                quantity = quantity + 1;
                Integer productPrice = Integer.parseInt(items.get(holder.getAdapterPosition()).getProductPrice());
                holder.tvSubTotalPrice.setText(Constant.formatCurrency(productPrice*quantity));
                items.get(holder.getAdapterPosition()).setSubTotalPrice(String.valueOf(productPrice*quantity));
                holder.tvQuantity.setText(x.concat(String.valueOf(quantity)));
                items.get(holder.getAdapterPosition()).setProductQuantity(String.valueOf(quantity));
                context.sendBroadcast(new Intent("update_ui"));

                if (!holder.btnDec.isEnabled()) holder.btnDec.setEnabled(true);

            }
        });
        holder.btnDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer quantity = Integer.parseInt(items.get(holder.getAdapterPosition()).getProductQuantity());
                quantity = quantity - 1;

                if (quantity == 0) holder.btnDec.setEnabled(false);

                Integer productPrice = Integer.parseInt(items.get(holder.getAdapterPosition()).getProductPrice());
                holder.tvSubTotalPrice.setText(Constant.formatCurrency(productPrice*quantity));
                items.get(holder.getAdapterPosition()).setSubTotalPrice(String.valueOf(productPrice*quantity));
                holder.tvQuantity.setText(x.concat(String.valueOf(quantity)));
                items.get(holder.getAdapterPosition()).setProductQuantity(String.valueOf(quantity));
                context.sendBroadcast(new Intent("update_ui"));

            }
        });

    }

    private int calculateQuantity(int increase_1_decrease_2) {

        if (Quantity <= 0) {
            Quantity = 0;
        }

        if (increase_1_decrease_2 == 1) {
            Quantity++;
        } else if (increase_1_decrease_2 == 2) {
            //remove
            Quantity--;
        }

        if (Quantity <= 0) {
            Quantity = 0;
        }

        return Quantity;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

//    @Override
//    public void onClick(View view) {
//        int id = view.getId();
//        switch (id){
//            case R.id.recyclerItem_Cart_Delete:
//
//                break;
//            case R.id.recyclerItem_Cart_Button_Increase:
//                break;
//            case R.id.recyclerItem_Cart_Button_Decrease:
//                break;
//
//        }
//
//    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvStoreName, tvProductName, tvQuantity, tvTransportPrice, tvSubTotalPrice, tvProductPrice, tvX;

        Button btnInc, btnDec;

        MyViewHolder(View itemView) {
            super(itemView);

            tvStoreName = itemView.findViewById(R.id.recyclerItem_Cart_StoreName);
            tvProductName = itemView.findViewById(R.id.recyclerItem_Cart_ProductName);
            tvQuantity = itemView.findViewById(R.id.recyclerItem_Cart_Quantity);
            tvTransportPrice = itemView.findViewById(R.id.recyclerItem_Cart_TransportPrice);
            tvSubTotalPrice = itemView.findViewById(R.id.recyclerItem_Cart_SubTotalPrice);
            tvProductPrice = itemView.findViewById(R.id.recyclerItem_Cart_ProductPrice);
            tvX = itemView.findViewById(R.id.recyclerItem_Cart_Delete);

            btnInc = itemView.findViewById(R.id.recyclerItem_Cart_Button_Increase);
            btnDec = itemView.findViewById(R.id.recyclerItem_Cart_Button_Decrease);

        }
    }
}
