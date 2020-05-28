package lesson12.MetaSpace;

import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 18395435
 * @created_at 28/05/2020 - 23:14
 * @project InnopolisUniversity
 */
public class TestPermGenMetaSpaceOOM {
    private static Map<String, MyInterface> myMap = new HashMap<>();

    public static void createPermGenOOM() {
        int iterations = 0;
        try {
            while (true) {
                String classLoaderJAR = "file:" + iterations + ".jar";
                URL[] urlsOfJar = new URL[]{new URL(classLoaderJAR)};//an array containing jar url
                URLClassLoader aUrlClassLoader = new URLClassLoader(urlsOfJar); //a class loader to load all JAR urls
                //this will create new proxy to load the class loader
                MyInterface proxyObj = (MyInterface) Proxy.newProxyInstance(aUrlClassLoader, //adding class loader
                        new Class<?>[]{MyInterface.class},//Anonymous class/Interface array which implements myInterface
                        new MyInterfaceInvocationHandler(new MyClass())// an invocation handler(implements InvocationHandler)
                );
                myMap.put(classLoaderJAR, proxyObj); // this will store all loaders which eventually leak memory as it is stored.
                iterations++;
            }
        } catch (Throwable anyError) {
            anyError.printStackTrace();
            System.out.println("Error = " + anyError);
        }
    }
}