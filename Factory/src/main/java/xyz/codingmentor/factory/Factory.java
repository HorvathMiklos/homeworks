
package xyz.codingmentor.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.enums.CarCompany;
import xyz.codingmentor.enums.PartType;
import xyz.codingmentor.parts.ElectricWindow;
import xyz.codingmentor.parts.GearShift;
import xyz.codingmentor.parts.Mirror;
import xyz.codingmentor.parts.Part;
import xyz.codingmentor.parts.TurnSignal;

/**
 *
 * @author mhorvath
 */
public class Factory {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private String factoryname;
    private List<Part> deliveredParts;

    public Factory(String factoryname) {
        this.factoryname = factoryname;
        this.deliveredParts=new ArrayList<>();
    }
    
    public Part deliveredNewPart(PartType partType,CarCompany company){
        Part partToDeliver = manufacturedPart(partType, company);
        deliveredParts.add(partToDeliver);
        LOGGER.log(Level.INFO,partToDeliver.toString()+" was delivered by "+this.factoryname);
        return partToDeliver;
    }
    private Part manufacturedPart(PartType partType,CarCompany company){
        if(partType.getClazz().isAnnotationPresent(company.getAnnotation())){
            return newPart(partType, company, true);
        }    
        return newPart(partType, company, false);
    }
    private Part newPart(PartType partType,CarCompany company,boolean isFaulty){
        switch(partType){
            case ELECTRICWINDOW:    return new ElectricWindow(company, isFaulty);
            case GEARSHIFT:         return new GearShift(company, isFaulty);
            case MIRROR:            return new Mirror(company, isFaulty);
            case TURNSIGNAL:        return new TurnSignal(company, isFaulty);
            default:                throw new IllegalArgumentException();
        }
    }
    public List<Part> getDeliveredParts() {
        return deliveredParts;
    }

    public String getFactoryname() {
        return factoryname;
    }
    
    
}
