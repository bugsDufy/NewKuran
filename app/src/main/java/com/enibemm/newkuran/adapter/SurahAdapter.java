package com.enibemm.newkuran.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.enibemm.newkuran.R;
import com.enibemm.newkuran.listener.SurahListener;
import com.enibemm.newkuran.model.Surah;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.ViewHolder> {

    private Context context;
    private List<Surah> list;
    private SurahListener surahListener;

    public SurahAdapter(Context context, List<Surah> list, SurahListener surahListener) {
        this.context = context;
        this.list = list;
        this.surahListener = surahListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.surah_layout,parent,false);

        return new ViewHolder(view,surahListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.surahNo.setText(String.valueOf(list.get(position).getNumber()));
        holder.arabicName.setText(list.get(position).getName());
        holder.englishName.setText(list.get(position).getEnglishName());
        holder.totalAya.setText(String.valueOf(list.get(position).getNumberOfAyahs()+ " Ayet"));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView surahNo,arabicName,englishName,totalAya;
        private SurahListener surahListener;

        public ViewHolder(@NonNull View itemView,SurahListener surahListener) {
            super(itemView);
            surahNo = itemView.findViewById(R.id.surah_number);
            arabicName = itemView.findViewById(R.id.arabic_name);
            englishName = itemView.findViewById(R.id.english_name);
            totalAya = itemView.findViewById(R.id.total_aya);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   surahListener.onSurahListener(getAdapterPosition());

                }
            });
        }
    }
}
