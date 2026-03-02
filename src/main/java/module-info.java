module com.guelph.engg1420finalprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.guelph.engg1420finalprojectjavafx to javafx.fxml;
    exports com.guelph.engg1420finalprojectjavafx;
}