package securenotes.decryptor;

public class Decryptor {

    public String decrypt(String text,int level){
        StringBuilder bld = new StringBuilder();

        char[] characters = text.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            characters[i] -= 1000;
            bld.append(characters[i]);
        }
        return bld.toString();
    }
}
