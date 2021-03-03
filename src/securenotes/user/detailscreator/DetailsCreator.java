package securenotes.user.detailscreator;
import java.io.*;

public class DetailsCreator {

    /*******************************************************************************************************************
     * @author ghozti
     * Details creator has 4 methods
     * createFiles, createDirectory, createName, createPassword
     * createFiles will call all of the other 3 methods to create everything
     * createDirectory will create a folder called SecureNotesDetails in the user's home directory
     * createName will then get the created folder and create "name.txt" in that folder
     * same goes for password except it creates "password.txt"
     * these 2 methods also check if the files already exists. if so it will not write anything there
       if not then it wills set "ghost" and "123" as the default name and password
     ******************************************************************************************************************/

    public void createFiles() throws IOException {
        String dir = createDirectory();
        createName(dir);
        createPassword(dir);
    }

    private String createDirectory(){
        File directory = new File(System.getProperty("user.home") + "/SecureNotesDetails");
        if (!directory.exists()) {
            directory.mkdir();
        }
        return directory.getAbsolutePath();
    }


    private void createName(String path) throws IOException {
        File directory = new File((path + "/name.txt"));
        if (!directory.exists()) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(directory), "utf-8"))) {
                writer.write("ghost");
            }
        }
    }


    private void createPassword(String path) throws IOException {
        File directory = new File((path + "/password.txt"));
        if (!directory.exists()) {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(directory), "utf-8"))) {
                writer.write("123");
            }
        }
    }
}
