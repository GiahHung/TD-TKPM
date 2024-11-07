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
     DeleteOutputDTO deleteOutputDTO = null;
        int maMh = deleteInputDTO.getMaMh(); 
       
        if (deleteData.checkProduct(maMh)) {
            deleteData.delete(maMh);
           String message = "Xóa thành công";
           deleteOutputDTO = new DeleteOutputDTO(message);
           output.present(deleteOutputDTO);
        } else {
            String message = "Xóa thất bại";
            deleteOutputDTO = new DeleteOutputDTO(message);
            output.present(deleteOutputDTO);
        }
}
 
}
