package com.example.laundry.Model;

public class Laundry {
    String laundryId, laundryTanggal, laundryAmbil, laundryName, laundryJenis, laundryDetail;
    int laundryTotal, laundryBayar;

    public Laundry(){}

    public Laundry(String laundryId, String laundryTanggal, String laundryAmbil, String laundryName, String laundryJenis,
                   int laundryTotal, int laundryBayar, String laundryDetail){
        this.laundryId = laundryId;
        this.laundryTanggal = laundryTanggal;
        this.laundryAmbil = laundryAmbil;
        this.laundryName = laundryName;
        this.laundryJenis = laundryJenis;
        this.laundryTotal = laundryTotal;
        this.laundryBayar = laundryBayar;
        this.laundryDetail = laundryDetail;
    }

    public String getLaundryId() {
        return laundryId;
    }

    public void setLaundryId(String laundryId) {
        this.laundryId = laundryId;
    }

    public String getLaundryTanggal() {
        return laundryTanggal;
    }

    public void setLaundryTanggal(String laundryTanggal) {
        this.laundryTanggal = laundryTanggal;
    }

    public String getLaundryAmbil() {
        return laundryAmbil;
    }

    public void setLaundryAmbil(String laundryAmbil) {
        this.laundryAmbil = laundryAmbil;
    }

    public String getLaundryName() {
        return laundryName;
    }

    public void setLaundryName(String laundryName) {
        this.laundryName = laundryName;
    }

    public String getLaundryJenis() {
        return laundryJenis;
    }

    public void setLaundryJenis(String laundryJenis) {
        this.laundryJenis = laundryJenis;
    }

    public int getLaundryTotal() {
        return laundryTotal;
    }

    public void setLaundryTotal(int laundryTotal) {
        this.laundryTotal = laundryTotal;
    }

    public int getLaundryBayar() {
        return laundryBayar;
    }

    public void setLaundryBayar(int laundryBayar) {
        this.laundryBayar = laundryBayar;
    }

    public String getLaundryDetail() {
        return laundryDetail;
    }

    public void setLaundryDetail(String laundryDetail) {
        this.laundryDetail = laundryDetail;
    }
}
