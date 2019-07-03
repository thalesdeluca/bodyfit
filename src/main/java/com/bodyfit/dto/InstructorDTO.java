package com.bodyfit.dto;

import com.bodyfit.model.Instructor;

public class InstructorDTO {
    private Boolean success;
    private String errorMessage;
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDTO{" +
                "success=" + success +
                ", errorMessage='" + errorMessage + '\'' +
                ", instructor=" + instructor +
                '}';

    }

    public InstructorDTO() {

    }

    public InstructorDTO(Boolean success, String errorMessage, Instructor instructor) {
        this.success = success;
        this.errorMessage = errorMessage;
        this.instructor = instructor;
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

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
}
