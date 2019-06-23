package com.creativeshare.emdad.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.creativeshare.emdad.R;
import com.creativeshare.emdad.models.ServicesModel;

import java.util.List;
import java.util.Locale;

import io.paperdb.Paper;

public class Spinner_Services_Adapter extends BaseAdapter {
    private List<ServicesModel> servicesModelList;
    private LayoutInflater inflater;
    private String current_language;

    public Spinner_Services_Adapter(Context context, List<ServicesModel> servicesModelList) {
        this.servicesModelList = servicesModelList;
        inflater = LayoutInflater.from(context);
        Paper.init(context);
        current_language = Paper.book().read("lang", Locale.getDefault().getLanguage());
    }

    @Override
    public int getCount() {
        return servicesModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return servicesModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.spinner_row, parent, false);

        }
        TextView tv_name = convertView.findViewById(R.id.tv_name);

        ServicesModel servicesModel = servicesModelList.get(position);
        if (current_language.equals("ar")) {
            tv_name.setText(servicesModel.getAr_title());
        } else {
            tv_name.setText(servicesModel.getEn_title());

        }
        return convertView;
    }
}
