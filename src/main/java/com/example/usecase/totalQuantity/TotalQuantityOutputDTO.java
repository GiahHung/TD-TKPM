package com.example.usecase.totalQuantity;

public class TotalQuantityOutputDTO {
int foodQuantity;
int ceramicQuantity;
int electronicQuantity;


public TotalQuantityOutputDTO(int foodQuantity, int ceramicQuantity, int electronicQuantity) {
    this.foodQuantity = foodQuantity;
    this.ceramicQuantity = ceramicQuantity;
    this.electronicQuantity = electronicQuantity;
}
public int getFoodQuantity() {
    return foodQuantity;
}
public int getCeramicQuantity() {
    return ceramicQuantity;
}
public int getElectronicQuantity() {
    return electronicQuantity;
}

}
