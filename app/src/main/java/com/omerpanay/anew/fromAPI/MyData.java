package com.omerpanay.anew.fromAPI;

import com.omerpanay.anew.fromAPI.Datum;

import java.util.List;

public class MyData {


    private String next;
    private long total;
    private List<Datum> data;

    public String getNext() { return next; }
    public void setNext(String value) { this.next = value; }

    public long getTotal() { return total; }
    public void setTotal(long value) { this.total = value; }

    public List<Datum> getData() { return data; }
    public void setData(List<Datum> value) { this.data = value; }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Next: ").append(next).append("\n");
        stringBuilder.append("Total: ").append(total).append("\n");
        stringBuilder.append("Data:\n");
        for (Datum datum : data) {
            stringBuilder.append("\t").append(datum.toString()).append("\n");
        }
        return stringBuilder.toString();
    }



}

