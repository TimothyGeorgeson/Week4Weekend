package com.example.consultants.week4weekend.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.week4weekend.R;
import com.example.consultants.week4weekend.model.local.MyForecast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<MyForecast> forecastList;

    public RecyclerViewAdapter(List<MyForecast> forecastList) {
        this.forecastList = forecastList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,
                viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MyForecast myForecast = forecastList.get(i);

        viewHolder.tvDay.setText(myForecast.getDay());

        viewHolder.tvTenTime.setText("10:00 AM");
        viewHolder.tvTenCond.setText(myForecast.getTenCond());
        viewHolder.tvTenTemp.setText(myForecast.getTenTemp());

        viewHolder.tvOneTime.setText("1:00 PM");
        viewHolder.tvOneCond.setText(myForecast.getOneCond());
        viewHolder.tvOneTemp.setText(myForecast.getOneTemp());

        viewHolder.tvFourTime.setText("4:00 PM");
        viewHolder.tvFourCond.setText(myForecast.getFourCond());
        viewHolder.tvFourTemp.setText(myForecast.getFourTemp());

        viewHolder.tvSevenTime.setText("7:00 PM");
        viewHolder.tvSevenCond.setText(myForecast.getSevenCond());
        viewHolder.tvSevenTemp.setText(myForecast.getSevenTemp());

    }

    @Override
    public int getItemCount() {
        return forecastList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvDay;
        private TextView tvTenTime, tvOneTime, tvFourTime, tvSevenTime;
        private TextView tvTenCond, tvOneCond, tvFourCond, tvSevenCond;
        private TextView tvTenTemp, tvOneTemp, tvFourTemp, tvSevenTemp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //bind textviews
            tvDay = itemView.findViewById(R.id.tvDay);
            tvTenTime = itemView.findViewById(R.id.tvTenTime);
            tvOneTime = itemView.findViewById(R.id.tvOneTime);
            tvFourTime = itemView.findViewById(R.id.tvFourTime);
            tvSevenTime = itemView.findViewById(R.id.tvSevenTime);
            tvTenCond = itemView.findViewById(R.id.tvTenCond);
            tvOneCond = itemView.findViewById(R.id.tvOneCond);
            tvFourCond = itemView.findViewById(R.id.tvFourCond);
            tvSevenCond = itemView.findViewById(R.id.tvSevenCond);
            tvTenTemp = itemView.findViewById(R.id.tvTenTemp);
            tvOneTemp = itemView.findViewById(R.id.tvOneTemp);
            tvFourTemp = itemView.findViewById(R.id.tvFourTemp);
            tvSevenTemp = itemView.findViewById(R.id.tvSevenTemp);
        }
    }
}
