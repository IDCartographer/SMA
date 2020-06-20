package sample;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import java.io.*;
import java.util.ArrayList;

public class GraphOfSMA {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<Double, Double> MainGraph;

    @FXML
    private Button loadButton;

    @FXML
    void initialize() {
        loadButton.setOnAction(event ->
                {
                  loadData();

                }
        );
        assert MainGraph != null : "fx:id=\"MainGraph\" was not injected: check your FXML file 'GraphOfSMA.fxml'.";
        assert loadButton != null : "fx:id=\"loadButton\" was not injected: check your FXML file 'GraphOfSMA.fxml'.";




        //C:\Users\Aleks\OneDrive\Рабочий стол\Data for SMA.txt
    }
    private void loadData()
    {
        XYChart.Series series=new XYChart.Series();
        XYChart.Series series2=new XYChart.Series();
        ArrayList<Double> rawData=new ArrayList<Double>();
        ArrayList<Double> finalData=new ArrayList<Double>();

        try
        {
            FileInputStream fin = new FileInputStream("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\RawData.txt");
            FileReader fr = new FileReader("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\RawData.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (!(line.equals(null)))
            {
                if(line.equals("")){break;}
            rawData.add(new Double(Double.valueOf(line)));
            }
            fin.close();
            fr.close();
            reader.close();

            FileInputStream fin2 = new FileInputStream("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\SMAData.txt");
            FileReader fr2 = new FileReader("C:\\Users\\Aleks\\IdeaProjects\\FX-SMA-Project\\SMAData.txt");
            BufferedReader reader2 = new BufferedReader(fr2);
            String line2 = reader2.readLine();
            while (!(line2.equals(null)))
            {
                if(line.equals("")){break;}
                finalData.add(new Double(Double.valueOf(line2)));
            }
            fin2.close();
            fr2.close();
            reader2.close();


        }
        catch (Exception e)
        {
            System.out.println("Данных для построения нет");
        }
        series.setName("Raw");
        series2.setName("SMA");
        for(int i=0;i<rawData.size();i=i+1)
        {
        series.getData().add(new XYChart.Data<>(String.valueOf(i+1),rawData.get(i)));
        MainGraph.getData().add(series);
        }
        for(int i=0;i<finalData.size();i=i+1)
        {
        series2.getData().add(new XYChart.Data<>(String.valueOf(i+1),finalData.get(i)));
        MainGraph.getData().add(series2);
        }

    }
}