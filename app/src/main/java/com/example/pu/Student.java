package com.example.pu;

public class Student {

    String sName,sPersnolId,sParulId,sInstitue,sNumber,sEventName;

    public String getsName() {
        return sName;
    }

    public String getsPersnolId() {
        return sPersnolId;
    }

    public String getsParulId() {
        return sParulId;
    }

    public String getsInstitue() {
        return sInstitue;
    }

    public String getsNumber() {
        return sNumber;
    }

    public  String getsEventName(){
        return sEventName;
    }

    public Student(String sName, String sPersnolId, String sParulId, String sInstitue, String sNumber,String sEventName) {
        this.sName = sName;
        this.sPersnolId = sPersnolId;
        this.sParulId = sParulId;
        this.sInstitue = sInstitue;
        this.sNumber = sNumber;
        this.sEventName =sEventName;
    }


}
