package programutvikling;

import javafx.scene.control.Alert;

public class IntegerStringConverter extends javafx.util.converter.IntegerStringConverter {
    public static boolean conversionSuccessful = true;

    @Override
    public Integer fromString(String s) {
        try {
            Integer result = super.fromString(s);
            conversionSuccessful = true;
            return result;
        } catch(NumberFormatException e) {
            programutvikling.gui.Dialogs.showErrorDialog("Du må taste inn et gyldig tall!");

            conversionSuccessful = false;
            return 0;
        }
    }
}