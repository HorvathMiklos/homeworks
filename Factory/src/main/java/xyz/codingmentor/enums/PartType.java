
package xyz.codingmentor.enums;
import xyz.codingmentor.parts.ElectricWindow;
import xyz.codingmentor.parts.GearShift;
import xyz.codingmentor.parts.Mirror;
import xyz.codingmentor.parts.TurnSignal;

/**
 *
 * @author mhorvath
 */
public enum PartType {    
    ELECTRICWINDOW(ElectricWindow.class,"electric window"),
    GEARSHIFT(GearShift.class,"gearshift"),
    MIRROR(Mirror.class,"mirror"),
    TURNSIGNAL(TurnSignal.class,"turnsignal");
    private final Class<?> clazz;
    private final String name;

    private PartType(Class<?> clazz, String name) {
        this.clazz = clazz;
        this.name = name;
    }    

    public Class<?> getClazz() {
        return clazz;
    }

    public String getName() {
        return name;
    }
    public static String getNameFromClazz(Class<?> clazz){
        for(PartType partType : PartType.values()){
            if(clazz==partType.clazz){
                return partType.name;
            }
        }
        throw new IllegalArgumentException();
    }
    
}
