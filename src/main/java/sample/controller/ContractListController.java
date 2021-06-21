package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import sample.database.PersonService;
import sample.gui.WindowManager;
import sample.gui.modeladapter.ListViewModelAdapter;
import sample.model.Person;

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
