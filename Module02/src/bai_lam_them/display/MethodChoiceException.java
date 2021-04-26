package bai_lam_them.display;

import bai_lam_them.display.IllegalChoiceException;

public class MethodChoiceException {
    public static void choiceMenu(int choice) throws IllegalChoiceException {
        if (choice < 1) {
            throw new IllegalChoiceException(choice);
        }
        if (choice > 4) {
            throw new IllegalChoiceException(choice);
        }
    }
}
