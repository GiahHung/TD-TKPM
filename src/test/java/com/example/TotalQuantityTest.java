package com.example;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;
import com.example.database.TotalQuantityDAO;
import com.example.ui.totalQuantity.TotalQuantityPresenter;
import com.example.usecase.totalQuantity.TotalQuantityInputDTO;
import com.example.usecase.totalQuantity.TotalQuantityUsecase;
public class TotalQuantityTest {
    @Test
    public void testTotalQuantity() {
        TotalQuantityDAO data = new TotalQuantityDAO();
        TotalQuantityPresenter presenter = new TotalQuantityPresenter();
        TotalQuantityUsecase totalQuantityUsecase = new TotalQuantityUsecase(presenter,data );
        Set<String> categories = Set.of("food", "ceramic", "electronic");
        TotalQuantityInputDTO dto = new TotalQuantityInputDTO(categories);

        totalQuantityUsecase.execute(dto);
        assertEquals(190, presenter.getOutputDTO().getFoodQuantity());
        assertEquals(360, presenter.getOutputDTO().getCeramicQuantity());
        assertEquals(66, presenter.getOutputDTO().getElectronicQuantity());
    }
}

