package sample;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FirstField;//Шаг SMA

    @FXML
    private TextField SecondField;//Путь к файлу

    @FXML
    private Button MainButton;

    @FXML
    void initialize() {
        MainButton.setOnAction(event ->
        {
            try
            {
            String FileWay= SecondField.getText();
            int ValueSMA=Integer.parseInt(FirstField.getText());
            Function.Reader(FileWay,ValueSMA);
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("GraphOfSMA.fxml"));
                Parent root1=(Parent) fxmlLoader.load();
                Stage stage=new Stage();
                stage.setTitle("Raw and SMA data");
                stage.setScene(new Scene(root1));
                stage.show();
            }
            catch (Exception T)
            {
                System.out.println("Введены не корректные данные");
            }





        })

        ;
        assert FirstField != null : "fx:id=\"FirstField\" was not injected: check your FXML file 'TestFX.fxml'.";
        assert SecondField != null : "fx:id=\"SecondField\" was not injected: check your FXML file 'TestFX.fxml'.";
        assert MainButton != null : "fx:id=\"MainButton\" was not injected: check your FXML file 'TestFX.fxml'.";

    }
}