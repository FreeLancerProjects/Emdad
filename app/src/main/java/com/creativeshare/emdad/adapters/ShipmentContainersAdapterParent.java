package com.creativeshare.emdad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.activities_fragments.activities.activity_shipment_transportation.fragments.Fragment_Shipment_Container_Type;
import com.creativeshare.emdad.models.ContainersModel;

import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class ShipmentContainersAdapterParent extends RecyclerView.Adapter<ShipmentContainersAdapterParent.MyHolder> {

    private List<ContainersModel> containersModelList;
    private Context context;
    private String current_language;
    private Fragment_Shipment_Container_Type fragment;

    public ShipmentContainersAdapterParent(List<ContainersModel> containersModelList, Context context,Fragment_Shipment_Container_Type fragment) {
        this.containersModelList = containersModelList;
        this.context = context;
        Paper.init(context);
        current_language = Paper.book().read("lang", Locale.getDefault().getLanguage());
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.container_type_parent_row,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ContainersModel containersModel = containersModelList.get(position);
        holder.BindData(containersModel);

    }

    @Override
    public int getItemCount() {
        return containersModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView tv_title;
        private RecyclerView recView;
        private LinearLayoutManager manager;
        private ShipmentContainersAdapterChild adapter;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            recView = itemView.findViewById(R.id.recView);
            manager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            recView.setLayoutManager(manager);
        }

        private void BindData(ContainersModel containersModel)
        {
            if (current_language.equals("ar"))
            {
                tv_title.setText(containersModel.getAr_title_cat());
            }else
                {
                    tv_title.setText(containersModel.getEn_title_cat());

                }

            adapter = new ShipmentContainersAdapterChild(containersModel.getTrans(),context,fragment);
            recView.setAdapter(adapter);

        }
    }
}
