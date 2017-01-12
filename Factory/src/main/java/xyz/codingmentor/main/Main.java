
package xyz.codingmentor.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.enums.CarCompany;
import xyz.codingmentor.enums.PartType;
import xyz.codingmentor.factory.Factory;
import xyz.codingmentor.parts.Part;

/**
 *
 * @author mhorvath
 */
public class Main {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static Factory testFactory= new Factory("testFactory");
    private static Part testPart;

    private Main() {
    }
    
    public static void main(String[] args) {
        for(CarCompany company : CarCompany.values()){
            for(PartType partType : PartType.values()){
                LOGGER.log(Level.INFO,company.getName()+" ordered a new "+partType.getName());
                testPart=testFactory.deliveredNewPart(partType, company);
                LOGGER.log(Level.INFO, testPart.toString()+" arrived to "+company.getName());
            }
        }
        LOGGER.log(Level.INFO, "List of parts delivered by "+testFactory.getFactoryname()+":");
        for(Part part : testFactory.getDeliveredParts()){
            LOGGER.log(Level.INFO, part.toString());
        }
    }


}
