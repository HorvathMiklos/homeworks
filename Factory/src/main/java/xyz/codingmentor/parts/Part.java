
package xyz.codingmentor.parts;

import xyz.codingmentor.enums.CarCompany;
import xyz.codingmentor.enums.PartType;

/**
 *
 * @author mhorvath
 */
public abstract class Part {
    private CarCompany carCompany;
    private boolean faultyStatus;

    public Part(CarCompany carCompany, boolean faultyStatus) {
        this.carCompany = carCompany;
        this.faultyStatus = faultyStatus;
    }
    

    public CarCompany getCarCompany() {
        return carCompany;
    }

    public boolean isFaultyStatus() {
        return faultyStatus;
    }

    @Override
    public String toString() {
        return "Part{ partType="+PartType.getNameFromClazz(this.getClass()) + " carCompany=" + carCompany + ", faultyStatus=" + faultyStatus + '}';
    }
    
    
}
