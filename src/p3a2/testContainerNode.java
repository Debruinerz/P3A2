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
public class testContainerNode 
{
    public static void main(String[] args) 
    {
        ContainerNode cn = new ContainerNode(0,"","",0.0,0.0,2);
        
        cn.setCargoID(1);
        cn.setCargoType("tv");
        cn.setCargoValue(3);
        cn.setCargoWeight(3);
        cn.setContainerHeight(3);
        cn.setOwner("bill");
        
        System.out.println(cn.getCargoID());
        System.out.println(cn.getCargoType());
        System.out.println(cn.getCargoValue());
        System.out.println(cn.getCargoWeight());
        System.out.println(cn.getContainerHeight());
        System.out.println(cn.getOwner());
    }
    
}
