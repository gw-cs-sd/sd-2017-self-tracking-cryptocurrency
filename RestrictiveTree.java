/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from thiszA PARTICULAR
 * A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/ 

/*
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
////////// Abigail H. Shriver              //////////  
////////// CSci 4243 Senior Design Project //////////  
////////// Self-Tracking E-currency        //////////
////////// Last Updated: Nov. 16, 2016     //////////           
/////////////////////////////////////////////////////
/////////////////////////////////////////////////////
*/



import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class RestrictiveTree extends JPanel implements TreeSelectionListener {
    public JTree tree;
    DefaultMutableTreeNode root; 
    private static boolean DEBUG = false;

    //Optionally play with line styles.  Possible values are
    //"Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";
    
    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

    public RestrictiveTree() {
        super(new GridLayout(1,0));

        //Create the nodes.
        root = new DefaultMutableTreeNode("Restrictive Tree");
        createNodes(root);

        //Create a tree that allows one selection at a time.
        tree = new JTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        //Create the scroll pane and add the tree to it. 
        JScrollPane treeView = new JScrollPane(tree);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);

        Dimension minimumSize = new Dimension(100, 50);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100); 
        splitPane.setPreferredSize(new Dimension(500, 300));

        //Add the split pane to this panel.
        add(splitPane);
