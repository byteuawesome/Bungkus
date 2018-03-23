package byteuawesome.bungkus.SectionFood;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import byteuawesome.bungkus.ActivityMenuDetail.MenuDetail;
import byteuawesome.bungkus.Constant;
import byteuawesome.bungkus.R;

/**
 * Created by Laptop on 2/16/2018.
 */

public class RecyclerAdapterSectionFood extends RecyclerView.Adapter<RecyclerAdapterSectionFood.MyViewHolder> {

    private Context context;
    private ArrayList<SectionFoodModel> items;

    RecyclerAdapterSectionFood(Context context, ArrayList<SectionFoodModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_section_food_menu, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final int pos = position;
        if (!items.get(position).getStoreState()) {
            holder.tvMenuName.setText(items.get(position).getMenuName());
            holder.tvMenuPrice.setText(Constant.formatCurrency(items.get(position).getMenuPrice()));
            holder.tvStore.setText(items.get(position).getStoreName());
        } else {
            holder.tvMenuName.setText(items.get(position).getStoreName());
            holder.tvMenuName.setGravity(Gravity.CENTER);
            holder.tvMenuName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            holder.tvMenuPrice.setText("");

            holder.tvStore.setText(items.get(position).getStoreName());
            holder.tvStore.setGravity(Gravity.CENTER);
            holder.tvStore.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MenuDetail.class)
                        .putExtra("MENU_NAME",items.get(pos).getMenuName())
                        .putExtra("MENU_PRICE",items.get(pos).getMenuPrice())
                        .putExtra("MENU_DESCRIPTION",items.get(pos).getMenuDescription())
                        .putExtra("STORE_NAME",items.get(pos).getStoreName())
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvMenuName, tvMenuPrice, tvStore;
        CardView cardView;

        MyViewHolder(View itemView) {
            super(itemView);
            tvMenuName = itemView.findViewById(R.id.recyclerItem_SectionFood_Menu_textView_MenuName);
            tvStore = itemView.findViewById(R.id.recyclerItem_SectionFood_Menu_textView_Store);
            tvMenuPrice = itemView.findViewById(R.id.recyclerItem_SectionFood_Menu_textView_MenuPrice);

            cardView = itemView.findViewById(R.id.recyclerItem_SectionFood_Menu_CardView);
        }
    }

}

