package com.example.usecase;
import java.util.*;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;

public class UsecaseControl implements InputBoundary {
    private OutputBoundary output;
    private DataBaseBoundary data;

    public UsecaseControl(OutputBoundary output, DataBaseBoundary data) {
        this.output = output;
        this.data = data;
    }

    @Override
    public void execute() {
        List<Product> listProduct = data.getProductList();
        List<ViewProductDTO> DTO = new ArrayList<>();
        
        for (Product product : listProduct) {
            int maMh = product.getMaMh();
            String name = product.getName();
            int price = product.getPrice();
            String category = product.getCategory();
            int quantity = product.getQuantity();
            String dvt = product.getDvt();

            // Khai báo các biến để lưu thông tin riêng của từng loại sản phẩm
            Date NSX = null;
            Date HSD = null;
            String nhacc = null;
            String nhaXS = null;
            Date ngayNhapKho = null;
            int baoHanh = 0;
            int congSuat = 0;

            // Kiểm tra nếu product là một FoodProduct
            if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                NSX = foodProduct.getNSX();
                HSD = foodProduct.getHSD();
                nhacc = foodProduct.getNhaCungCap();
            }

            // Kiểm tra nếu product là một CeramicsProduct
            if (product instanceof CeramicsProduct) {
                CeramicsProduct ceramicsProduct = (CeramicsProduct) product;
                nhaXS = ceramicsProduct.getNhaSanXuat();
                ngayNhapKho = ceramicsProduct.getNgayNhapKho();
            }

            // Kiểm tra nếu product là một ElectronicProduct
            if (product instanceof ElectronicProduct) {
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                baoHanh = electronicProduct.getBaoHanh();
                congSuat = electronicProduct.getCongSuat();
            }

            // Tạo ViewProductDTO với các tham số đã lấy từ sản phẩm
            ViewProductDTO viewProductDTO = new ViewProductDTO(name, price, maMh, quantity, dvt, category, NSX, HSD, nhacc, nhaXS, ngayNhapKho, baoHanh, congSuat);
            DTO.add(viewProductDTO);
        }
        
        output.present(DTO);
    }
}
