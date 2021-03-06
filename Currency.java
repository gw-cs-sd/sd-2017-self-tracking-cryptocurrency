/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////          
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/


import java.io.IOException;
import java.util.*;
import java.net.*;
import java.io.*;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class Currency implements Serializable{

 /*
/////////////////////////////////////////////////////
//////////          Globals                //////////  
/////////////////////////////////////////////////////
*/   
    Currency current;
    int curIDLength = 8; 

    String curID; 
    String sender;
    String reciever;
    ArrayList<String> notifiees = new ArrayList<String>(); 
    ArrayList<String> fullModifiers = new ArrayList<String>(); 
    ArrayList<String> partModifiers = new ArrayList<String>();
    double amount; 
    double amUsed; 
    double amLeft; 
    ArrayList<String> restrict = new ArrayList<String>(); 
    JTree transactionPath; 
    DefaultMutableTreeNode root; 
    DefaultMutableTreeNode node; 
 

 /*
/////////////////////////////////////////////////////
//////////      Constructors               //////////  
/////////////////////////////////////////////////////
*/   
    // Currency constructor
    public Currency(){

    }
 
    // Currency constructor
    public Currency(
        String senderVal, 
        String recieverVal, 
        ArrayList<String> notifieesVal, 
        double amountVal, 
        double amUsedVal, 
        ArrayList<String> restrictVal) 
    {
        sender = senderVal; 
        reciever = recieverVal; 
        notifiees = notifieesVal;
        amount = amountVal;
        amUsed = amUsedVal;
        amLeft = amount - amUsed; 
        restrict = restrictVal;
        curID = randomlyGenerateUserID(); 
        fullModifiers.add(senderVal);

        root = new DefaultMutableTreeNode(this);
        transactionPath = new JTree(root);
        node = root; 
///TEST TREE WORKS AND DATA IS ACCESSIBLE 
        // Currency temp = (Currency) root.getUserObject();
        // System.out.print(temp.sender);

        
        
    }

    // Currency constructor
    public Currency(
        String senderVal, 
        String recieverVal, 
        ArrayList<String> partModifiersVal, 
        ArrayList<String> fullModifiersVal, 
        ArrayList<String> notifieesVal, 
        double amountVal, 
        double amUsedVal, 
        ArrayList<String> restrictVal) 
    {
        sender = senderVal; 
        reciever = recieverVal; 
        notifiees = notifieesVal;
        partModifiers = partModifiersVal;
        fullModifiers = fullModifiersVal; 
        amount = amountVal;
        amUsed = amUsedVal;
        amLeft = amount - amUsed; 
        restrict = restrictVal;
        curID = randomlyGenerateUserID(); 
        fullModifiers.add(senderVal);
        partModifiers.add(senderVal);

        root = new DefaultMutableTreeNode(this);
        transactionPath = new JTree(root);
        node = root; 

    }

    // Currency constructor
    public Currency(String senderVal, 
        String recieverVal, 
        ArrayList<String> notifieesVal, 
        double amountVal, double amUsedVal, 
        ArrayList<String> restrictVal, 
        String curIdVal) 
    {
        sender = senderVal; 
        reciever = recieverVal; 
        notifiees = notifieesVal;
        amount = amountVal;
        amUsed = amUsedVal;
        amLeft = amount - amUsed; 
        restrict = restrictVal;
        curID = curIdVal; 
        fullModifiers.add(senderVal);
        partModifiers.add(senderVal);

        root = new DefaultMutableTreeNode(this);
        transactionPath = new JTree(root);
        node = root; 

    }

    // Currency constructor
    public Currency(
        String senderVal, 
        String recieverVal, 
        ArrayList<String> notifieesVal, 
        double amountVal, 
        double amUsedVal) 
    {
        sender = senderVal; 
        reciever = recieverVal; 
        amount = amountVal;
        amUsed = amUsedVal;
        amLeft = amount - amUsed; 
        curID = randomlyGenerateUserID(); 
        fullModifiers.add(senderVal);
        partModifiers.add(senderVal);

        root = new DefaultMutableTreeNode(this);
        transactionPath = new JTree(root);
        node = root; 
    }
//Used to split Currency 
    public Currency(
        String senderVal, 
        String recieverVal, 
        ArrayList<String> partModifiersVal, 
        ArrayList<String> fullModifiersVal, 
        ArrayList<String> notifieesVal, 
        double amountVal, 
        double amUsedVal, 
        ArrayList<String> restrictVal,
        DefaultMutableTreeNode parentCurrency) 
    {
        sender = senderVal; 
        reciever = recieverVal; 
        notifiees = notifieesVal;
        partModifiers = partModifiersVal;
        fullModifiers = fullModifiersVal; 
        amount = amountVal;
        amUsed = amUsedVal;
        amLeft = amount - amUsed; 
        restrict = restrictVal;
        curID = randomlyGenerateUserID(); 
        fullModifiers.add(senderVal);
        partModifiers.add(senderVal);

        root = new DefaultMutableTreeNode(this);
        transactionPath = new JTree(root);
        node = root; 

    }

    public  String randomlyGenerateUserID(){
        UserID_Generator temp = new UserID_Generator(); 
        return  temp.nextSessionId().substring(0, curIDLength);
    }

 /*
/////////////////////////////////////////////////////
//////////        SPLITING                 //////////  
/////////////////////////////////////////////////////
*/   

    //Two split currencies can be accessed through parents root 
    public void split2recievers(
        Currency original, 
        double value1, 
        String reciever1, 
        String reciever2
        )
    {
        if(value1<=original.amLeft){
            Currency split1; 
            Currency split2; 


            split1 = new Currency(
                original.reciever, 
                reciever1, 
                original.partModifiers,
                original.fullModifiers,
                original.notifiees,
                value1,
                0.0,
                original.restrict,
                original.node
            );

            split2 = new Currency(
                original.reciever, 
                reciever1, 
                original.partModifiers,
                original.fullModifiers,
                original.notifiees,
                original.amLeft - value1,
                0.0,
                original.restrict,
                original.node
            );

            original.amUsed = original.amUsed + split1.amount + split2.amount; 
            original.amLeft = original.amount - original.amUsed; 


            DefaultMutableTreeNode temp1 = new DefaultMutableTreeNode(split1);
            split1.node = temp1; 
            DefaultMutableTreeNode temp2 = new DefaultMutableTreeNode(split2);
            split1.node = temp2; 

            original.node.add(temp1);
            original.node.add(temp2);


             System.out.println("");
             System.out.println("PRINTING CURRENCY PATH ---> TWO RECIEVER SPLIT");
            DefaultMutableTreeNode temp = original.node; 
            while( temp.getNextNode() != null){
                Currency currentNode = (Currency) temp.getUserObject();
                System.out.print("CurrencyID: "+currentNode.curID + "\tCurrency Amount Left: "+currentNode.amLeft + "\n");
                temp = temp.getNextNode();
            }


            return;

            
        }else{
            System.out.println("Not enough funds to make this Split");
            return;
        }
    }

    //Two split currency can be accessed through parents root 
    public void split1reciever(
        Currency original, 
        double value1, 
        String reciever 
        )
    {
        if(value1 >original.amLeft){
            Currency split1; 
            Currency split2; 


            split1 = new Currency(
                original.reciever, 
                reciever, 
                original.partModifiers,
                original.fullModifiers,
                original.notifiees,
                value1,
                0.0,
                original.restrict,
                original.node
            );

            original.amUsed = original.amUsed + split1.amount ; 
            original.amLeft = original.amount - original.amUsed; 
            DefaultMutableTreeNode temp1 = new DefaultMutableTreeNode(split1);
            split1.node = temp1; 
            original.node.add(temp1);
            System.out.println("");
             System.out.println("PRINTING CURRENCY PATH");
            DefaultMutableTreeNode temp = root; 
            while( temp.getNextNode() != null){
                Currency currentNode = (Currency) temp.getUserObject();
                System.out.print("CurrencyID: "+currentNode.curID + "\tCurrency Amount Left: "+currentNode.amLeft + "  ==>  ");
                temp = temp.getNextNode();
            }
             System.out.println("");

            return;
            
        }else{
            System.out.println("Not enough funds to make this Split");
            return;
        }
    }


 /*
/////////////////////////////////////////////////////
//////////     ACCESSING/ SETTING DATA     //////////  
/////////////////////////////////////////////////////
*/  

//amountUsed
    public double getAmountUsed() {
        return amUsed;
    }

    public void setAmountUsed(double amUsedVal) {
        amUsed = amUsedVal;
    }

//amount 
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amountVal) {
        amount = amountVal;
    }

