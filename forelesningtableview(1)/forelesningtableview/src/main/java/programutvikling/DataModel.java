package programutvikling;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DataModel {

    private SimpleStringProperty txtNavn;
    private SimpleIntegerProperty intAlder;

    public DataModel(String txtNavn, int intAlder) {
        if(intAlder < 0) {
            throw new IllegalArgumentException("intData cannot be negative");
        }

        this.txtNavn = new SimpleStringProperty(txtNavn);
        this.intAlder = new SimpleIntegerProperty(intAlder);
    }

    public String getTxtNavn() {
        return txtNavn.getValue();
    }

    public void setTxtNavn(String txtNavn) {
        this.txtNavn.set(txtNavn);
    }

    public int getIntAlder() {
        return intAlder.getValue();
    }

    public void setIntAlder(int intAlder) {
        if(intAlder < 0) {
            throw new IllegalArgumentException("intData cannot be negative");
        }

        this.intAlder.set(intAlder);
    }

}
