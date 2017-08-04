package nl.mawoo.jerome.connectors.utils;

/**
 * In this package are classes that can are often helpfull for developing plugins.
 *
 * This class helps extracting values from filepaths and other types that are usefull for getting information about
 * directories or files.
 */
public class Files {

    /**
     * If you have a path with filename this method will extract the file and the path separably.
     * @param path fullpath with filename. example: path/to/document.txt
     * @return String[] 0 = path, 1 = file
     */
    public static String[] getPathFromFull(String path) {
        int i = path.lastIndexOf("/");
        return new String[]{path.substring(0, i+1), path.substring(i+1)};
    }
}
