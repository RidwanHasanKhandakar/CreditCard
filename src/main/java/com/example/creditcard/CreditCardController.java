package com.example.creditcard;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class CreditCardController
{
    @javafx.fxml.FXML
    private TextField cardNoTextField;
    @javafx.fxml.FXML
    private TableColumn <CreditCard,String> holderNameCol;
    @javafx.fxml.FXML
    private TableColumn <CreditCard,String> gatewayNameCol;
    @javafx.fxml.FXML
    private TextField creditLimitTextField;
    @javafx.fxml.FXML
    private DatePicker dateOfExpiryDatePicker;
    @javafx.fxml.FXML
    private TableView <CreditCard> creditCardTableView;
    @javafx.fxml.FXML
    private TextField holderNameTextField;
    @javafx.fxml.FXML
    private TableColumn <CreditCard,Double> creditLimitCol;
    @javafx.fxml.FXML
    private TextField searchCreditLimitTextField;
    @javafx.fxml.FXML
    private ComboBox <String> cardTypeComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> gatewayNameComboBox;
    @javafx.fxml.FXML
    private ComboBox <String> searchGatewayNameComboBox;
    @javafx.fxml.FXML
    private TableColumn <CreditCard,String> cardNoCol;

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