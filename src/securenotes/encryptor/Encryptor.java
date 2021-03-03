package securenotes.encryptor;

public class Encryptor {

    /*******************************************************************************************************************
     * @author ghozti
     * the encryptor will take a String argument
     * then it will convert that string to a char array
     * then it will loop through all characters and change it's ascii table value to +70
     * then it will append all encrypted chars to a string
     ******************************************************************************************************************/

    public String encrypt(String text){
        StringBuilder bld = new StringBuilder();
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            characters[i] += 70;
            bld.append(characters[i]);
        }
        return bld.toString();
    }
}
