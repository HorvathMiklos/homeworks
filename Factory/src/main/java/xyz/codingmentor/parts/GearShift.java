
package xyz.codingmentor.parts;

import xyz.codingmentor.annotations.AudiHasFaultsWithThis;
import xyz.codingmentor.enums.CarCompany;

/**
 *
 * @author mhorvath
 */
@AudiHasFaultsWithThis
public class GearShift extends Part{

    public GearShift(CarCompany carCompany, boolean faultyStatus) {
        super(carCompany, faultyStatus);
    }
    

}
