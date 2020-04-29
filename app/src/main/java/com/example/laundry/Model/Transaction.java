package com.example.laundry.Model;

public class Transaction {
    String transactionId, transactionTanggal, transactionAmbil, transactionName, transactionJenis;
    int transactionTotal, transactionBayar;

    public Transaction(){

    }
    public Transaction(String transactionId, String transactionTanggal, String transactionAmbil, String transactionName, String transactionJenis,
                        int transactionTotal, int transactionBayar ){
        this.transactionId = transactionId;
        this.transactionTanggal = transactionTanggal;
        this.transactionAmbil = transactionAmbil;
        this.transactionName = transactionName;
        this.transactionJenis = transactionJenis;
        this.transactionTotal = transactionBayar;
        this.transactionBayar = transactionBayar;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionTanggal() {
        return transactionTanggal;
    }

    public void setTransactionTanggal(String transactionTanggal) {
        this.transactionTanggal = transactionTanggal;
    }

    public String getTransactionAmbil() {
        return transactionAmbil;
    }

    public void setTransactionAmbil(String transactionAmbil) {
        this.transactionAmbil = transactionAmbil;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getTransactionJenis() {
        return transactionJenis;
    }

    public void setTransactionJenis(String transactionJenis) {
        this.transactionJenis = transactionJenis;
    }

    public int getTransactionTotal() {
        return transactionTotal;
    }

    public void setTransactionTotal(int transactionTotal) {
        this.transactionTotal = transactionTotal;
    }

    public int getTransactionBayar() {
        return transactionBayar;
    }

    public void setTransactionBayar(int transactionBayar) {
        this.transactionBayar = transactionBayar;
    }
}
