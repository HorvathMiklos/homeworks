
package xyz.codingmentor.confusinghw.main;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhorvath
 */
public class FieldDataWriter {    
    private static final Logger LOGGER=Logger.getAnonymousLogger();

    private FieldDataWriter() {
    }
    
    public static void logFieldData(Class<?> clazz,Class<? extends Annotation> annotation){
        for(Field confusingField : collectFields(clazz, annotation)){
            LOGGER.log(Level.INFO,"Fieldname "+confusingField.getName());
            if(confusingField.getName().length()<10){
                LOGGER.log(Level.INFO,"Field name is too short!Be more specific!");             
            }
            LOGGER.log(Level.INFO,"Type: "+confusingField.getType().toString());          
        }
    }
    private static Set<Field> collectFields(Class<?> clazz,Class<? extends Annotation> annotation) {
        Set<Field> fields = new HashSet<>();
        if (null != clazz) {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(annotation)) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }
}
