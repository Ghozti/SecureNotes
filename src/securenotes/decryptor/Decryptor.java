package securenotes.decryptor;

public class Decryptor {

    /*******************************************************************************************************************
     * @author ghozti
     * the decryptor will be used to decrypt encrypted text in the NotePad
     * the decryptor will simply take in a String argument which will be decrypted by reversing the effects of the encryptor
     * the string argument will be converted to a char array
     * then change each character's ascii table value to -70 so we get the orginal character
     * then it will append all characters to a string
     ******************************************************************************************************************/

    public String decrypt(String text){
        StringBuilder bld = new StringBuilder();

        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length-1; i++) {
            characters[i] -= 70;
            bld.append(characters[i]);
        }
        return bld.toString();
    }
}
