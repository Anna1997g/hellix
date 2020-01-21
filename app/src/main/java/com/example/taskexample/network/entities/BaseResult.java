package com.example.taskexample.network.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
public class BaseResult {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;
    @SerializedName("internal_errors")
    @Expose
    private List<Object> internalErrors = null;
    @SerializedName("metadata")
    @Expose
    private List<Metadatum> metadata = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    public List<Object> getInternalErrors() {
        return internalErrors;
    }

    public void setInternalErrors(List<Object> internalErrors) {
        this.internalErrors = internalErrors;
    }

    public List<Metadatum> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Metadatum> metadata) {
        this.metadata = metadata;
    }



    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", errors=" + errors +
                ", internalErrors=" + internalErrors +
                ", metadata=" + metadata +
                '}';
    }
}
