package nl.mawoo.jerome.connectors.utils;

import org.apache.log4j.Logger;

/**
 * In this package are classes that can are often helpfull for developing plugins.
 *
 * This class helps extracting values from filepaths and other types that are usefull for getting information about
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
        return new String[]{path.substring(0, iDirectory+1), path.substring(iDirectory+1)};
    }
}
