package lesson9;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * @author 18395435
 * @created_at 20/05/2020 - 11:23
 * @project InnopolisUniversity
 */
public class ClassLoaderHandler extends ClassLoader {

    private static String PATH = "/Users/18395435/Desktop/InnopolisUniversity/part1/src/main/java/lesson9/SomeClass.class";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("lesson9.SomeClass"))
            return findClass(name);
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if (name.equals("lesson9.SomeClass"))
            try {
                byte[] bytes = Files.readAllBytes(Paths.get(PATH));
                return defineClass(name, bytes, 0, bytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return super.findClass(name);

    }
}
