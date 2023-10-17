/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a2;

/**
 *
 * @author aod17123675
 */
public class ContainerNode {

    private int cargoID;
    private String owner;
    private String cargoType;
    private double cargoValue;
    private double cargoWeight;
    private int containerHeight;
    private ContainerNode next;
    


    /**
     *
     * @param cargoID
     * @param owner
     * @param cargoType
     * @param cargoValue
     * @param cargoWeight
     * @param containerHeight
     */

    public ContainerNode(int cargoID, String owner, String cargoType, double cargoValue, double cargoWeight, int containerHeight) {// constructor 
        this.cargoID = cargoID;
        this.owner = owner;
        this.cargoType = cargoType;
        this.cargoValue = cargoValue;
        this.cargoWeight = cargoWeight;
        this.containerHeight = containerHeight;
    }
    public ContainerNode()
    {
        
    }


    /**
     *
     * @return
     */

    public int getCargoID() { // allows user to get the cargo id 
        return cargoID;
    }


    /**
     *
     * @param cargoID
     */

    public void setCargoID(int cargoID) {// allows user to set the cargo id 
        this.cargoID = cargoID;
    }


    /**
     *
     * @return
     */

    public String getOwner() {// allows user to get the owner name 
        return owner;
    }


    /**
     *
     * @param owner
     */

    public void setOwner(String owner) {// allows user to set the owner name 
        this.owner = owner;
    }


    /**
     *
     * @return
     */

    public String getCargoType() {// allows user to get the cargo type 
        return cargoType;
    }

    /**
     *
     * @param cargoType
     */

    public void setCargoType(String cargoType) {// allows user to set the cargo type 
        this.cargoType = cargoType;
    }

    /**
     *
     * @return
     */

    public double getCargoValue() {// allows user to get the cargo value
        return cargoValue;
    }
    
    /**
     *
     * @param cargoValue
     */
    public void setCargoValue(double cargoValue) {// allows user to set the cargo value
        this.cargoValue = cargoValue;
    }

    /**
     *
     * @return
     */

    public double getCargoWeight() {// allows user to get the cargo weight
        return cargoWeight;
    }

    /**
     *
     * @param cargoWeight
     */

    public void setCargoWeight(double cargoWeight) {// allows user to set the cargo weight
        this.cargoWeight = cargoWeight;
    }
 
    /**
     *
     * @return
     */
    public int getContainerHeight() {// allows user to get the container height 
        return containerHeight;
    }

    /**
     *
     * @param containerHeight
     */

    public void setContainerHeight(int containerHeight) {// allows user to set the container height
        this.containerHeight = containerHeight;
    }

    /**
     *
     * @return
     */

    public ContainerNode getNext() {
        return next;
    }
    /**
     *
     * @param next
     */

    public void setNext(ContainerNode next) {
        this.next = next;
    }
    
}
