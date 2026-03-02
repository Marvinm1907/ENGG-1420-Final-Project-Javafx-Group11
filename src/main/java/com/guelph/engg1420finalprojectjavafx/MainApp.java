package com.guelph.engg1420finalprojectjavafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main app will be the main stage and what we use to switch scenes
public class MainApp extends Application {
    private Stage primaryStage; // main windows of the program

    // STAGE -> SCENE -> H/V Box

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;

        // show something
        showMainView();

        primaryStage.setTitle("Main App 123"); // title is on the window
        primaryStage.show();
    }

    public void showMainView() {
        ShowMainView view = new ShowMainView(this);
        Scene scene = new Scene(view.getView(), 600, 400);
        primaryStage.setScene(scene);
    }

    public void showManageUserView() {
        UserManagementView view = new UserManagementView(this);
        Scene scene = new Scene(view.getView(), 600, 400);
        primaryStage.setScene(scene);
    }

    public void showEventsManagementView() {
        EventsManagementView view = new EventsManagementView(this);
        Scene scene = new Scene(view.getView(), 600, 400);
        primaryStage.setScene(scene);
    }

}
