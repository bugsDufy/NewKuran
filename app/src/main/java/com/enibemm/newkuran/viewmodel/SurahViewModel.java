package com.enibemm.newkuran.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.enibemm.newkuran.repository.SurahRepo;
import com.enibemm.newkuran.response.SurahResponse;

public class SurahViewModel extends ViewModel {

    private SurahRepo surahRepo;

    public SurahViewModel() {
        surahRepo = new SurahRepo();
    }
    public LiveData<SurahResponse> getSurah(){
        return surahRepo.getSurah();
    }
}
