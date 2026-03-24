package com.guelph.engg1420finalprojectjavafx;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ShowMainView {
    // VBox store elements up and down

    // HBox Storing them left to right
    private VBox root;

    public ShowMainView(MainApp app) {
        root = new VBox();
        root.setSpacing(20);
        root.setStyle("-fx-padding: 30");

        Label title = new Label("CAMPUS EVENT BOOKING SYSTEM");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold");

        HBox buttonLayout = new HBox();
        buttonLayout.setSpacing(4);
        Button userManBtn = new Button("USER MANAGEMENT");
        userManBtn.setOnAction(e -> {
            app.showManageUserView();
        });

        Button bookingManBtn = new Button("BOOKING MANAGEMENT");
        bookingManBtn.setOnAction(e -> {
            app.showBookingManagementView();
        });

        Button eventManBtn = new Button("EVENT MANAGEMENT");
        eventManBtn.setOnAction(e->{
            app.showEventsManagementView();
        });

        Button waitlistManBtn = new Button("WAITLIST MANAGEMENT");
        waitlistManBtn.setOnAction(e -> {
            app.showWaitlistManagementView();
        });

        buttonLayout.getChildren().addAll(userManBtn, bookingManBtn, eventManBtn, waitlistManBtn);

        root.getChildren().addAll(title, buttonLayout);
    }

    public Parent getView() {
        return root;
    }

}

