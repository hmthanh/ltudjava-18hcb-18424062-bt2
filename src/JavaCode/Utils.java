/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCode;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sieus
 */
public class Utils {

    public Utils() {

    }
    public static final String COMMA_DELIMITER = ",";

    public static String getRootUrl() {
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();

        return path.toString();
    }

    public static String getAbsolutePath(String key) {
        String path = Utils.getRootUrl();

        return path + "/Data/" + key + "/";
    }

    public static List<String> listFilesForFolder(String dir) {
        List<String> list = new ArrayList();
        File folder = new File(dir);
        for (final File fileEntry : folder.listFiles()) {
            if (!fileEntry.isDirectory()) {
                list.add(fileEntry.getName());
            }
        }

        return list;
    }
}
