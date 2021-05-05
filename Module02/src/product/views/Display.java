package product.views;

import product.controllers.MainController;
import product.exception.IdNotFoundException;

public class Display {
    public static void main(String[] args) throws IdNotFoundException {
        MainController.menu();
    }
}
