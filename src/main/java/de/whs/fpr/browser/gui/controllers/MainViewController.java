package de.whs.fpr.browser.gui.controllers;

import de.whs.fpr.browser.data.ClassBrowser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Main view controller.
 *
 * Responsible for handling the main view of the application.
 *
 * @author Frederik Bußmann
 */
public class MainViewController {
    /**
     * The input for the class name.
     */
    @FXML
    protected TextField classNameInput;

    /**
     * The input for the package name of the class.
     */
    @FXML
    protected TextField packageNameInput;

    /**
     * The submit button instance.
     */
    @FXML
    protected Button submitButton;

    /**
     * The output label instance.
     */
    @FXML
    protected Label outputLabel;

    /**
     * The class browser instance.
     */
    private ClassBrowser browser;

    /**
     * Initializes the main view.
     */
    @FXML
    protected void initialize() {
        browser = new ClassBrowser();
    }

    /**
     * Called on submit button clicked.
     */
    @FXML
    protected void onSubmitButtonClick() {
        String className = classNameInput.getText();
        String packageName = packageNameInput.getText();

        browser.search(packageName + "." + className);

        outputLabel.setText(browser.classDataToString());
    }
}
