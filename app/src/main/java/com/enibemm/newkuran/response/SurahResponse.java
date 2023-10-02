package com.enibemm.newkuran.response;

import com.enibemm.newkuran.model.Surah;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahResponse {
    @SerializedName("data")
    private List<Surah> list;

    public List<Surah> getList() {
        return list;
    }


}
