package examples.exception;

/**
 * Created on 20.02.2017.
 * exception
 */
public class Main {

    // checked
    Throwable throwable = null;
    Exception exception = new IndexOutOfBoundsException();
    // unchecked
    Error error = new OutOfMemoryError();
    RuntimeException runtimeException = new IllegalArgumentException();
}
