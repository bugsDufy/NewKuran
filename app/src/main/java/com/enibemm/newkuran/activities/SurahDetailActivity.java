package com.enibemm.newkuran.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.enibemm.newkuran.R;
import com.enibemm.newkuran.adapter.SurahDetailAdapter;
import com.enibemm.newkuran.common.Common;
import com.enibemm.newkuran.model.SurahDetail;
import com.enibemm.newkuran.response.SurahDetailResponse;
import com.enibemm.newkuran.viewmodel.SurahDetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailActivity extends AppCompatActivity {

    private TextView surahName, surahType, surahTranslation;
    private int no;
    private RecyclerView recyclerView;
    private List<SurahDetail> list;
    private SurahDetailAdapter surahDetailAdapter;
    private SurahDetailViewModel surahDetailViewModel;
    private String languageTurkish = "turkish_shaban";
    private String languageEnglish = "english_rwwad";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        surahName = findViewById(R.id.surah_name);
        surahType = findViewById(R.id.type);
        surahTranslation = findViewById(R.id.translation);
        recyclerView = findViewById(R.id.surah_detail_recyclerView);

        no = getIntent().getIntExtra(Common.SURAH_NO,0);

        surahName.setText(getIntent().getStringExtra(Common.SURAH_NAME));

        surahType.setText(getIntent().getStringExtra(Common.SURAH_TYPE)+ " "+
                getIntent().getIntExtra(Common.SURAH_TOTAL_AYA,0)+ " AYA");

        surahTranslation.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));

        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        surahTranslation(languageTurkish,no);
    }
    private void surahTranslation(String lan, int id) {
        if (list.size()>0){
            list.clear();
        }
        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);
        surahDetailViewModel.getSurahDetail(lan,id).observe( this, surahDetailResponse -> {

            for (int i = 0; i < surahDetailResponse.getList().size(); i++){
                list.add(new SurahDetail(surahDetailResponse.getList().get(i).getId(),
                        surahDetailResponse.getList().get(i).getSura(),
                        surahDetailResponse.getList().get(i).getAya(),
                        surahDetailResponse.getList().get(i).getArabicText(),
                        surahDetailResponse.getList().get(i).getTranslation(),
                        surahDetailResponse.getList().get(i).getFootnotes()));

                // System.out.println(surahDetailResponse.getList().get(i).getAya());
                //System.out.println("---------------");
                //System.out.println(surahDetailResponse.getList().get(i).getTranslation());
            }
            if (list.size()!=0){
                surahDetailAdapter = new SurahDetailAdapter(this,list);
                recyclerView.setAdapter(surahDetailAdapter);
            }
        });
    }
}