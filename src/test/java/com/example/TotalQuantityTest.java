package com.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.example.database.TotalQuantityDAO;
import com.example.ui.totalQuantity.TotalQuantityPresenter;
import com.example.usecase.totalQuantity.TotalQuantityUsecase;
public class TotalQuantityTest {
    @Test
    public void testTotalQuantity() {
        TotalQuantityDAO data = new TotalQuantityDAO();
        TotalQuantityPresenter presenter = new TotalQuantityPresenter();
        TotalQuantityUsecase totalQuantityUsecase = new TotalQuantityUsecase(presenter,data );

        totalQuantityUsecase.execute();
        assertEquals(42, presenter.getOutputDTO().getFoodQuantity());
        assertEquals(160, presenter.getOutputDTO().getCeramicQuantity());
        assertEquals(62, presenter.getOutputDTO().getElectronicQuantity());
    }
}