/*
        System.out.println("This is a test that the tree works.........");
        DefaultMutableTreeNode current = root;
        System.out.println(current.toString());
*/

    }

    public DefaultMutableTreeNode getRoot(){
        return root; 
    }

    /** Required by TreeSelectionListener interface. */
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                           tree.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
       
        if (DEBUG) {
            System.out.println(nodeInfo.toString());
        }
    }


    /*
     /////////////////////////////////////////////////////
     /////////////////////////////////////////////////////
     ///        ADD FIRST DEGREE OF CHILDREN           ///
     /////////////////////////////////////////////////////
     /////////////////////////////////////////////////////
    */

        public static void createNodes(DefaultMutableTreeNode root){
            /* 
             * *** MAIN CHILDREN ***
             * Uncatogorized, Entertainment, Education, Shopping, Personal Care
             * Health_Fitness, Kids, Food_Dining, Gifts, Dontations, Investments, Bills_Utilities
             * Auto_Transportation, Travel, Fees_Charges, Business Services, Taxes
            */

            DefaultMutableTreeNode entertainment = new DefaultMutableTreeNode("entertainment");
            root.add(entertainment);
            addEntertainmentSubcategories(entertainment);

            DefaultMutableTreeNode education = new DefaultMutableTreeNode("education"); 
            root.add(education);        
            addEducationSubcategories(education);
            
            DefaultMutableTreeNode shopping =  new DefaultMutableTreeNode("shopping"); 
            root.add(shopping);
            addShoppingSubcategories(shopping);

            DefaultMutableTreeNode technology =  new DefaultMutableTreeNode("technology"); 
            root.add(technology);
            addTechnologySubcategories(technology);
            
            DefaultMutableTreeNode personalCare =  new DefaultMutableTreeNode("personalCare"); 
            root.add(personalCare);
            addPersonalCareSubcategories(personalCare);
            
            DefaultMutableTreeNode healthFitness =  new DefaultMutableTreeNode("healthFitness"); 
            root.add(healthFitness);
            addHealthFitnessSubcategories(healthFitness);

            DefaultMutableTreeNode kids =  new DefaultMutableTreeNode("kids"); 
            root.add(kids);
            addKidsSubcategories(kids);

            DefaultMutableTreeNode foodDining =  new DefaultMutableTreeNode("foodDining"); 
            root.add(foodDining);
            addFoodDiningSubcategories(foodDining);

            DefaultMutableTreeNode gifts =  new DefaultMutableTreeNode("gifts"); 
            root.add(gifts);
            addGiftsSubcategories(gifts);

            DefaultMutableTreeNode donations  =  new DefaultMutableTreeNode("donations"); 
            root.add(donations);
            addDonationsSubcategories(donations);

            DefaultMutableTreeNode investments =  new DefaultMutableTreeNode("investments"); 
            root.add(investments);
            addInvestmentsSubcategories(investments);

            DefaultMutableTreeNode billsUtilities =  new DefaultMutableTreeNode("billsUtilities"); 
            root.add(billsUtilities);
            addBillsUtilitiesSubcategories(billsUtilities);

            DefaultMutableTreeNode autoTransportation =  new DefaultMutableTreeNode("autoTransportation"); 
            root.add(autoTransportation);
            addAutoTransportationSubcategories(autoTransportation);

            DefaultMutableTreeNode travel =  new DefaultMutableTreeNode("travel"); 
            root.add(travel);
            addTravelSubcategories(travel);

            DefaultMutableTreeNode feesAndCharges =  new DefaultMutableTreeNode("feesAndCharges"); 
            root.add(feesAndCharges);
            addFeesChargesSubcategories(feesAndCharges);

            DefaultMutableTreeNode businessServices =  new DefaultMutableTreeNode("businessServices"); 
            root.add(businessServices);
            addBusinessServicesSubcategories(businessServices);

            DefaultMutableTreeNode taxes =  new DefaultMutableTreeNode("taxes"); 
            root.add(taxes);
            addBusinessServicesSubcategories(taxes);

            return;
        }

    /*
     /////////////////////////////////////////////////////
     /////////////////////////////////////////////////////
     ///        ADD SECOND DEGREE OF CHILDREN          ///
     /////////////////////////////////////////////////////
     /////////////////////////////////////////////////////
    */
        public static void addEntertainmentSubcategories(DefaultMutableTreeNode entertainment){
            //Arts, Music, Movies_DVDs, NewspaperMagazines
            DefaultMutableTreeNode arts =  new DefaultMutableTreeNode("arts");
            entertainment.add(arts);

            DefaultMutableTreeNode music =  new DefaultMutableTreeNode("music");
            entertainment.add(music);

            DefaultMutableTreeNode movies =  new DefaultMutableTreeNode("movies");
            entertainment.add(movies);

            DefaultMutableTreeNode newspaperMagazines =  new DefaultMutableTreeNode("newspaperMagazines");
            entertainment.add(newspaperMagazines);

            return;
        }

        public static void addEducationSubcategories(DefaultMutableTreeNode education){
            //Tuition, StudentLoans, Books, Supplies
            DefaultMutableTreeNode tuition =  new DefaultMutableTreeNode("tuition");
            education.add(tuition);

            DefaultMutableTreeNode studentLoans =  new DefaultMutableTreeNode("studentLoans");
            education.add(studentLoans);

            DefaultMutableTreeNode books =  new DefaultMutableTreeNode("books");
            education.add(books);

            DefaultMutableTreeNode supplies =  new DefaultMutableTreeNode("supplies");
            education.add(supplies);

            return;
        }
        
        public static void addShoppingSubcategories(DefaultMutableTreeNode shopping){
            //Clothing, Books, hobbies, sportingGoods
            DefaultMutableTreeNode clothing =  new DefaultMutableTreeNode("clothing");
            shopping.add(clothing);

            DefaultMutableTreeNode books =  new DefaultMutableTreeNode("books");
            shopping.add(books);

            DefaultMutableTreeNode hobbies =  new DefaultMutableTreeNode("hobbies");
            shopping.add(hobbies);

            DefaultMutableTreeNode sportingGoods =  new DefaultMutableTreeNode("sportingGoods");
            shopping.add(sportingGoods);
            
            return;
        }

        public static void addTechnologySubcategories(DefaultMutableTreeNode technology){
            //Software, products, electronics, 
            DefaultMutableTreeNode software =  new DefaultMutableTreeNode("software");
            technology.add(software);

            DefaultMutableTreeNode products =  new DefaultMutableTreeNode("products");
            technology.add(products);

            DefaultMutableTreeNode electronics =  new DefaultMutableTreeNode("electronics");
            technology.add(electronics);

            return;
        }

        public static void addPersonalCareSubcategories(DefaultMutableTreeNode personalCare){
            //Laundry, Hair, Spa_Massage, Sports
            DefaultMutableTreeNode laundry =  new DefaultMutableTreeNode("laundry");
            personalCare.add(laundry);

            DefaultMutableTreeNode hair =  new DefaultMutableTreeNode("hair");
            personalCare.add(hair);

            DefaultMutableTreeNode spaMassage =  new DefaultMutableTreeNode("spaMassage");
            personalCare.add(spaMassage);

            DefaultMutableTreeNode sports =  new DefaultMutableTreeNode("sports");
            personalCare.add(sports);

            return;
        }

        public static void addHealthFitnessSubcategories(DefaultMutableTreeNode healthFitness){
            //Dentist, Doctor, eyecare, pharmacy, healthInsurance, Gym, sports
            DefaultMutableTreeNode dentist =  new DefaultMutableTreeNode("dentist");
            healthFitness.add(dentist);

            DefaultMutableTreeNode doctor =  new DefaultMutableTreeNode("doctor");
            healthFitness.add(doctor);

            DefaultMutableTreeNode eyecare =  new DefaultMutableTreeNode("eyecare");
            healthFitness.add(eyecare);

            DefaultMutableTreeNode pharmacy =  new DefaultMutableTreeNode("pharmacy");
            healthFitness.add(pharmacy);

            DefaultMutableTreeNode healthInsurance =  new DefaultMutableTreeNode("healthInsurance");
            healthFitness.add(healthInsurance);

            DefaultMutableTreeNode gym =  new DefaultMutableTreeNode("gym");
            healthFitness.add(gym);

            DefaultMutableTreeNode sports =  new DefaultMutableTreeNode("sports");
            healthFitness.add(sports);

            return;
        }

        public static void addKidsSubcategories(DefaultMutableTreeNode kids){
            //activities, allowance, babySupplies, Babysitter, Daycare, ChildSupport, Toys
            DefaultMutableTreeNode activities =  new DefaultMutableTreeNode("activities");
            kids.add(activities);

            DefaultMutableTreeNode allowance =  new DefaultMutableTreeNode("allowance");
            kids.add(allowance);

            DefaultMutableTreeNode babySupplies =  new DefaultMutableTreeNode("babySupplies");
            kids.add(babySupplies);

            DefaultMutableTreeNode babysitter = new DefaultMutableTreeNode("babysitter");
            kids.add(babysitter);

            DefaultMutableTreeNode daycare =  new DefaultMutableTreeNode("daycare");
            kids.add(daycare);

            DefaultMutableTreeNode childSupport =  new DefaultMutableTreeNode("childSupport");
            kids.add(childSupport);

            DefaultMutableTreeNode toys =  new DefaultMutableTreeNode("toys");
            kids.add(toys);

            return;
        }

        public static void addFoodDiningSubcategories(DefaultMutableTreeNode foodDining){
            //Groceries, Coffee, FastFood, Restaurants, AlcoholBars
            DefaultMutableTreeNode groceries =  new DefaultMutableTreeNode("groceries");
            foodDining.add(groceries);

            DefaultMutableTreeNode coffee =  new DefaultMutableTreeNode("coffee");
            foodDining.add(coffee);

            DefaultMutableTreeNode fastFood =  new DefaultMutableTreeNode("fastFood");
            foodDining.add(fastFood);

            DefaultMutableTreeNode restaurants =  new DefaultMutableTreeNode("restaurants");
            foodDining.add(restaurants);

            DefaultMutableTreeNode alcoholBars =  new DefaultMutableTreeNode("alcoholBars");
            foodDining.add(alcoholBars);

            return;
        }

        public static void addGiftsSubcategories(DefaultMutableTreeNode gifts){
            //Gifts, Toys, Cash
            DefaultMutableTreeNode gifts1 =  new DefaultMutableTreeNode("gifts");
            gifts.add(gifts1);

            DefaultMutableTreeNode toys =  new DefaultMutableTreeNode("toys");
            gifts.add(toys);

            DefaultMutableTreeNode cash =  new DefaultMutableTreeNode("cash");
            gifts.add(cash);

            return;
        }

        public static void addDonationsSubcategories(DefaultMutableTreeNode donations){
            //admin, projects
            DefaultMutableTreeNode admin =  new DefaultMutableTreeNode("admin");
            donations.add(admin);

            DefaultMutableTreeNode projects =  new DefaultMutableTreeNode("projects");
            donations.add(projects);
            
            return;
        }

        public static void addInvestmentsSubcategories(DefaultMutableTreeNode investments){
            //deposit, withdraw, divideds, buy, sell
            DefaultMutableTreeNode deposit =  new DefaultMutableTreeNode("deposit");
            investments.add(deposit);

            DefaultMutableTreeNode withdraw =  new DefaultMutableTreeNode("withdraw");
            investments.add(withdraw);

            DefaultMutableTreeNode divideds =  new DefaultMutableTreeNode("divideds");
            investments.add(divideds);

            DefaultMutableTreeNode buy =  new DefaultMutableTreeNode("buy");
            investments.add(buy);

            DefaultMutableTreeNode sell =  new DefaultMutableTreeNode("sell");
            investments.add(sell);
            
            return;
        }

        public static void addBillsUtilitiesSubcategories(DefaultMutableTreeNode billsUtilities){
            //Cabel, home, cell, internet, utilities, water, sewage, electric, insurance 
            DefaultMutableTreeNode cabel =  new DefaultMutableTreeNode("cabel");
            billsUtilities.add(cabel);

            DefaultMutableTreeNode home =  new DefaultMutableTreeNode("home");
            billsUtilities.add(home);

            DefaultMutableTreeNode cell =  new DefaultMutableTreeNode("cell");
            billsUtilities.add(cell);

            DefaultMutableTreeNode internet =  new DefaultMutableTreeNode("internet");
            billsUtilities.add(internet);

            DefaultMutableTreeNode utilities =  new DefaultMutableTreeNode("utilities");
            billsUtilities.add(utilities);

            DefaultMutableTreeNode water =  new DefaultMutableTreeNode("water");
            billsUtilities.add(water);

            DefaultMutableTreeNode sewage =  new DefaultMutableTreeNode("sewage");
            billsUtilities.add(sewage);

            DefaultMutableTreeNode electric =  new DefaultMutableTreeNode("electric");
            billsUtilities.add(electric);

            DefaultMutableTreeNode insurance =  new DefaultMutableTreeNode("insurance");
            billsUtilities.add(insurance);

            
            return;
        }

        public static void addAutoTransportationSubcategories(DefaultMutableTreeNode transportation){
            //Gas, Parking, Services, payments, insurance
            DefaultMutableTreeNode gas =  new DefaultMutableTreeNode("gas");
            transportation.add(gas);

            DefaultMutableTreeNode parking =  new DefaultMutableTreeNode("parking");
            transportation.add(parking);

            DefaultMutableTreeNode services =  new DefaultMutableTreeNode("services");
            transportation.add(services);

            DefaultMutableTreeNode payments =  new DefaultMutableTreeNode("payments");
            transportation.add(payments);

            DefaultMutableTreeNode insurance =  new DefaultMutableTreeNode("insurance");
            transportation.add(insurance);

            return;
        }

        public static void addTravelSubcategories(DefaultMutableTreeNode travel){
            //buisness, personal, hotel, rental, vacation, air, train, bus, metro, publicTransportation
            DefaultMutableTreeNode buisness =  new DefaultMutableTreeNode("buisness");
            travel.add(buisness);

            DefaultMutableTreeNode personal =  new DefaultMutableTreeNode("personal");
            travel.add(personal);

            DefaultMutableTreeNode hotel =  new DefaultMutableTreeNode("hotel");
            travel.add(hotel);

            DefaultMutableTreeNode rental =  new DefaultMutableTreeNode("rental");
            travel.add(rental);

            DefaultMutableTreeNode vacation =  new DefaultMutableTreeNode("vacation");
            travel.add(vacation);

            DefaultMutableTreeNode air =  new DefaultMutableTreeNode("air");
            travel.add(air);

            DefaultMutableTreeNode train =  new DefaultMutableTreeNode("train");
            travel.add(train);

            DefaultMutableTreeNode bus =  new DefaultMutableTreeNode("bus");
            travel.add(bus);

            DefaultMutableTreeNode metro =  new DefaultMutableTreeNode("metro");
            travel.add(metro);

            DefaultMutableTreeNode publicTransportation =  new DefaultMutableTreeNode("publicTransportation");
            travel.add(publicTransportation);
            
            return;
        }

        public static void addFeesChargesSubcategories(DefaultMutableTreeNode feesAndCharges){
            //service, late, financeCharge, atmFee, bankFee, annualFees, tradeComissions
            DefaultMutableTreeNode service =  new DefaultMutableTreeNode("service");
            feesAndCharges.add(service);

            DefaultMutableTreeNode late =  new DefaultMutableTreeNode("late");
            feesAndCharges.add(late);

            DefaultMutableTreeNode financeCharge =  new DefaultMutableTreeNode("financeCharge");
            feesAndCharges.add(financeCharge);

            DefaultMutableTreeNode atmFee =  new DefaultMutableTreeNode("atmFee");
            feesAndCharges.add(atmFee);

            DefaultMutableTreeNode bankFee =  new DefaultMutableTreeNode("bankFee");
            feesAndCharges.add(bankFee);

            DefaultMutableTreeNode annualFees =  new DefaultMutableTreeNode("annualFees");
            feesAndCharges.add(annualFees);

            DefaultMutableTreeNode tradeComissions =  new DefaultMutableTreeNode("tradeComissions");
            feesAndCharges.add(tradeComissions);

            return;
        }

        public static void addBusinessServicesSubcategories(DefaultMutableTreeNode businessServices){
            //Advertising, officeSupplies, Printing, Shipping, Legal
            DefaultMutableTreeNode advertising =  new DefaultMutableTreeNode("advertising");
            businessServices.add(advertising);

            DefaultMutableTreeNode officeSupplies =  new DefaultMutableTreeNode("officeSupplies");
            businessServices.add(officeSupplies);

            DefaultMutableTreeNode printing =  new DefaultMutableTreeNode("printing");
            businessServices.add(printing);

            DefaultMutableTreeNode shipping =  new DefaultMutableTreeNode("shipping");
            businessServices.add(shipping);

            DefaultMutableTreeNode legal =  new DefaultMutableTreeNode("legal");
            businessServices.add(legal);


            return;
        }

        public static void addTaxesSubcategories(DefaultMutableTreeNode taxes){
            //Federal, buisness, state, local, property, sales
            DefaultMutableTreeNode federal =  new DefaultMutableTreeNode("federal");
            taxes.add(federal);

            DefaultMutableTreeNode buisness =  new DefaultMutableTreeNode("buisness");
            taxes.add(buisness);

            DefaultMutableTreeNode state =  new DefaultMutableTreeNode("state");
            taxes.add(state);

            DefaultMutableTreeNode local =  new DefaultMutableTreeNode("local");
            taxes.add(local);

            DefaultMutableTreeNode property =  new DefaultMutableTreeNode("property");
            taxes.add(property);

            DefaultMutableTreeNode sales =  new DefaultMutableTreeNode("sales");
            taxes.add(sales);

            return;
        }
        
    /*
    * Create the GUI and show it.  For thread safety,
    * this method should be invoked from the
    * event dispatch thread.
    */
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        //Create and set up the window.
        JFrame frame = new JFrame("RestrictiveTree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new RestrictiveTree());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
