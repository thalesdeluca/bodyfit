package com.bodyfit.dto;

import com.bodyfit.model.Intensity;

import java.util.ArrayList;

public class IntensityDTO {
    private boolean success;
    private String errorMessage;
    private ArrayList<Intensity> intensities;

    @Override
    public String toString() {
        return "IntensityDTO{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", intensity=" + intensities +
                '}';
    }

    public IntensityDTO() {

    }

    public IntensityDTO(Boolean success, String errorMessage, ArrayList<Intensity> intensities) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.intensities = intensities;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList<Intensity> getIntensities() {
        return intensities;
    }

    public void setIntensities(ArrayList<Intensity> intensities) {
        this.intensities = intensities;
    }
}
