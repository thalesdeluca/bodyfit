package com.bodyfit.dto;


import com.bodyfit.model.Charge;

import java.util.ArrayList;

public class ChargeListDTO {
    private Boolean success;
    private String errorMessage;
    private ArrayList<Charge> charges;

    @Override
    public String toString() {
        return "ChargeListDTO{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", charges=" + charges +
                '}';
    }

    public ChargeListDTO(Boolean success, String errorMessage, ArrayList<Charge> charges) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.charges = charges;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ArrayList<Charge> getCharges() {
        return charges;
    }

    public void setCharges(ArrayList<Charge> charges) {
        this.charges = charges;
    }
}
