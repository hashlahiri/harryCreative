package sample;

import java.time.LocalDate;

public class LocalEvent { //when clicked launch this part
    private String description;
    private LocalDate date;

    public LocalEvent(String description, LocalDate date) { //constructor for initialization
        this.description = description;
        this.date = date;
    }

    public String getDescription() { //getters
        return description;
    }

    public void setDescription(String description) { //setters
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString(){ //display this string in the list
        return "On: "+this.getDate()+". "+this.getDescription();
    }
}
