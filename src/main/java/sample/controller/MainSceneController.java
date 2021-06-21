package sample.controller;

import javafx.fxml.FXML;
import sample.database.InsuranceAgentService;
import sample.database.PersonService;
import sample.model.InsuranceAgent;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MainSceneController {

  //  @Inject
  //  private InsuranceAgentService insuranceAgentService;

    @FXML
    private void menuClicked(){
        System.out.println();
        InsuranceAgent insuranceAgent = new InsuranceAgent();
        System.out.println(insuranceAgent.toString());

   //     System.out.println(insuranceAgentService.getAll());

    }

    @FXML
    private void addClicked(){

    }

    @FXML
    private void initialize() {
        System.out.println("initialize");

    }
}
