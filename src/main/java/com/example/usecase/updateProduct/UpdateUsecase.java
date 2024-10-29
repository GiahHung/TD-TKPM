package com.example.usecase.updateProduct;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import java.util.*;

public class UpdateUsecase implements UpdateInputBoundary {
    UpdateOutputBoundary outputBoundary = null;
    UpdateDatabaseBoundary updateDatabaseBoundary = null;

    public UpdateUsecase(UpdateOutputBoundary outputBoundary, UpdateDatabaseBoundary updateDatabaseBoundary) {
        this.outputBoundary = outputBoundary;
        this.updateDatabaseBoundary = updateDatabaseBoundary;
    }

    @Override
    public void execute(UpdateInputDTO inputDTO) {
        Product product = null;
        int maMh = inputDTO.getMaMh();
        String name = inputDTO.getName();
        int price = inputDTO.getPrice();
        String category = inputDTO.getCategory();
        int quantity = inputDTO.getQuantity();
        String dvt = inputDTO.getDvt();

        // Validate for food category
        if (category.equals("food")) {
            if (validatePrice(price) && validateQuantity(quantity) && validateExpiryDate(inputDTO.gethSD()) && validateNSX(inputDTO.getnSX())) {
                product = new FoodProduct(maMh, name, price, category, quantity, dvt, inputDTO.getnSX(), inputDTO.gethSD(), inputDTO.getNhaCungCap());
            } else {
                outputError("Thông tin không hợp lệ");
                return;
            }

        } else if (category.equals("ceramic")) {
            // Validate for ceramic category
            if (validatePrice(price) && validateQuantity(quantity) && validateStorageDate(inputDTO.getNgayNhapKho())) {
                product = new CeramicsProduct(maMh, name, price, category, quantity, dvt, inputDTO.getNgayNhapKho(), inputDTO.getNhaSanXuat());
            } else {
                outputError("Thông tin không hợp lệ");
                return;
            }

        } else if (category.equals("electronic")) {
            // Validate for electronic category
            if (validatePrice(price) && validateQuantity(quantity)) {
                product = new ElectronicProduct(maMh, name, price, category, quantity, dvt, inputDTO.getBaoHanh(), inputDTO.getCongSuat());
            } else {
                outputError("Thông tin không hợp lệ");
                return;
            }
        }

        // Check if product exists, update and return result
        if (updateDatabaseBoundary.checkProduct(product)) {
            int updatedMamh = updateDatabaseBoundary.update(product);
            Product updatedProduct = updateDatabaseBoundary.findProduct(updatedMamh);
            UpdateOutputDTO updateOutputDTO = new UpdateOutputDTO(
                    updatedProduct.getMaMh(),
                    updatedProduct.getName(),
                    updatedProduct.getPrice(),
                    updatedProduct.getQuantity(),
                    updatedProduct.getDvt(),
                    updatedProduct.getCategory()
            );
            outputBoundary.presenter(updateOutputDTO);
        } else {
            outputError("Not found");
        }
    }

    private void outputError(String message) {
        ResponeData res = new ResponeData();
        res.message = message;
        outputBoundary.presentError(res);
    }

    private boolean validateNSX(Date NSX) {
        return NSX != null && NSX.before(new Date());
    }

    private boolean validateExpiryDate(Date HSD) {
        return HSD != null && HSD.after(new Date());
    }

    private boolean validateStorageDate(Date NKK) {
        return NKK != null && NKK.before(new Date());
    }

    private boolean validateQuantity(int quantity) {
        return quantity >= 0;
    }

    private boolean validatePrice(double price) {
        return price > 0;
    }
}
