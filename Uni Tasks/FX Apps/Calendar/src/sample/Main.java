package sample;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        CustomCalendar calendar = createCalendar();
        String stageName = String.format("Calendar for %s %s", calendar.getMonth(), calendar.getYear());


        Scene scene = displayScene(calendar);
        primaryStage.setTitle(stageName);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static CustomCalendar createCalendar() throws ParseException {
        String input = inputDialog("Enter month and year to be shown:", "", "");
        int month = Integer.valueOf(input.split(" ")[0]);
        int year = Integer.valueOf(input.split(" ")[1]);

        CustomCalendar calendar = new CustomCalendar(month, year);
        return calendar;
    }

    private static String inputDialog(String infoMessage, String titleBar,
                                     String headerMessage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        return dialog.showAndWait().get();
    }

    public static Scene  displayScene(CustomCalendar calendar) {
        Pane pane = new Pane();
        pane.setPadding(new Insets(100, 100, 100, 100));
        displayWeekDays(pane);

        //Current Date
        LocalDateTime now = LocalDateTime.now();
        int yearNow = now.getYear();
        int monthNow = now.getMonthValue();
        int dayNow = now.getDayOfMonth();

        int weekDay = calendar.getFirstDayOfMonth();

        int placementOfDateCoordinateX = 50 * (weekDay - 1) + 20;
        int placementOfDateCoordinateY = 40;
        int countOfDatesOnRow = 0;

        for (int i = 1; i <= calendar.daysInMonth(); i++){
            while (countOfDatesOnRow != 7 && i <= calendar.daysInMonth() && placementOfDateCoordinateX <= 320){
                Text date = new Text(placementOfDateCoordinateX, placementOfDateCoordinateY, String.valueOf(i));
                date.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));

                if (calendar.getYear() == yearNow && calendar.getMonthAsInt() == monthNow && i == dayNow)
                    date.setFill(Color.RED);

                pane.getChildren().add(date);
                countOfDatesOnRow++;
                placementOfDateCoordinateX += 50;
                i++;
            }

            placementOfDateCoordinateX = 20;
            placementOfDateCoordinateY += 20;
            countOfDatesOnRow = 0;
            i--;
        }

        return new Scene(pane);
    }

    private static void displayWeekDays(Pane pane){
        int placementCoordinateX = 20;
        int placementCoordinateY = 20;
        List<String> daysOfWeek = Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");
        for (int i = 0; i < daysOfWeek.size(); i++){
            Text day = new Text(placementCoordinateX, placementCoordinateY, daysOfWeek.get(i));
            day.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 15));
            pane.getChildren().add(day);

            placementCoordinateX += 50;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
