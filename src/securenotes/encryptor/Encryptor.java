package securenotes.encryptor;

public class Encryptor {

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
