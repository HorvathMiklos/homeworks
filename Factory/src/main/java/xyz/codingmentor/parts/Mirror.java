package xyz.codingmentor.parts;

import xyz.codingmentor.annotations.AudiHasFaultsWithThis;
import xyz.codingmentor.annotations.MazdaHasFaultsWithThis;
import xyz.codingmentor.enums.CarCompany;

/**
 *
 * @author mhorvath
 */
@AudiHasFaultsWithThis
@MazdaHasFaultsWithThis
public class Mirror extends Part{

    public Mirror(CarCompany carCompany, boolean faultyStatus) {
        super(carCompany, faultyStatus);
    }
   
}
