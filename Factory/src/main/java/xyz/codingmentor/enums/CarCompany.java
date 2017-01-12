
package xyz.codingmentor.enums;

import java.lang.annotation.Annotation;
import xyz.codingmentor.annotations.AudiHasFaultsWithThis;
import xyz.codingmentor.annotations.FordHasFaultsWithThis;
import xyz.codingmentor.annotations.MazdaHasFaultsWithThis;
import xyz.codingmentor.annotations.ToyotaHasFaultsWithThis;

/**
 *
 * @author mhorvath
 */
public enum CarCompany {
    FORD(FordHasFaultsWithThis.class,"Ford"),
    MAZDA(MazdaHasFaultsWithThis.class,"Mazda"),
    AUDI(AudiHasFaultsWithThis.class,"Audi"),
    TOYOTA(ToyotaHasFaultsWithThis.class,"Toyota");
    private final Class<? extends Annotation> annotation;
    private final String name;

    private CarCompany(Class<? extends Annotation> annotation, String name) {
        this.annotation = annotation;
        this.name = name;
    }   

    public Class<? extends Annotation> getAnnotation() {
        return annotation;
    }

    public String getName() {
        return name;
    }
        
}
