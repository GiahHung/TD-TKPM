package com.example.ui.register;

import com.example.usecase.register.ResgisterInputBoundary;
import com.example.usecase.register.ResgisterInputDTO;

public class ResgisterController {
ResgisterInputBoundary resgisterInputBoundary = null;

public ResgisterController(ResgisterInputBoundary resgisterInputBoundary){
this.resgisterInputBoundary = resgisterInputBoundary;
}

public void execute(ResgisterInputDTO resgisterInputDTO) throws Exception{
    resgisterInputBoundary.execute(resgisterInputDTO);
}
}
