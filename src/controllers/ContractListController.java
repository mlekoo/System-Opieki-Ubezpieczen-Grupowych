package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import gui.WindowManager;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ContractListController {

    @FXML
    private ListView<String> contractListView;

    String[] contract = {"xd","xd","xd","xd","xd","xd","xd","xd","xd","xd","xd"};

    @Inject
    WindowManager windowManager;

    @FXML
    private void initialize() {
        System.out.println("initialize");
        contractListView.getItems().addAll(contract);
    }

}