//amountLeft
    public double getAmountLeft() {
        return amLeft;
    }

    public void setAnmountLeft(double amLeftVal) {
        amLeft = amLeftVal;
    }

//Sender
    public String getSender() {
        return sender;
    }

    public void setSender(String senderVal) {
        sender = senderVal;
    }

//reciever 
    public String getReciever() {
        return reciever;
    }

    public void setReciever(String recieverVal) {
        reciever = recieverVal;
    }

//notifiees 
    public ArrayList<String> getNotifiees(){
        return notifiees;
    }

    public void setNotifiees(ArrayList<String> notifieesVal){
        notifiees = notifieesVal;
    }

    public void addNotifiee(String notifieeVal){
        notifiees.add(notifieeVal);
    }



 /*
/////////////////////////////////////////////////////
//////////      RESTRICTION;s              //////////  
/////////////////////////////////////////////////////
*/   
//restriction 
    public ArrayList<String> getRestriction() {
        return restrict;
    }

    public void setRestriction(ArrayList<String> restrictionVal) {
        restrict = restrictionVal;
    }
//MODIFY Restrictions
    public void modifyAddRestriction(String user, String addRestriction){
        if(partModifiers == null){
            System.out.println("User does not have permission to make this modification. ");
            return; 
        }
        boolean isPartModifier = false; 
        for(int i = 0; i< partModifiers.size(); i++){
            if(partModifiers.get(i).equals(user)){
                isPartModifier = true; 
            }
        }
        if(isPartModifier == true){
            restrict.add(addRestriction);
            System.out.println("Restriction: '" +addRestriction + "' was successfully added!");
            return;
        }else{
            System.out.println("User does not have permission to make this modification. ");
        }
        
    }

    public void modifyDeleteRestriction(String user, String deleteRestriction){
        if(fullModifiers == null){
            System.out.println("User does not have permission to make this modification. ");
            return; 
        }
        boolean isFullModifier = false; 
        for(int i = 0; i< fullModifiers.size(); i++){
            if(fullModifiers.get(i).equals(user)){
                isFullModifier = true; 
            }
        }
        if(isFullModifier == true){
            restrict.remove(deleteRestriction);
            System.out.println("Restriction: '" +deleteRestriction + "' was successfully deleted!");
            return;
        }else{
            System.out.println("User does not have permission to make this modification. ");
        }
        
    }

 /*
/////////////////////////////////////////////////////
//////////      MODIFIERS PERMISSIONS      //////////  
/////////////////////////////////////////////////////
*/   
//partModifiers 
    public ArrayList<String> getPartModifiers(){
        return partModifiers;
    }

    public void setPartModifier(ArrayList<String> partModifierVal){
        partModifiers = partModifierVal;
    }

    public void addPartModifier(String partModifierVal){
        partModifiers.add(partModifierVal);
    }

//fullModifiers 
    public ArrayList<String> getFullModifiers(){
        return fullModifiers;
    }

    public void setFullModifier(ArrayList<String> fullModifierVal){
        fullModifiers = fullModifierVal;
    }

    public void addFullModifier(String fullModifierVal){
        fullModifiers.add(fullModifierVal);
    }



    public static void main(String[] args) {
        Currency testCurrency4 = new Currency(
            "sender4", 
            "testReciever10", 
            new ArrayList<String> (),
            500.00,
            0.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines"))
            
        );



        return; 
    }
}
