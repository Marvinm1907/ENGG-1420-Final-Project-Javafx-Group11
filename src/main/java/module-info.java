module com.guelph.engg1420finalprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.guelph.engg1420finalprojectjavafx to javafx.fxml;
    exports com.guelph.engg1420finalprojectjavafx;
}