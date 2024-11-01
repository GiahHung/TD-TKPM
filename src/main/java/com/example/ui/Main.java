package com.example.ui;

import javax.swing.SwingUtilities;
import com.example.database.*;
import com.example.usecase.UsecaseControl;

public class Main {
    public static void main(String[] args) {
        
        ViewListProductPresenter presenter = new ViewListProductPresenter();
        ViewProductListDAO data = new ViewProductListDAO();
        UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
        ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);

     
        SwingUtilities.invokeLater(() -> {
            
            viewListProductController.execute();
            
            CRUDForm form = new CRUDForm();
            form.CRUD(presenter.getViewProductDTOs());
            form.setLocationRelativeTo(null);
            form.setVisible(true);
        });
    }
}
