package gui;

import java.util.Map.Entry;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import lab7.Reader;

public class PdfWordChartPane extends BorderPane{
	Reader source = new Reader();
	public CategoryAxis xAxis = new CategoryAxis();
    public NumberAxis yAxis = new NumberAxis();
	public BarChart<String, Number> bc = new BarChart<String, Number>(xAxis,yAxis);
	public XYChart.Series series1 = new XYChart.Series();
	
	public void start() {
		this.setCenter(bc);
		barChart();
	}
	 
	@SuppressWarnings("unchecked")
	public void barChart() { 
		bc.setTitle("PDF Word Frequencies");
        xAxis.setLabel("Word");       
        yAxis.setLabel("Count");
                
        series1.setName("Chart");
        for (String key : source.finalList.keySet()) {
        series1.getData().add(new XYChart.Data(key, source.finalList.get(key)));// fix this
        }
       
        bc.getData().add(series1);
	}
}
