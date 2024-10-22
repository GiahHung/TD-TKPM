package com.example.usecase.createProduct;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import java.util.*;;

public class AddUseCase implements AddInputBoundary{
    private AddDatabaseBoundary data = null;
    private AddOutPutBoundary addOutPutBoundary= null;

    public AddUseCase(AddDatabaseBoundary data, AddOutPutBoundary addOutPutBoundary) {
        this.data = data;
        this.addOutPutBoundary = addOutPutBoundary;
    }

    @Override
    public void execute(AddInputDTO addInputDTO) {
        Product product = null;
        int maMh = addInputDTO.getMaMh(); 
        String name = addInputDTO.getName(); 
        int price = addInputDTO.getPrice();
        String category = addInputDTO.getCategory(); 
        int quantity = addInputDTO.getQuantity(); 
        String dvt = addInputDTO.getDvt();

        if(category.equals("food") && valiateTien(price) && valiateSL(quantity) && valiateHSD(addInputDTO.gethSD()) && validateNSX(addInputDTO.getnSX())){
            product = new FoodProduct(maMh, name, price, category, quantity, dvt, addInputDTO.getnSX(), 
            addInputDTO.gethSD(), addInputDTO.getNhaCungCap());

        }else if(category.equals("ceramic") && valiateTien(price) && valiateSL(quantity) && valiateNNK(addInputDTO.getNgayNhapKho())){
            product = new CeramicsProduct(maMh, name, price, category, quantity, dvt, 
            addInputDTO.getNgayNhapKho(), addInputDTO.getNhaSanXuat());

        }else if(category.equals("electronic") && valiateTien(price) && valiateSL(quantity) ){
            product = new ElectronicProduct(maMh, name, price, category, quantity, dvt, 
            addInputDTO.getBaoHanh(), addInputDTO.getCongSuat());

        }
        int newProductId = data.addProduct(product);
        Product newProduct = data.findProduct(newProductId);


        AddOutputDTO addOutputDTO = new AddOutputDTO(newProduct.getName(), newProduct.getPrice(), newProduct.getMaMh(), newProduct.getQuantity(), newProduct.getDvt(), newProduct.getCategory());
        addOutPutBoundary.present(addOutputDTO);
    }
    private boolean validateNSX(Date NSX){
        return NSX != null && NSX.before(new Date());
    }

    private boolean valiateHSD(Date HSD){
        return HSD != null && HSD.after(new Date()); 
    }
    private boolean valiateNNK(Date NKK){
        return NKK != null && NKK.before(new Date()); 
    }
    private boolean valiateSL(int quantity){
        return quantity >= 0;
    }
    private boolean valiateTien(double price){
        return price > 0;
    }


}
