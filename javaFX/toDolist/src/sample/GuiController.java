package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class GuiController implements Initializable { //uses the interface

    @Override
    public void initialize(URL url, ResourceBundle rb){ //here we set value to current date, part that's run first
        datePicker.setValue(LocalDate.now());
    }
    @FXML
    Button addButton; //adding in the buttons
    @FXML
    Button deleteButton; //delete button
    @FXML
    TextField descriptionTextField;  //adding in the description fields
    @FXML
    TextField deleteItemTextField;
    @FXML
    DatePicker datePicker;  //adding in the date picker
    @FXML
    ListView<LocalEvent> eventList; //creating a list view of type localevent (when clicked)

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();  //creating the list where items are stored

    @FXML
    private void addEvent(Event e){  //upon add event button press/click
        list.add(new LocalEvent(descriptionTextField.getText(), datePicker.getValue()));  //add the data into list
        eventList.setItems(list); //send the updated list
        refresh(); //refresh the software/list
    }
    @FXML
    private void delEvent(Event e){ //upon delete event button press/click
        if(list.size()<=0) //checks if the list is empty or not
            System.out.println("Empty list"); //print if empty
        else {
            //list.remove(list.size() - 1); //else delete the last entry in the list
            String item = deleteItemTextField.getText(); //get the item number to remove
            list.remove(Integer.parseInt(item)-1); //deletes that entry according to array list
        }
        refresh();
    }

    private void refresh() { //basically resetting the fields
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
        deleteItemTextField.setText(null);
    }
}
