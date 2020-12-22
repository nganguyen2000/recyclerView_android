package org.o7planning.total;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.FoodViewHolder> {

    private List<Clothes> mClothes;

    public ClothesAdapter(List<Clothes> mClothes) {
        this.mClothes = mClothes;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_clothes,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Clothes clothes = mClothes.get(position);
        if(clothes ==null){
            return;
        }
        holder.imgclothes.setImageResource(clothes.getImage());
        holder.nameclothes.setText(clothes.getName());
        holder.descclothes.setText(clothes.getDescription());

    }

    @Override
    public int getItemCount() {
        if(mClothes != null){
            return mClothes.size();
        }
        return 0;
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgclothes;
        private TextView nameclothes;
        private TextView descclothes;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgclothes = itemView.findViewById(R.id.img_clothes);
            nameclothes =itemView.findViewById(R.id.name_clothes);
            descclothes = itemView.findViewById(R.id.desc_clothes);
        }
    }
}


