
package xyz.codingmentor.confusinghw.main;

import xyz.codingmentor.confusinghw.annotations.Confusing;
import xyz.codingmentor.confusinghw.classestoanalize.ClazzWithFields;

/**
 *
 * @author mhorvath
 */
public class Main {

    private Main() {
    }
    
    public static void main(String[] args) {
        FieldDataWriter.logFieldData(ClazzWithFields.class, Confusing.class);
    }
    
}
