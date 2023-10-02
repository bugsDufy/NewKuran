package com.enibemm.newkuran.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.enibemm.newkuran.repository.SurahDetailRepo;
import com.enibemm.newkuran.response.SurahDetailResponse;

public class SurahDetailViewModel extends ViewModel {

    public SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel() {
        surahDetailRepo = new SurahDetailRepo();
    }
    public LiveData<SurahDetailResponse> getSurahDetail(String lan, int id){
        return surahDetailRepo.getSurahDetail(lan, id);
    }
}
