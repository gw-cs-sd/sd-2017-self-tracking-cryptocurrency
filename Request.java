/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////
////////// Last Updated: Nov. 30, 2016     //////////           
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/


import java.io.IOException;
import java.util.*;

public class Request {

    Request request;

    String userID; 
    Currency currencyID;
    double amount; 
    ArrayList<String> restrict; 

    //Request constructor 
    public Request(){

    }

    // Request constructor
    public Request(String userIDVal, Currency currency,  double amountVal, ArrayList<String> restrictVal) {
        userID = userIDVal;
        currencyID = currency; 
        amount = amountVal;
        restrict = restrictVal;
    }

//currency
    public Currency getCurrency() {
        return currencyID;
    }

    public void setCurrency(Currency currency) {
        currencyID = currency;
    }

//amount 
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amountVal) {
        amount = amountVal;
    }


//restriction 
    public ArrayList<String> getRestriction() {
        return restrict;
    }

    public void setRestriction(ArrayList<String> restrictionVal) {
        restrict = restrictionVal;
    }


    public static void main(String[] args) {
        
    }
}
