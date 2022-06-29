package com.ims.step_definitions;

import com.ims.pages.AssemblyLotPage;
import io.cucumber.java.en.And;

public class AssemblyLots_StepDefs {
    AssemblyLotPage assemblyLotPage = new AssemblyLotPage();

    @And("I click on the Assembly Lots tab")
    public void iClickOnTheAssemblyLotsTab(){
        assemblyLotPage.clickAssemblyLotsTab();
    }

    @And("I click the Add Lot button at the top")
    public void iClickTheAddLotButtonAtTheTop() {
        assemblyLotPage.clickAddLot();
    }
}
