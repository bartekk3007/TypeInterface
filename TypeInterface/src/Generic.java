import java.util.Arrays;
import java.util.List;

public class Generic<T>
{
    private T[] array;
    private T elem;

    public List<? extends Number> listOfNumbers;

    public Generic(T[] array, T elem)
    {
        this.array = array;
        this.elem = elem;
    }

    public Generic(T... array)
    {
        this.array = array;
    }

    public Generic()
    {
        array = null;
    }

    public T[] getArray()
    {
        return array;
    }

    public void setArray(T[] array)
    {
        this.array = array;
    }

    public T getElem()
    {
        return elem;
    }

    public void setElem(T elem)
    {
        this.elem = elem;
    }

    @Override
    public String toString()
    {
        return "Generic{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
