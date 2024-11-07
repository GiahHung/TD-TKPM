package com.example.ui;

import javax.swing.SwingUtilities;
import com.example.database.*;
import com.example.ui.getAllCode.GetAllCodePresenter;
import com.example.usecase.UsecaseControl;
import com.example.usecase.getAllCode.GetAllCodeUsecase;

public class Main {
    public static void main(String[] args) {
        ViewListProductPresenter presenter = new ViewListProductPresenter();
    ViewProductListDAO data = new ViewProductListDAO();
    UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
    ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
    viewListProductController.execute();
    GetAllCodeDAO dataCategory = new GetAllCodeDAO();
    GetAllCodePresenter presentCategory = new GetAllCodePresenter();
    GetAllCodeUsecase usecase = new GetAllCodeUsecase(dataCategory,presentCategory);
    usecase.execute("category");
        SwingUtilities.invokeLater(() -> new MainForm(presenter.getViewProductDTOs(),presentCategory.getCategory()));
    }
}
