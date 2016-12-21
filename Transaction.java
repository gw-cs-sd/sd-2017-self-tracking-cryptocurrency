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
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.util.*;

public class Transaction {
    
    public static boolean attemptTransaction(Currency currency, Request request){
        //Check to see if the requester has the permission to be a spender of the currency 
        if(currency.reciever.equals(request.userID)){
            System.out.println("Authorized User!!! Continuing to verfiy fund use....");
        }else{
            System.out.println("User is not authorized to spend funds.... \n 
                XXXXXXXXXXXXXXXXXXXX Transaction DENIED XXXXXXXXXXXXXXXXXXXX");
            return false; 
        }

        //Check to see if there are funds avaliable 
        if(checkAmAvali(currency.amLeft, request.amount)){
            System.out.println("Sufficient Funds avaliable!!! Continuing to verfiy fund use....");

            //If there are funds avaliable check to see if the request meets the restrictions 
            int checkRestriction = checkRestriction(currency.restrict, request.restrict);
            if(checkRestriction == 1){
                executeTransaction(currency, request);
                System.out.println("Valid transaction... !!!!!!!!!!!!!!!! Transaction APPROVED !!!!!!!!!!!!!!!! ");
                System.out.println("\t$"+currency.amLeft + " funds are left for this currency with the following restrictions: ");
                System.out.println("\t\t"+ currency.restrict);
                 
                return true; 
            }else{// Funds are not being used as restricted 
                System.out.println("Invalid use of funds... XXXXXXXXXXXXXXXXXXXX Transaction DENIED XXXXXXXXXXXXXXXXXXXX");
                System.out.println("\t Restriction path REQUIRED for these funds is:");
                System.out.println("\t \t" + currency.restrict);
                System.out.println("\t Restriction path REQUESTED for this transaction: ");
                System.out.println("\t\t"+ request.restrict);
                if(checkRestriction == -2){
                    System.out.println("\t\tRequest was NOT along the required path!");
                }else{
                    System.out.println("\t\tRequest was NOT specific enough in its restriction. ");
                }
                return false;
            }
        }else{//Not enough funds are avaliable 
            System.out.println("Insufficient funds... XXXXXXXXXXXXXXXXXXXX Transaction DENIED XXXXXXXXXXXXXXXXXXXX");
            System.out.println("\t Funds avaliable to spend: $" + currency.amLeft);
            System.out.println("\t Funds requested: $"+ request.amount);
            double amountNeeded = request.amount - currency.amLeft;
            System.out.println("\t Need $" + amountNeeded + " to execute transaction request.");
            return false; 
        }
    }

    public static int checkRestriction(ArrayList<String> allocatorRestriction, ArrayList<String> requestCategory){
        //-1 means that the request is not specific enough
        //-2 means that the request is down the wrong path
        //1 means the request is valid 
        if(requestCategory.size() < allocatorRestriction.size()){
            return -1; 
        }
        for(int i =0; i< allocatorRestriction.size(); i++){
            if( (allocatorRestriction.get(i).equals(requestCategory.get(i)) ) == false){
                return -2; 
            }
        }
        return 1; 

    }

    public static boolean checkAmAvali(double avaliFunds, double requestAm){
        double temp = avaliFunds-requestAm; 
        if(temp >= 0){
            return true; 
        }else{
            return false; 
        }
    }

    public static void executeTransaction(Currency currency, Request request){
        //update value left in currency 
        currency.amLeft = currency.amLeft - request.amount; 

        //Send notifications to designate notifiees 
        return ; 
    }

    public static void main(String[] args) {
        System.out.println();
        RestrictiveTree current = new RestrictiveTree(); 

    //Test Number 1 -- Should be valid -- Does not use all of the funds 
        System.out.println("********************************************************************");
        System.out.println("*********************** TRANSACTION ONE TEST ***********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be valid -- Should have $40.00 left after request///");
        System.out.println();

        Currency testCurrency = new Currency(
            "sender1", 
            "testReciever", 
            new ArrayList<String> (),
            100.00,
            10.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
            "currency1"
        );

        Request testRequest = new Request(
            "testReciever",
            testCurrency,
            50.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines"))
        );

        attemptTransaction(testCurrency, testRequest);


    //Test Number 2 -- Should be valid -- continuation of first test -- should use all of the funds 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("*********************** TRANSACTION TWO TEST ***********************");
        System.out.println("********************************************************************");
        System.out.println("///Should be valid -- Testing second request on same currency 
            -- should have $0.0 funds after///");
        System.out.println();

        Request testRequest2 = new Request(
            "testReciever",
            testCurrency,
            40.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines"))
        );

        attemptTransaction(testCurrency, testRequest2);

    //Test Number 3 -- Should have insufficient funds -- zero funds avaliable -- continuation of first two 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************** TRANSACTION THREE TEST **********************");
        System.out.println("********************************************************************"); 
        System.out.println("///Should have insufficient funds -- 
            funds were used by the previous two transactions///");
        System.out.println();

        attemptTransaction(testCurrency, testRequest2);

    //Test Number 4 -- Should have insufficient funds -- funds avaliable but the request costs more -- new 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("*********************** TRANSACTION FOUR TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("///Should have insufficient funds -- funds are avalibale, but the request costs more///");
        System.out.println();

        Currency testCurrency1 = new Currency(
            "sender2", 
            "testReciever1", 
            new ArrayList<String> (),
            100.00,
            0.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
            "currency1"
        );

        Request testRequest3 = new Request(
            "testReciever1",
            testCurrency1,
            120.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines"))
        );

        attemptTransaction(testCurrency1, testRequest3);

    //Test Number 5 -- Should have invalid restriction -- allocator further restricted than what the requestor specified 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************** TRANSACTION FIVE TEST ***********************");
        System.out.println("********************************************************************");
        System.out.println("///Should have invalid restriction -- the allocator made more 
            specific restrictions \n ///than what the requestor specified ///");
        System.out.println();

        Currency testCurrency2 = new Currency(
            "sender3", 
            "testReciever2", 
            new ArrayList<String> (),
            500.00,
            0.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
            "currency1"
        );

        Request testRequest4 = new Request(
            "testReciever2",
            testCurrency2,
            120.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment"))
        );

        attemptTransaction(testCurrency2, testRequest4);

    //Test Number 6 -- Should have invalid restriction -- paths do not match 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("*********************** TRANSACTION SIX TEST ***********************");
        System.out.println("********************************************************************");
        System.out.println("///Should have invalid restriction -- 
            path of allocation and request do NOT match ///");
        System.out.println();

        Currency testCurrency3 = new Currency(
            "sender4", 
            "testReciever3", 
            new ArrayList<String> (),
            500.00,
            0.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
            "currency1"
        );

        Request testRequest5 = new Request(
            "testReciever3",
            testCurrency3,
            120.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","donations", "admin"))
        );

        attemptTransaction(testCurrency3, testRequest5);

    //Test number 7 -- Should have invalid requestor 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************** TRANSACTION SEVEN TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be invlaid -- Invalid Requestor ///");
        System.out.println();

        Currency testCurrency4 = new Currency(
            "sender4", 
            "testReciever10", 
            new ArrayList<String> (),
            500.00,
            0.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree","entertainment","newspaperMagazines")),
            "currency1"
        );

        Request testRequest6 = new Request(
            "testReciever323424",
            testCurrency4,
            120.00,
            new ArrayList<String> (Arrays.asList("Restrictive Tree" ))
        );

        attemptTransaction(testCurrency4, testRequest6);

     //Test number 8 -- The ability to modify a currencies restrictions 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************** TRANSACTION EIGHT TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be valid  -- the modifier is the original allocator ///");
        System.out.println();
       // testCurrency4.addPartModifier("sender4");

        testCurrency4.modifyAddRestriction("sender4", "donations");


    //Test number 9 -- The ability to modify a currencies restrictions 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************** TRANSACTION NINE TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be invalid  -- the modifier is NOT the original allocator 
            or a designated modifer///");
        System.out.println();

        testCurrency4.modifyAddRestriction("sender5", "admin");

    //Test number 10 -- The ability to modify a currencies restrictions 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("*********************** TRANSACTION TEN TEST ***********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be invalid  -- the modifier is NOT the original allocator, 
            BUT is a designated partialModifier \n  however, designated partialModifiers can only f
            urther restrict funds ///");
        System.out.println();

        testCurrency4.addPartModifier("SenderPartial");
        testCurrency4.modifyDeleteRestriction("SenderPartial", "donations");

    //Test number 11 -- The ability to modify a currencies restrictions 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************* TRANSACTION ELEVEN TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be VALID  -- the modifier is NOT the original allocator, BUT 
            is a designated partialModifier --  designated partialModifiers can 
            only further restrict funds ///");
        System.out.println();

        testCurrency4.addPartModifier("Sender5");
        testCurrency4.modifyAddRestriction("Sender5", "admin");



    //Test number 12 -- The ability to modify a currencies restrictions 
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println("********************* TRANSACTION TWELEVE TEST **********************");
        System.out.println("********************************************************************");
        System.out.println("/// Should be VALID  -- the modifier is NOT the original allocator, 
            BUT is a designated fullModifier ///");
        System.out.println();

        testCurrency4.addFullModifier("SenderFullAccess");
        testCurrency4.modifyDeleteRestriction("SenderFullAccess", "admin");

        return;

    }
}