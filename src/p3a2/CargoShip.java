/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a2;

import java.text.DecimalFormat;
import java.util.Scanner;
/**
 *
 * @author Aodhan
 */
import menu.Menu;

public class CargoShip {

    /*
    all out put and source code
    
    testing- havent actually done but tests mostly wrote out 
    
    class diagram needed 
     */
    public static void main(String[] args) {
        String CargoType = "";
        double Cargovalue = 0;
        double Cargoweight = 0;
        int Containerheight = 0;
        String Owner = "";
        boolean flag = false;
        int pcount = 1; // this will be the port id assigined to the a container
        int scount = 2;// this will be the starboard id assigned to a container
        int maxweight = 10;
        double MaxHeight = 10;
        CargoHold port = new CargoHold();
        CargoHold starboard = new CargoHold();
        CargoHold ch1 = new CargoHold();

        String[] myOptions = {"1  Create new Container Description", "2  load a container to CargoHold",
            "3  Remove a container from the cargo hold", "4  Search container by Container ID", "5  Search by owner", "6  search by cargo Type",
            "7  Display Details", "8  Total Weight Displayed", "9  Total Value of Containers", "10  Exit"};// menu options 

        Menu myMenu = new Menu("CargoHold", myOptions);
        Scanner keybstr = new Scanner(System.in);
        Scanner keybInt = new Scanner(System.in);
        int choice = 0;

        while (choice != 10) {
            choice = myMenu.getChoice();
            switch (choice) {   // this will allow you to crete a container description with out adding the container to the ship
                case 1:
                    if (flag == false) {
                        do {
                            System.out.println("Input owners name: ");
                            try {
                                Owner = keybstr.next();     // input owner name 
                            } catch (Exception ex) {
                                keybstr.next();
                                System.out.println(ex.toString());
                            }
                        } while (Owner.equalsIgnoreCase(""));

                        do {
                            System.out.println("Input CargoType: ");
                            try {
                                CargoType = keybstr.next();     // input Cargo type

                            } catch (Exception ex) {
                                keybstr.next();
                                System.out.println(ex.toString());
                            }
                        } while (CargoType.equalsIgnoreCase(""));
                        do {
                            System.out.println("Input Cargovalue: ");
                            try {
                                Cargovalue = keybInt.nextDouble();    // input Cargo Value
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Cargovalue <= 0);
                        do {
                            System.out.println("Input CargoWeight: ");
                            try {
                                Cargoweight = keybInt.nextDouble();    // input Cargo weight
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Cargoweight <= 0);
                        do {
                            System.out.println("Input Containers height, either 2 meters or 3 meters: ");
                            try {
                                Containerheight = keybInt.nextInt();    // input Cargo height
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Containerheight < 2 || Containerheight >= 4); // will ensure that the value will be relevent to the size allowed     
                    }
                    flag = true;
                    break;
                case 2:
                    // option 2 - load a container to the cargo hold  
                    String ans = "";
                    DecimalFormat df = new DecimalFormat("#.##");
                    if (flag == true) {
                        do{
                        System.out.println("Do you want to create a container using the values entered in container description");
                        System.out.println("This will delete all information stored in container description");
                        try {
                            ans = keybstr.next(); 
                            if (ans.equalsIgnoreCase("yes")) {// enables the option of using different values in which you have prevsouly entered  
                                flag = true;
                            } else if (ans.equalsIgnoreCase("no")) {
                                flag = false;
                            }
                            else
                            {
                                System.out.println("please enter a valid option(yes/ no)");
                                ans="";
                            }
                        } catch (Exception ex) {
                            keybstr.next();
                            System.out.println("please enter a valid option");
                            System.out.println(ex.toString());
                        }
                        }while(ans.equalsIgnoreCase(""));
                    }
                      
                    if (flag == false) { // makes sure that ther are no description added, and if ther is that the answer is not to use the values entered 
                        do {
                            System.out.println("Input owners name: ");
                            try {
                                Owner = keybstr.next();     // input owner name 
                            } catch (Exception ex) {
                                keybstr.next();
                                System.out.println(ex.toString());
                            }
                        } while (Owner.equalsIgnoreCase(""));

                        do {
                            System.out.println("Input CargoType: ");
                            try {
                                CargoType = keybstr.next();     // input Cargo type

                            } catch (Exception ex) {
                                keybstr.next();
                                System.out.println(ex.toString());
                            }
                        } while (CargoType.equalsIgnoreCase(""));
                        do {
                            System.out.println("Input Cargovalue: ");
                            try {
                                Cargovalue = keybInt.nextDouble();    // input Cargo Value
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Cargovalue <=0);
                        do {
                            System.out.println("Input CargoWeight: ");
                            try {
                                Cargoweight = keybInt.nextDouble();    // input Cargo weight
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Cargoweight <=0);
                        do {
                            System.out.println("Input Containers height, either 2 meters or 3 meters: ");
                            try {
                                Containerheight = keybInt.nextInt();    // input Cargo height
                            } catch (Exception ex) {
                                keybInt.next();
                                System.out.println(ex.toString());
                            }
                        } while (Containerheight < 2 || Containerheight >= 4); // will ensure that the value will be relevent to the size allowed  
                    }
                    flag = false;
                    double star,
                     ports,
                     total,
                     totalport,
                     totalstar;
                    if (port.totalheight() <= starboard.totalheight()) { //  decides if it will either go into port or starboard 
                        port.AddContainerNode(pcount, Owner, CargoType, Cargovalue, Cargoweight, Containerheight); // adds item to port
                        pcount = pcount + 2;
                        if (pcount >= maxweight) {
                            System.out.println("Warning, the total amount of weight allowed has be passed ");
                        }
                        star = (starboard.totalWeight());
                        ports = (port.totalWeight());
                        total = ports + star;
                        totalport = ports / total;
                        totalstar = star / total;// enables the percentage to be found between the diffference in weight or port and starboar
                        System.out.println("Total of starboard " + totalstar * 100 + "%");
                        System.out.println("Total of port " + totalport * 100 + "%");

                        if (totalport < 0.55) { // decides if there are any issues with adding the item to port(weight wise )
                            System.out.println("Item added");

                        } else if (totalport >= 0.55) {
                            System.out.println("Item added");
                            System.out.println("Warning, ship now uneven, port to much weight compared to starboard");
                        }
                        System.out.println(port.totalheight());
                        if (port.totalheight() <= MaxHeight) {// decides if there are any issues with adding the item to port(height wise )
                            System.out.println("Successful height");
                        } else {
                            System.out.println("Warning, too high");
                            System.out.println("Please remove a container");
                        }
                    } else {
                        starboard.AddContainerNode(scount, Owner, CargoType, Cargovalue, Cargoweight, Containerheight);
                        scount = scount + 2;
                        if (scount >=maxweight) {
                            System.out.println("Warning, the total amount of weight allowed has be passed ");
                        }
                        star = (starboard.totalWeight());
                        ports = (port.totalWeight());
                        total = ports + star;
                        totalport = ports / total;
                        totalstar = star / total;// enables the percentage to be found between the diffference in weight or port and starboard
                        System.out.println("Total of starboard " + totalstar * 100 + "%");
                        System.out.println("Total of port " + totalport * 100 + "%");
                        if (totalstar < 0.55) {                 // decides if there are any issues with adding the item to starboard(weight wise )
                            System.out.println("Item added to starboard");
                        } else if (totalstar >= 0.55) {
                            System.out.println("Item added");
                            System.out.println("Warning, ship now uneven, starboard to much weight compared to port");
                            System.out.println(df.format(totalstar));
                        }
                        System.out.println(starboard.totalheight());
                        if (starboard.totalheight() <= (MaxHeight)) {// decides if there are any issues with adding the item to starboard(height wise )
                            System.out.println("Height successful");
                        } else {
                            System.out.println("Warning, too high");
                            System.out.println("Please remove a container");
                        }
                    }
                    break;
                case 3:
                    // remove a container
                    String answer = "";
                    do{
                    System.out.println("Do you want to remove a container form port or starboard");
                    try {                           // validation 
                        answer = keybstr.next();
                        if (answer.equalsIgnoreCase("port")) {      // will check for either port or starboard, if neither is found, the question is re-asked
                        port.removeContainerNode();
                        System.out.println("Successful");
                        pcount = pcount - 2;
                        break;
                    } else if (answer.equalsIgnoreCase("starboard")) {
                        starboard.removeContainerNode();
                        System.out.println("Successful");
                        scount = scount - 2;
                        break;
                    }
                    else
                    {
                        System.out.println("error ");
                    }
                    } catch (Exception ex) {
                        keybstr.next();
                        System.out.println(ex.toString());
                    }
                    }while (!answer.equalsIgnoreCase("port") || !answer.equalsIgnoreCase("starboard")); 
                    break;
                case 4:
                    // option 4 - search container by id 
                    int cargoID=-1;
                    do{
                    System.out.println("Enter CargoID");
                    try {
                        cargoID = keybInt.nextInt();
                    } catch (Exception ex) {
                        keybInt.next();
                        System.out.println(ex.toString());
                    }
                    }while(cargoID<0);
                    if (port.containsID(cargoID)) {         // will search is port contains a container with the id 
                        System.out.println("Port contains this item");
                    } else if (starboard.containsID(cargoID)) {         // will search is starboard contains a container with the id 
                        System.out.println("Startboard contains this item");
                    } else {
                        System.out.println("Item dose not exisit in stack ");
                    }
                    break;
                case 5:
                    // option 5 - search by owner
                    String tempOwner = "";
                    do{
                    System.out.println("Enter Owner Name");
                    try {
                        tempOwner = keybstr.next();
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                    }while(tempOwner.equalsIgnoreCase(""));
                    if(port.searchOwner(tempOwner)!=null) {         // will search is port contains a container with the cargo type
                        System.out.println(port.searchOwner(tempOwner));   
                    } else if (starboard.searchOwner(tempOwner)!=null) {         // will search is starboard contains a container with the cargo type 
                        System.out.println(starboard.searchOwner(tempOwner));
                    } else {
                        System.out.println("Item dose not exisit in stack ");
                    }
                    break;
                case 6:
                    // option 6 - search by cargo type
                    String tempCargoType = "";
                    do{
                    System.out.println("Enter CargoType");
                    try {
                        tempCargoType = keybstr.next();
                    } catch (Exception ex) {
                        System.out.println(ex.toString());
                    }
                    }while(tempCargoType.equalsIgnoreCase(""));
                    if(port.searchType(tempCargoType)!=null) {         // will search is port contains a container with the cargo type
                        System.out.println(port.searchType(tempCargoType));   
                    } else if (starboard.searchType(tempCargoType)!=null) {         // will search is starboard contains a container with the cargo type 
                        System.out.println(starboard.searchType(tempCargoType));
                    } else {
                        System.out.println("Item dose not exisit in stack ");
                    }
                    break;
                case 7:
                    // option 7 - Display details 
                    System.out.println("Port:\n" + port.displayAll()); // displays all details in port
                    System.out.println("Starboard:\n" + starboard.displayAll()); // displays all details in starboard
                    break;
                case 8:
                    // option 8 - total weight displayed 
                    System.out.println("Port: " + port.totalWeight()); // diplays the total weight of port
                    System.out.println("Starboard: " + starboard.totalWeight());// diplays the total weight of starboard
                    break;
                case 9:
                    // option 9 - total value of containers 
                    System.out.println("Port: " + port.totalValue());// diplays the total value of port
                    System.out.println("Starboard: " + starboard.totalValue());// diplays the total value of starboard
                    break;
                case 10:
                    // exit
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Error, enter a valid number");
                    break;
            }
        }
        System.out.println("Thank you for using my program");
    }
}
