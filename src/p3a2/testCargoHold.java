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
public class testCargoHold 
{
    public static void main(String[] args) 
    {
        CargoHold ex = new CargoHold();
        
       //ex.AddContainerDescription("bill","tv", 0, 0, 0);
       ex.AddContainerNode(0,"aodhan","tv", 1, 2, 2);
       ex.AddContainerNode(1,"bill","tv", 1, 2, 2);

        
        System.out.println(ex.displayAll());
        System.out.println(ex.totalValue());
        System.out.println(ex.totalWeight());

        System.out.println(ex.totalheight());
        ex.removeContainerNode();
        System.out.println(ex.displayAll());
        System.out.println(ex.totalValue());
        System.out.println(ex.totalWeight());
        
        System.out.println(ex.totalheight());
        
        System.out.println(ex.searchOwner("aodhan"));
        System.out.println(ex.searchType("tv"));
        System.out.println(ex.containsID(1));
    }
    
}
