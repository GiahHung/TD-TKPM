package com.example.usecase.deleteProduct;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;

public class DeleteUsecase implements DeleteInputBoundary{
 DeleteOutputBoundary output = null;
 DeleteDatabaseBoundary deleteData = null;

public DeleteUsecase(DeleteOutputBoundary deleteOutputBoundary, DeleteDatabaseBoundary deleteDatabaseBoundary) {
    this.output = deleteOutputBoundary;
    this.deleteData = deleteDatabaseBoundary;
}

@Override
public void execute(DeleteInputDTO deleteInputDTO) {
     Product product = null;
     DeleteOutputDTO deleteOutputDTO = null;
        int maMh = deleteInputDTO.getMaMh(); 
        String name = deleteInputDTO.getName(); 
        int price = deleteInputDTO.getPrice();
        String category = deleteInputDTO.getCategory(); 
        int quantity = deleteInputDTO.getQuantity(); 
        String dvt = deleteInputDTO.getDvt();

        if(category.equals("food")){
            product = new FoodProduct(maMh, name, price, category, quantity, dvt, deleteInputDTO.getnSX(), 
            deleteInputDTO.gethSD(), deleteInputDTO.getNhaCungCap());

        }else if(category.equals("ceramic") ){
            product = new CeramicsProduct(maMh, name, price, category, quantity, dvt, 
            deleteInputDTO.getNgayNhapKho(), deleteInputDTO.getNhaSanXuat());

        }else if(category.equals("electronic")){
            product = new ElectronicProduct(maMh, name, price, category, quantity, dvt, 
            deleteInputDTO.getBaoHanh(), deleteInputDTO.getCongSuat());

        }
        if (deleteData.checkProduct(product)) {
            deleteData.delete(product);
           String message = "Product deleted successfully.";
           deleteOutputDTO = new DeleteOutputDTO(message);
           output.present(deleteOutputDTO);
        } else {
            String message = "Product deleted fail.";
            deleteOutputDTO = new DeleteOutputDTO(message);
            output.present(deleteOutputDTO);
        }
}
 
}
