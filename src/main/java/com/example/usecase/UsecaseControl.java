package com.example.usecase;
import java.util.*;

import com.example.entity.Product;

public class UsecaseControl implements InputBoundary{
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
            double price = product.getPrice();
            String category = product.getCategory();
            int quantity = product.getQuantity();
            String dvt = product.getDvt();
            ViewProductDTO viewProductDTO = new ViewProductDTO(name, price, maMh, quantity, dvt, category);
            DTO.add(viewProductDTO);
        }
        // ResponseData res = new ResponseData();
        // res.setProductList(listProduct);
        output.present(DTO);
    }
}
