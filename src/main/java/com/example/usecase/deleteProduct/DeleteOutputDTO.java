package com.example.usecase.deleteProduct;

public class DeleteOutputDTO {
    protected String message;       

    public DeleteOutputDTO( String message) {
        this.message = message;
    }

    // Getter cho message
    public String getMessage() {
        return message;
    }
}
