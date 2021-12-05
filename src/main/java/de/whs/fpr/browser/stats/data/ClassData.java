package de.whs.fpr.browser.stats.data;

import java.lang.reflect.AnnotatedType;

/**
 * Class data.
 *
 * Represents a classes' data.
 *
 * @author Frederik Bußmann
 */
public class ClassData {
    /**
     * String constant for indentation of class data.
     */
    public static final String INDENTATION = "        ";

    /**
     * The name of the class.
     */
    private final String className;

    /**
     * The super-class the class extends on.
     */
    private ClassData superClass;

    /**
     * The constructors of the class.
     */
    private final Constructors constructors;

    /**
     * The methods of the class.
     */
    private final Methods methods;

    /**
     * The fields of the class.
     */
    private final Fields fields;

    /**
     * Class constructor.
     *
     * @param classData The class to obtain data from.
     */
    public ClassData(Class<?> classData) {
        this.className = classData.getName();

        String superClassName = classData.getSuperclass().getName();
        if (!superClassName.equals("java.lang.Object")) {
            this.superClass = new ClassData(classData.getSuperclass());
        }

        this.constructors = new Constructors(classData);
        this.methods = new Methods(classData);
        this.fields = new Fields(classData);
    }

    /**
     * Gets the class name.
     *
     * @return The name of the class.
     */
    public String getName() {
        return className;
    }

    /**
     * Gets the super-class name.
     *
     * @return The name of the super-class.
     */
    public ClassData getSuperClass() {
        return superClass;
    }

    /**
     * Gets the class constructors.
     *
     * @return The constructors of the class.
     */
    public Constructors getConstructors() {
        return constructors;
    }

    /**
     * Gets the class methods.
     *
     * @return The methods of the class.
     */
    public Methods getMethods() {
        return methods;
    }

    /**
     * Gets the class fields.
     *
     * @return The fields of the class.
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * Converts the class to a string representing its data.
     *
     * @return The class data as a string.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("class ").append(getName());

        if (superClass != null) {
            stringBuilder.append(" extends ").append(superClass.getName()).append(" {");
        }
        else {
            stringBuilder.append(" {");
        }

        stringBuilder.append("\n");

        stringBuilder.append(constructors);
        stringBuilder.append("\n");

        stringBuilder.append(methods);
        stringBuilder.append("\n");

        stringBuilder.append(fields);

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    /**
     * Converts a given array of annotated types to a string representing its data.
     *
     * @param parameters The annotated types.
     *
     * @return The annotated types as a string.
     */
    public static String AnnotatedTypesToString(AnnotatedType[] parameters) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < parameters.length; i++) {
            if (i != 0) {
                stringBuilder.append(", ");
            }

            stringBuilder.append(parameters[i]);
        }

        stringBuilder.append(");\n");

        return stringBuilder.toString();
    }
}
