package nl.mawoo.intergrationframework.connectors.utils;

import org.apache.log4j.Logger;

/**
 * In this package are classes that can are often helpful for developing plugins.
 *
 * This class helps extracting values from filepath and other types that are useful for getting information about
 * directories or files.
 */
public class Files {
    private static Logger logger = Logger.getLogger(Files.class);

    /**
     * If you have a path with filename this method will extract the file and the path separably.
     * @param path fullpath with filename. example: path/to/document.txt
     * @return String[] 0 = path, 1 = file
     */
    public static String[] getPathFromFull(String path) {
        int iDirectory = path.lastIndexOf("/");
        if(iDirectory == 0) {
            return new String[]{path};
        } else {
            return new String[]{path.substring(0, iDirectory+1), path.substring(iDirectory+1)};
        }
    }
}
