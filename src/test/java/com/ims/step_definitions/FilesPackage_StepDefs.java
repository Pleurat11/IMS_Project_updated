package com.ims.step_definitions;

import com.ims.pages.FilesPage;
import io.cucumber.java.en.And;

public class FilesPackage_StepDefs {
    FilesPage filesPage = new FilesPage();

    @And("user clicks on an existing component lot")
    public void userClicksOnAnExistingComponentLot(){
        filesPage.existingComponentLots();
    }


    @And("user clicks on attachments tab")
    public void userClicksOnAttachmentsTab() {
        filesPage.attachmentsTab.click();
    }


    @And("user clicks the upload button")
    public void userClicksTheUploadButton() {
        filesPage.uploadButton.click();
    }
}
