package com.nadawoo.nadazonepluspandamobile.invazionprototype.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nadawoo.nadazonepluspandamobile.invazionprototype.R;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.Pantheon;
import com.nadawoo.nadazonepluspandamobile.invazionprototype.models.PantheonData;

import java.util.List;

public class PantheonAdapter extends RecyclerView.Adapter<PantheonAdapter.MyViewHolderMP> {

    private Context mContext;
    private List<PantheonData> mData;

    public PantheonAdapter(Context mContext, List<PantheonData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderMP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        //We use this layout to display items inside
        v = LayoutInflater.from(mContext).inflate(R.layout.item_list_pantheon, parent, false);
        return new MyViewHolderMP(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderMP holder, int position) {
        holder.nameCitizen.setText(mData.get(position).getCitizenPseudo());
        holder.idCitizen.setText("ID : " + mData.get(position).getCitizenId());
        holder.lastDeathCitizen.setText("Last death : " + mData.get(position).getLastDeath());
        holder.survivalTime.setText("Days survived : " + mData.get(position).getSurvivalTime());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolderMP extends RecyclerView.ViewHolder {
        // declaration of UI Elements
        TextView nameCitizen;
        TextView idCitizen;
        TextView lastDeathCitizen;
        TextView survivalTime;


        MyViewHolderMP(@NonNull View itemView) {
            super(itemView);
            // we assign a view to each UI Element
            nameCitizen = itemView.findViewById(R.id.pantheon_item_name);
            idCitizen = itemView.findViewById(R.id.pantheon_item_id);
            lastDeathCitizen = itemView.findViewById(R.id.pantheon_item_last_death);
            survivalTime = itemView.findViewById(R.id.pantheon_item_survival_time);
        }
    }
}
