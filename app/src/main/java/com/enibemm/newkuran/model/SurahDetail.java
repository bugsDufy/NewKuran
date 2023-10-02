package com.enibemm.newkuran.model;

import com.google.gson.annotations.SerializedName;

public class SurahDetail {

    @SerializedName("id")
    private int id;

    @SerializedName("sura")
    private int sura;

    @SerializedName("aya")
    private int aya;

    @SerializedName("arabic_text")
    private String arabicText;

    @SerializedName("translation")
    private String translation;

    @SerializedName("footnotes")
    private String footnotes;

    public SurahDetail(int id, int sura, int aya, String arabicText, String translation, String footnotes) {
        this.id = id;
        this.sura = sura;
        this.aya = aya;
        this.arabicText = arabicText;
        this.translation = translation;
        this.footnotes = footnotes;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSura() {
        return sura;
    }

    public void setSura(int sura) {
        this.sura = sura;
    }

    public int getAya() {
        return aya;
    }

    public void setAya(int aya) {
        this.aya = aya;
    }

    public String getArabicText() {
        return arabicText;
    }

    public void setArabicText(String arabicText) {
        this.arabicText = arabicText;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(String footnotes) {
        this.footnotes = footnotes;
    }
}
