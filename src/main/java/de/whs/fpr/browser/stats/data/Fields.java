package de.whs.fpr.browser.stats.data;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Fields.
 *
 * Represents the fields of a class.
 *
 * @author Frederik Bußmann
 */
public class Fields {
    /**
     * Array of the class fields.
     */
    private final Field[] fields;

    /**
     * Class constructor.
     *
     * @param classData The class to obtain the fields from.
     */
    public Fields(Class<?> classData) {
        this.fields = classData.getDeclaredFields();
    }

    /**
     * Converts the data of fields of a class to a string.
     *
     * @return The fields of the class as a string.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Field field : fields) {
            stringBuilder.append(ClassData.INDENTATION);

            stringBuilder.append(Modifier.toString(field.getModifiers())).append(" ");
            stringBuilder.append(field.getAnnotatedType()).append(" ");
            stringBuilder.append(field.getName());
            stringBuilder.append(";\n");
        }

        return stringBuilder.toString();
    }
}
