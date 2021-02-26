package securenotes.encryptor;

public class Encryptor {

    public String encrypt(String text){
        StringBuilder bld = new StringBuilder();
        char[] characters = text.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            if (i % 2 == 0) {
                characters[i] += 100;
            }else {
                characters[i] += 500;
            }
            bld.append(characters[i]);
        }
        return bld.toString();
    }
}
