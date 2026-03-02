package com.guelph.engg1420finalprojectjavafx;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

public class EventsManagementView {

    private VBox root;

    public EventsManagementView (MainApp app) {
        root = new VBox();

        Label title = new Label("EVENTS MANAGEMENT");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");

        HBox buttonLayout = new HBox();
        buttonLayout.setSpacing(4);
        Button createEventBtn = new Button ("CREATE EVENT");
        Button backBtn = new Button ("GO BACK");
        backBtn.setOnAction(e -> {
            app.showMainView();
        });
        buttonLayout.getChildren().addAll(backBtn, createEventBtn);

        root.getChildren().addAll(title, buttonLayout);
    }
    public Parent getView() { return root;}
}
