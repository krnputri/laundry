package com.example.laundry.Model;

public class Transaction {
    String transactionId, transactionAmbil, transactionName, transactionJenis, transactionDetail, transactionNameAmbil, transactionBayar;

//    public Transaction(){}

    public Transaction(String transactionId, String transactionAmbil, String transactionNameAmbil, String transactionName, String transactionJenis,
                   String transactionBayar, String transactionDetail){
        this.transactionId = transactionId;
        this.transactionAmbil = transactionAmbil;
        this.transactionName = transactionName;
        this.transactionNameAmbil = transactionNameAmbil;
        this.transactionJenis = transactionJenis;
        this.transactionBayar = transactionBayar;
        this.transactionDetail = transactionDetail;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionAmbil() {
        return transactionAmbil;
    }

    public void setTransactionAmbil(String transactionAmbil) {
        this.transactionAmbil = transactionAmbil;
    }

    public String getTransactionNameAmbil() {
        return transactionNameAmbil;
    }

    public void setTransactionNameAmbil(String transactionNameAmbil) {
        this.transactionNameAmbil = transactionNameAmbil;
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

    public void setTransactionenis(String transactionJenis) {
        this.transactionJenis = transactionJenis;
    }

    public String getTransactionBayar() {
        return transactionBayar;
    }

    public void setTransactionBayar(String transactionBayar) {
        this.transactionBayar = transactionBayar;
    }

    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

}
