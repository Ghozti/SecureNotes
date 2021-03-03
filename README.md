# SecureNotes
Welcome to SecureNotes a free and open source javaFX utility program. SecureNotes is a project meant to help you keep your .txt files safe from others by letting the user encrypt and decrypt
their .txt files using SecureNotes. 

# LogIn

Secure Notes is straight forwars. when launching the application you will be asked to log in every time. The defaut credentials will be:
- name : ghost
- password : 123
When launching the application for the first time SecureNotes will create a folder named ```SecureNotesDetails``` in your home directory. This folder will contain 2 .txt files 
- ```name.txt```
- ```password.txt```

***DO NOT DELETE/MOVE THIS FOLDER OR FILES*** SecureNotes will use these files and folder path to access your name and password. Deleting or moving this folder will result in the program
not working as intended.

These details can be changed at any time. The user can either manually access this folder and changing the contents of ```name.txt``` and ```password.txt``` or the user can use the built-in "change details" option in SecureNotes once you are logged in. You will need to provide the old name and password along with your new name and password. The UI will later you if the change was a sucess,
if so then you may close the change details window

# What next?
After you log in to SecureNotes, you will be greeted with the SecureNotes text editor. This is where you will write everything you wish. You can open or create a new .txt file using the 
```options``` menu in the text editor

- To open a file select "open" in the ```options``` menu. Then you will see a file explorer. Select whatever file you wish to open (as long as it is a .txt file)
- To save/create a new file select "save" in the ```options``` menu. Then you will see a file explorer. In the file explorer you may save whatever you wrote on the text editor to an existing .txt file
(this will overwrite the file), or you may create a new file by simply selecting the folder where you wish to store the file then naming the file to whatever you wish and finally clicking "save" 

# Encrypt
- This is the main focus feature of SecureNotes. In the ```options``` menu once you are done writing what you wish to write in the text editor you may select the "encrypt" option
This will automatically encrypt the text in the editor. Once this happens you may save the file.

# Decrypt
- In the ```options``` menu you may decrypt the current text in the editor by selecting the "decrypt" option. (this is intended to be used when opening an already encrypted text file)

# IMPORTANT
- There is no limit on how many times you can select "encrypt" or "decrypt" this means that continuously selecting these options will repeatively encrypt whatever there is in the current opened file
If you wish to use this to "strengthen" the level of encryption keep in mind how many times you selected "encrypt" that way you can select "decrypt" the same amount of times in order to fully decrypt the text to something readable

- Any and all files encrypted by Secure Notes can ONLY be decrypted by Secure Notes. Same goes for Decrypting. Only Secure note encrypted files can be decrypted by SecureNotes.

- SecureNotes will require atleast java 11 and JRE 8 see more at https://java.com/en/


# Using SecureNotes on Windows
Once you install the zip file you may open the folder to "\SecureNotes\SecureNotes.exe" and doubling clicking the .exe file to run the program.

# Using SecureNotes on Linux and Mac
Once you install the zip file you may open the folder to "\SecureNotes\out\artifacts\SecureNotes_jar\SecureNotes.jar" and doubling clicking the .jar file to run the program.

# launching secureNotes on a terminal 
```java -jar PATH TO JAR``` (replace PATH TO JAR with the absolute path to the .jar)

# Future of SecureNotes
SecureNotes will be updated when needed, and I will try to include requested features
