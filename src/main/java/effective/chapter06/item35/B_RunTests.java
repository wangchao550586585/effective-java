package effective.chapter06.item35;


import java.awt.event.InvocationEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author WangChao
 * @create 2018/4/16 13:08
 */
public class B_RunTests {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;
        //Class<?> testClass = Class.forName("effective.chapter06.item35.A_Sample");
        Class<?> testClass = Class.forName("effective.chapter06.item35.C_Sample2");
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    method.invoke(null);
                    passed++;
                } catch (InvocationTargetException exception) {
                    Throwable cause = exception.getCause();
                    System.out.println(method + "failed" + exception);
                } catch (Exception exc) {
                    System.out.println("INVALID @Test:" + method);
                }
            } else if (method.isAnnotationPresent(ExceptionTest.class)) {
                tests++;
                try {
                    method.invoke(null);
                    System.out.printf("Test %s failed:no exception%n", method);
                } catch (InvocationTargetException ex) {
                    Throwable cause = ex.getCause();
                    Class<? extends Exception>[] excTypes = method.getAnnotation(ExceptionTest.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Exception> excType : excTypes) {
                        if (excType.isInstance(cause)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed==oldPassed){
                        System.out.printf("Test %s failed: %s %n", method, cause);
                    }
                } catch (Exception exc) {
                    System.out.println("INVALID @Test:" + method);
                }
            }

        }
        System.out.printf("Passed: %d,Failed: %d%n", passed, tests - passed);
    }
}
