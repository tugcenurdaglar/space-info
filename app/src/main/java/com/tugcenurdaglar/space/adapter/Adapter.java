package com.tugcenurdaglar.space.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tugcenurdaglar.space.R;
import com.tugcenurdaglar.space.pojomodels.Repo;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.LayoutNesneler> {
    private Context mContext;
    private List<Repo> repoList;

    public Adapter(Context mContext, List<Repo> repoList) {
        this.mContext = mContext;
        this.repoList = repoList;
    }

    @NonNull
    @Override
    public LayoutNesneler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,
                parent,false);
        return new LayoutNesneler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LayoutNesneler holder, int position) {
        Repo repo = repoList.get(position);

        holder.flightNumber.setText(String.valueOf(repo.flightNumber));
        holder.launchYear.setText(repo.launchYear);
        holder.rocketId.setText(repo.rocket.rocketId);
        holder.rocketName.setText(repo.rocket.rocketName);
        holder.rocketType.setText(repo.rocket.rocketType);

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    public class LayoutNesneler extends RecyclerView.ViewHolder{

        public TextView flightNumber;
        public TextView launchYear;
        public TextView rocketId;
        public TextView rocketName;
        public TextView rocketType;

        public LayoutNesneler(@NonNull View itemView) {
            super(itemView);

            flightNumber = itemView.findViewById(R.id.flightNumber);
            launchYear = itemView.findViewById(R.id.launchYear);
            rocketId = itemView.findViewById(R.id.rocketId);
            rocketName = itemView.findViewById(R.id.rocketName);
            rocketType = itemView.findViewById(R.id.rocketType);

        }
    }
}
