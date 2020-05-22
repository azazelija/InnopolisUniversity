package lesson9;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;

/**
 * @author 18395435
 * @created_at 23/05/2020 - 00:32
 * @project InnopolisUniversity
 */
public class ClassLoaderHandlerTest {
    public static ClassLoader classLoader = new ClassLoaderHandler();

    public static String PATH = "/Users/18395435/Desktop/InnopolisUniversity/part1/src/main/java/lesson9/SomeClass.java";

    public static void main(String[] args) {
        try {
            writeToClass();
            compileClass();
            Class<?> smClass = classLoader.loadClass("lesson9.SomeClass");
            Worker worker = (Worker) smClass.newInstance();
            worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readConsole() {
        StringBuilder str = new StringBuilder();
        int w;
        int code = 0;
        try {
            while ((w = System.in.read()) != 0) {
                if (w == (int) '\n')
                    code++;
                if (code == 2)
                    break;
                str.append((char) w);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public static void writeToClass() {
        try {
            StringBuilder someClassInner = new StringBuilder().append("package lesson9;\n\n")
                    .append("public class SomeClass implements Worker {\n")
                    .append("\t@Override\n")
                    .append("\tpublic void doWork() {\n\n")
                    .append("\t\t")
                    .append(readConsole())
                    .append("\t}\n}");

            File file = new File(PATH);
            file.createNewFile();

            Files.write(file.toPath(), someClassInner.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void compileClass() {
        try {
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

            Iterable<? extends JavaFileObject> compilationUnits1 =
                    fileManager.getJavaFileObjectsFromFiles(Collections.singletonList(new File(PATH)));
            compiler.getTask(null, fileManager, null, null, null, compilationUnits1).call();

            fileManager.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
