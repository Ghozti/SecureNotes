package securenotes.decryptor;

public class Decryptor {

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
