package com.example.creditcard;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

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
    private Label averageLabel;

    @javafx.fxml.FXML
    public void initialize() {
        cardTypeComboBox.getItems().addAll("Silver",
                "Gold",
                "Platinum",
                "titanium");
        gatewayNameComboBox.getItems().addAll("Visa",
                "Master Card");
        searchGatewayNameComboBox.getItems().addAll("Visa",
                "Master Card");
        cardNoCol.setCellValueFactory(new PropertyValueFactory<>("cardNo"));
        holderNameCol.setCellValueFactory(new PropertyValueFactory<>("holderName"));
        gatewayNameCol.setCellValueFactory(new PropertyValueFactory<>("gatewayName"));
        creditLimitCol.setCellValueFactory(new PropertyValueFactory<>("creditLimit"));
    }
    ArrayList<CreditCard> cardList = new ArrayList<>();
    @javafx.fxml.FXML
    public void handleSearchButton(ActionEvent actionEvent) {
        String selectedGateway = searchGatewayNameComboBox.getValue();
        String minLimitText = searchCreditLimitTextField.getText().trim();
        if(selectedGateway==null||minLimitText.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Plz fill up all fields");
            alert.show();
            return;
        }
        double minlimit;
        try{
            minlimit=Double.parseDouble(minLimitText);
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Min credit limit must be a valid number!");
            alert.show();
            return;
        }
        creditCardTableView.getItems().clear();
        for(CreditCard card: cardList){
            if(card.getGatewayName().equals(selectedGateway)&&card.getCreditLimit()>=minlimit){
                creditCardTableView.getItems().add(card);
            }
        }
        if(creditCardTableView.getItems().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No matching credit cards found");
            alert.show();
        }
    }

    @javafx.fxml.FXML
    public void handleShowAvrgButton(ActionEvent actionEvent) {
    if(creditCardTableView.getItems().isEmpty()){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("No cards loaded in TableView!");
        alert.show();
        return;
    }
    double sum =0 ;
    for (CreditCard card : creditCardTableView.getItems()){
        sum+=card.getCreditLimit();
    }
    double average = sum/creditCardTableView.getItems().size();
    averageLabel.setText("Average Credit Limit: "+average);
    }

    @javafx.fxml.FXML
    public void handleValidateButton(ActionEvent actionEvent) {
    String cardNo = cardNoTextField.getText().trim();
    String holderName = holderNameTextField.getText().trim();
    String creditLimitText = creditLimitTextField.getText().trim();
    String cardType = cardTypeComboBox.getValue();
    String gatewayName = gatewayNameComboBox.getValue();
    LocalDate dateOfExpiry = dateOfExpiryDatePicker.getValue();
    if(cardNo.isEmpty()||holderName.isEmpty()||gatewayName==null||cardType==null||creditLimitText.isEmpty()||dateOfExpiryDatePicker.getValue()==null){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Plz fill up all fields");
        alert.show();
        return;
    }
    if(!cardNo.matches("\\d{16}")){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Card number must be exactly 16 digits!");
        alert.show();
        return;
    }
    if(gatewayName.equals("Visa")&&!cardNo.startsWith("4")){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Visa card number must start with 4");
        alert.show();
        return;
    }
    if(gatewayName.equals("Master Card")&&!cardNo.startsWith("5")){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("master Card number must start with 5!");
        alert.show();
        return;
    }
    double creditLimit;
    try{
        creditLimit=Double.parseDouble(creditLimitText);
    }catch (NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText("Credit Limit must be a valid number!");
        alert.show();
        return;
    }
    CreditCard newCard = new CreditCard(cardNo,holderName,dateOfExpiry,gatewayName,creditLimit,cardType);
    cardList.add(newCard);
    creditCardTableView.getItems().clear();
    creditCardTableView.getItems().addAll(cardList);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setContentText("Credit Card Added successfully!");
    alert.show();
    //return;
    }
}