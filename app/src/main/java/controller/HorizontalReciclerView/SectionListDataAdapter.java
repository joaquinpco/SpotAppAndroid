package controller.HorizontalReciclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import akeen.app.SpotApp.R;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleItemModel> itemsList;
    private Context context;

    public SectionListDataAdapter(Context context, ArrayList<SingleItemModel> itemsList) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.list_single_card, null);
        SingleItemRowHolder singleItemRowHolder = new SingleItemRowHolder(view);
        return singleItemRowHolder;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {
        SingleItemModel singleItem = itemsList.get(i);
        holder.itemName.setText(singleItem.getName());
    }

    @Override
    public int getItemCount() {
        return null != itemsList ? itemsList.size() : 0;
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView itemName;
        protected ImageView itemImage;

        public SingleItemRowHolder(View view) {
            super(view);
            this.itemName = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), itemName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}