package com.example.usecase.totalQuantity;

import java.util.Set;

public class TotalQuantityInputDTO {
  private String categories;

    public TotalQuantityInputDTO(String categories) {
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

}
