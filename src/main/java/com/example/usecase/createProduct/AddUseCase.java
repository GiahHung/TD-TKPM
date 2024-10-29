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

        if(category.equals("food") ){
            if(valiateTien(price) && valiateSL(quantity) && valiateHSD(addInputDTO.gethSD()) && validateNSX(addInputDTO.getnSX())){
                product = new FoodProduct(maMh, name, price, category, quantity, dvt, addInputDTO.getnSX(), 
            addInputDTO.gethSD(), addInputDTO.getNhaCungCap());
            }else{
                String message = "Thông tin không hợp lệ";
                ResponeData res = new ResponeData();
                res.message = message;
                addOutPutBoundary.presentError(res);
                return;
            }
            

        }else if(category.equals("ceramic") ){
            if(valiateTien(price) && valiateSL(quantity) && valiateNNK(addInputDTO.getNgayNhapKho())){
                product = new CeramicsProduct(maMh, name, price, category, quantity, dvt, 
            addInputDTO.getNgayNhapKho(), addInputDTO.getNhaSanXuat());
            }else{
                String message = "Thông tin không hợp lệ";
                ResponeData res = new ResponeData();
                res.message = message;
                addOutPutBoundary.presentError(res);
                return;
            }
            

        }else if(category.equals("electronic")  ){
            if(valiateTien(price) && valiateSL(quantity) && valiateBH(addInputDTO.getBaoHanh()) && valiateCongSuat(addInputDTO.getCongSuat()) ){
                product = new ElectronicProduct(maMh, name, price, category, quantity, dvt, 
            addInputDTO.getBaoHanh(), addInputDTO.getCongSuat());
            }else{
                String message = "Thông tin không hợp lệ";
                ResponeData res = new ResponeData();
                res.message = message;
                addOutPutBoundary.presentError(res);
                return;
            }
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
    private boolean valiateTien(int price){
        return price > 0;
    }

    private boolean valiateBH(int BH){
        return BH >= 0;
    }

    private boolean valiateCongSuat(int congSuat){
        return congSuat > 0;
    }


}
