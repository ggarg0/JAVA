
import java.io.*;

public class RenameFileDirectory {

  public static void main(String[] args) {
    //create source File object
    File oldName = new File("C://FileIO//bdd_pending");

    //create destination File object
    File newName = new File("C://FileIO//bdd");

    /*
     * To rename a file or directory, use
     * boolean renameTo(File destination) method of Java File class.
     *
     * This method returns true if the file was renamed successfully, false
     * otherwise.
     */
 	 oldName.getParent().resolve(newName);
 /*    boolean isFileRenamed = oldName.renameTo(newName);

     if(isFileRenamed)
       System.out.println("File has been renamed");
     else
       System.out.println("Error renaming the file");
  */}
}



