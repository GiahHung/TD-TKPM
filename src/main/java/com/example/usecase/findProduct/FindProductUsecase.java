package com.example.usecase.findProduct;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.FoodProduct;
import com.example.entity.Product;

public class FindProductUsecase implements FindProductInputBoundary{
    FindProductOutputBoundary output = null;
    FindProductDatabaseBoundary database = null;


    public FindProductUsecase(FindProductOutputBoundary output, FindProductDatabaseBoundary database) {
        this.output = output;
        this.database = database;
    }

    @Override
    public void execute() {
        List<Product> listProduct = database.getProductListExpired();
        if(listProduct.size() == 0){
            ResponeData res = new ResponeData();
            res.message = "Không có sản phẩm nào";
            output.presenterErr(res);
        }else{
            List<FindProductOutputDTO> dto = new ArrayList<>();
            for (Product product : listProduct) {
                int mamh = product.getMaMh();
                String name = product.getName();
                int price = product.getPrice();
                String category = product.getCategory();
                int quantity = product.getQuantity();
                String dvt = product.getDvt();
                String nhacc= ((FoodProduct) product).getNhaCungCap();
                Date nsx = ((FoodProduct) product).getNSX();
                Date hsd = ((FoodProduct) product).getHSD();
                FindProductOutputDTO findProductOutputDTO = new FindProductOutputDTO(mamh, name, price, quantity, dvt,category, nhacc,nsx,hsd);
                dto.add(findProductOutputDTO);
            }
           
                output.presenter(dto);
        }
        
    }

}
