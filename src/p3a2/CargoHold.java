/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a2;

/**
 *
 * @author Aodhan
 */
public class CargoHold {
    private ContainerNode top;
    private double totalweight;
    private double totalvalue;
    private boolean flag = false;
    private int totalheight;
    int count=0;
    
    private String []CargoType = new String[10];
    private double []Cargovalue=new double[10];
    private double []Cargoweight= new double[10];
    private int []Containerheight= new int[10];
    private String []Owner = new String[10];
    
    
    public CargoHold()// constructor 
    {
        totalweight=0;
        totalvalue=0;
        top=null;
        
    }
    /**/

    /**
     *
     * @param CargoID
     * @param owner
     * @param cargoType
     * @param cargoValue
     * @param cargoWeight
     * @param containerHeight
     */

    public void AddContainerNode(int CargoID,String owner, String cargoType, double cargoValue, double cargoWeight, int containerHeight)
    {
        // allows user to add a container to port or starboard 
        ContainerNode newNode= new ContainerNode(CargoID,owner,cargoType,cargoValue,cargoWeight,containerHeight);
        if (flag==false){
            newNode.setCargoType(cargoType);
            newNode.setCargoValue(cargoValue);
            newNode.setCargoWeight(cargoWeight);
            newNode.setContainerHeight(containerHeight);
            newNode.setOwner(owner);
            newNode.setCargoID(CargoID);
            Cargovalue[count]=cargoValue;
            Cargoweight[count]=cargoWeight;
            Containerheight[count]=containerHeight;
            
        }
        else// enables the option of using the items from the decription or not 
        {
            newNode.setCargoType(CargoType[count]);
            newNode.setCargoValue(Cargovalue[count]);
            newNode.setCargoWeight(Cargoweight[count]);
            newNode.setContainerHeight(Containerheight[count]);
            newNode.setOwner(Owner[count]);
            newNode.setCargoID(CargoID);
            
        }
        flag = false;
        totalvalue+=Cargovalue[count];
        totalweight+=Cargoweight[count];
        totalheight+=Containerheight[count];
        
        if(isEmpty())   // point to a new top
        {
        top=newNode;
        }
        else
        {
        newNode.setNext(top);// points to old top
        top=newNode;
        }
       count++;
    }

    /**
     *
     * @param owner
     * @param cargoType
     * @param cargoValue
     * @param cargoWeight
     * @param containerHeight
     */

    public void AddContainerDescription(String owner, String cargoType, double cargoValue, double cargoWeight, int containerHeight)
    {
        // add a description with assinging it a id 
        if(flag==false){
        CargoType[count] = cargoType;
        Cargovalue[count] = cargoValue;
        Cargoweight[count]= cargoWeight;
        Containerheight[count]=containerHeight;
        Owner[count] = owner;
        }
        flag = true;
    }

    /**
     *
     * @return
     */

    public ContainerNode removeContainerNode()// removes a container node
    {  
    count--;    
    totalvalue=totalvalue-Cargovalue[count];
    totalweight=totalweight-Cargoweight[count];
    totalheight=totalheight-Containerheight[count]; 
    
    ContainerNode remove;
    if(isEmpty())
    {
        return null;
    }
    remove=top;
    top=top.getNext();
    
    
    return remove;
    
    }

    /**
     *
     * @param target
     * @return 
     */

    public boolean containsID(int target) // enables a serch for a cargo id 
    {
    boolean res=false;
    ContainerNode temp = top;
    while (temp!=null)
    {
        if(temp.getCargoID()== target)
        {
            return true;
        }
        temp=temp.getNext();
    }
    return false;
    }

    /**
     *
     * @param item
     * @return 
     */

    public String searchOwner( String item)
    {
    StringBuilder sb =new StringBuilder();
        ContainerNode temp = top;
        String Height="";
        sb.append("CargoID\tOwner\tType\tValue\tWeight\tHeight");
        if(isEmpty()) // check if the stack is empty
        {
        return": Empty Stack\n";
        }
        while(temp!=null)
        {
            if(temp.getContainerHeight()>=3 && temp.getContainerHeight()<4) //
            {
            Height="large";
            }
            else if(temp.getContainerHeight()>=2&& temp.getContainerHeight()<3 )
            {
            Height="Standard";
            }
            else
            {
                Height="error";
            }
            if(temp.getOwner().equalsIgnoreCase(item)){
                sb.append("\n["+temp.getCargoID()+"]\t"+"["+temp.getOwner()+"]\t"+"["+temp.getCargoType() +"]\t"+"["+temp.getCargoValue()+"k"+"]\t" +"["+temp.getCargoWeight()+"]\t"+"["+Height+"]\n" );
            }
            temp=temp.getNext();
        }
        return sb.toString();
    }

    /**
     *
     * @param item
     * @return 
     */

    public String searchType( String item)
    {
    StringBuilder sb =new StringBuilder();
        ContainerNode temp = top;
        String Height="";
        sb.append("CargoID\tOwner\tType\tValue\tWeight\tHeight");
        if(isEmpty()) // check if the stack is empty
        {
        return": Empty Stack\n";
        }
        while(temp!=null)
        {
            if(temp.getContainerHeight()>=3 && temp.getContainerHeight()<4) //
            {
            Height="large";
            }
            else if(temp.getContainerHeight()>=2&& temp.getContainerHeight()<3 )
            {
            Height="Standard";
            }
            else
            {
                Height="error";
            }
            if(temp.getCargoType().equalsIgnoreCase(item)){
            sb.append("\n["+temp.getCargoID()+"]\t"+"["+temp.getOwner()+"]\t"+"["+temp.getCargoType() +"]\t"+"["+temp.getCargoValue()+"k"+"]\t" +"["+temp.getCargoWeight()+"]\t"+"["+Height+"]\n" );
            }
            temp=temp.getNext();
        }
        return sb.toString();
    }

    /**
     *
     * @return
     */

    public String displayAll()// displays all the infromation stored in the stack 
    {
        StringBuilder sb =new StringBuilder();
        ContainerNode temp = top;
        String Height="";
        sb.append("CargoID\tOwner\tType\tValue\tWeight\tHeight");
        if(isEmpty()) // check if the stack is empty
        {
        return": Empty Stack\n";
        }
        while(temp!=null)
        {
            if(temp.getContainerHeight()>=3 && temp.getContainerHeight()<4) //
            {
            Height="large";
            }
            else if(temp.getContainerHeight()>=2&& temp.getContainerHeight()<3 )
            {
            Height="Standard";
            }
            else
            {
                Height="error";
            }
            
            sb.append("\n["+temp.getCargoID()+"]\t"+"["+temp.getOwner()+"]\t"+"["+temp.getCargoType() +"]\t"+"["+temp.getCargoValue()+"k"+"]\t" +"["+temp.getCargoWeight()+"]\t"+"["+Height+"]\n" );
            temp=temp.getNext();
        }
        return sb.toString();
    }
    
    /**
     *
     * @return
     */

    public double totalWeight()// retuns the total weight of all the item in the stack
    {
    return totalweight;
    }

    /**
     *
     * @return
     */

    public double totalValue()// retuns the total value of all the item in the stack
    {
    return totalvalue;
    }

    /**
     *
     * @return
     */

    public int totalheight()// retuns the total height of all the item in the stack
    {
    return totalheight;
    }
    private boolean isEmpty()// check if the stack is empty 
    {
        return top == null;
    }

}
 