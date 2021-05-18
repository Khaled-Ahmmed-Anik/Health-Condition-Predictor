package com.khlaedahmmedanik.healthconditionpredictor;

import java.util.ArrayList;
import java.util.List;

public class diseaseInfo {
    public String diseaseName;
    public String symptoms;

    public diseaseInfo(String diseaseName, String symptoms) {
        this.diseaseName = diseaseName;
        this.symptoms = symptoms;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
