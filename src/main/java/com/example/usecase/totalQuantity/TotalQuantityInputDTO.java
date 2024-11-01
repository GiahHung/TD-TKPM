package com.example.usecase.totalQuantity;

import java.util.Set;

public class TotalQuantityInputDTO {
  private Set<String> categories;

    public TotalQuantityInputDTO(Set<String> categories) {
        this.categories = categories;
    }

    public Set<String> getCategories() {
        return categories;
    }

}
