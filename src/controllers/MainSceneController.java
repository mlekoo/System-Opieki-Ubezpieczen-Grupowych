package controllers;

import gui.WindowManager;
import javafx.fxml.FXML;

import javax.inject.Inject;
import javax.inject.Singleton;

/*
import sample.gui.WindowManager;
import sample.model.InsuranceAgent;
*/

@Singleton
public class MainSceneController {

  //  @Inject
  //  private InsuranceAgentService insuranceAgentService;

    @Inject
    WindowManager windowManager;

    @FXML
    private void menuClicked(){
        System.out.println();
       // InsuranceAgent insuranceAgent = new InsuranceAgent(4);
       // System.out.println(insuranceAgent.toString());

   //     System.out.println(insuranceAgentService.getAll());

    }

    @FXML
    private void addClicked(){
        windowManager.switchScene(WindowManager.SCENES.PERSON_LIST_SCENE);
    }

    @FXML
    private void contractsClicked(){
        windowManager.switchScene(WindowManager.SCENES.CHOOSE_CONTRACT_SCENE);
    }

    @FXML
    private void initialize() {
        System.out.println("initialize");

    }
}
