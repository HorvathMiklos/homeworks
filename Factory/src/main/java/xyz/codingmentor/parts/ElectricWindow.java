package xyz.codingmentor.parts;
import xyz.codingmentor.annotations.MazdaHasFaultsWithThis;
import xyz.codingmentor.enums.CarCompany;
/**
 *
 * @author mhorvath
 */
@MazdaHasFaultsWithThis
public class ElectricWindow extends Part{

    public ElectricWindow(CarCompany carCompany, boolean faultyStatus) {
        super(carCompany, faultyStatus);
    }
    

}
