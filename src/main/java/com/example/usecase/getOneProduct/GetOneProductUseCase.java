package com.example.usecase.getOneProduct;

import java.util.Date;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import com.example.usecase.ViewProductDTO;

public class GetOneProductUseCase implements GetOneProductInputBoundary{
    GetOneProductDataBoundary data = null;
    GetOneProductOutputBoundary output = null;
    
    public GetOneProductUseCase(GetOneProductDataBoundary data, GetOneProductOutputBoundary output) {
        this.data = data;
        this.output = output;
    }
    @Override
    public void execute(int mamh) {
        Product product = data.getOneProduct(mamh);
            int ma = product.getMaMh();
            String name = product.getName();
            int price = product.getPrice();
            String category = product.getCategory();
            int quantity = product.getQuantity();
            String dvt = product.getDvt();
            Date NSX = null;
            Date HSD = null;
            String nhacc = null;
            String nhaXS = null;
            Date ngayNhapKho = null;
            int baoHanh = 0;
            int congSuat = 0;
       
            if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                NSX = foodProduct.getNSX();
                HSD = foodProduct.getHSD();
                nhacc = foodProduct.getNhaCungCap();
            }

            if (product instanceof CeramicsProduct) {
                CeramicsProduct ceramicsProduct = (CeramicsProduct) product;
                nhaXS = ceramicsProduct.getNhaSanXuat();
                ngayNhapKho = ceramicsProduct.getNgayNhapKho();
            }

            if (product instanceof ElectronicProduct) {
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                baoHanh = electronicProduct.getBaoHanh();
                congSuat = electronicProduct.getCongSuat();
            }

            GetOneProductOutputDTO DTO = new GetOneProductOutputDTO(name, price, ma, quantity, dvt, category, NSX, HSD, nhacc, nhaXS, ngayNhapKho, baoHanh, congSuat);
    
            output.present(DTO);

    }

}
