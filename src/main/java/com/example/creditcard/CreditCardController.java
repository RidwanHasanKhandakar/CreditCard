package com.example.creditcard;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreditCardController
{
    @javafx.fxml.FXML
    private TextField cardNoTextField;
    @javafx.fxml.FXML
    private TableColumn holderNameCol;
    @javafx.fxml.FXML
    private TableColumn gatewayNameCol;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfExpiryDatePicker;
    @javafx.fxml.FXML
    private TableView creditCardTableView;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TableColumn creditLimitCol;
    @javafx.fxml.FXML
    private TextField searchCreditLimitTextField;
    @javafx.fxml.FXML
    private ComboBox cardTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox gatewayNameComboBox;
    @javafx.fxml.FXML
    private ComboBox searchGatewayNameComboBox;
    @javafx.fxml.FXML
    private TableColumn cardNoCol;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleShowAvrgButton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleValidateButton(ActionEvent actionEvent) {
    }
}