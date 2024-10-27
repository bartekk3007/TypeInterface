import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main
{
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException
    {
        Generic<String> g1 = new Generic<>("Andrzej", "Bartek", "Jan");
        System.out.println(g1);

        Field fArray = g1.getClass().getDeclaredField("array");
        Type tArray = fArray.getGenericType();
        Type tClass = Generic.class;

        Method m1 = Main.class.getMethod("printNumber", Generic.class);
        Type[] pTypes = m1.getParameterTypes();
        Type wildCardType = pTypes[0];

        Field fieldW = Generic.class.getField("listOfNumbers");
        Type typeW = fieldW.getGenericType();
        String ww = typeW.getTypeName();
        System.out.println(ww);

        var classType = g1.getClass();
        var typeParameters = classType.getTypeParameters();
        for (var typeVariable : typeParameters)
        {
            System.out.println("Nazwa zmiennej typu: " + typeVariable.getName());
            Type[] bounds = typeVariable.getBounds();
            for (Type bound : bounds)
            {
                System.out.println("Ograniczenie typu: " + bound.getTypeName());
            }
            System.out.println("Deklaracja: " + typeVariable.getGenericDeclaration());
            AnnotatedType[] annotatedBounds = typeVariable.getAnnotatedBounds();
            for (AnnotatedType annotatedBound : annotatedBounds)
            {
                System.out.println("Loop start");
                var annotations = annotatedBound.getAnnotations();
                for (Annotation annotation : annotations)
                {
                    System.out.println(annotation);
                }
                //System.out.println(annotatedBound.getType());
                System.out.println("Loop ends");
            }

        }

        if(typeW instanceof WildcardType wildcardType)
        {
            Type[] lower = wildcardType.getLowerBounds();
            for (Type type : lower)
            {
                System.out.println(type);
            }
            Type[] upper = wildcardType.getUpperBounds();
            for (Type type : upper)
            {
                System.out.println(type);
            }
        }
        if(tArray instanceof GenericArrayType gat)
        {
            Type genericComponent = gat.getGenericComponentType();
            System.out.println(genericComponent);
        }
    }
    public static void printNumber(Generic<? extends Number> arg)
    {
        System.out.println(arg.getElem());
    }
}