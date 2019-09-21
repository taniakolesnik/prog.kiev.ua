package uk.co.taniakolesnik;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Map<String, String> dictionary;

    public static void main(String[] args) {
        dictionary  = new HashMap<>();
        dictionary.put("hello", "привіт");

        translate("hello world");
        askForWorldTranslation();
        translate("hello world");
        translate("world hello");

        System.out.println(dictionary);
        saveDictionary();

        // remove one line from current dictionary and load saved one
        dictionary.remove("world");

        System.out.println("current dictionary in use: " + dictionary);
        loadDictionary();
        System.out.println("loaded old dictionary: " + dictionary);

    }

    private static void askForWorldTranslation() {

        System.out.println("Enter new word in english (e.g. world): ");
        Scanner scanner_key = new Scanner(System.in);
        String key = scanner_key.next();
        System.out.println("Enter translation for " + key + " (e.g. світ):");
        Scanner scanner_value = new Scanner(System.in);
        String value = scanner_value.next();
        dictionary.put(key, value);
    }

    private static String translate(String sentence) {
        List<String> words = Arrays.asList(sentence.split("\\W"));
        String translation = words
                .stream()
                .map(Main::getTranslatedWord)
                .collect(Collectors.joining(" "));

        System.out.println(translation);
        saveTranslation(translation,"Ukrainian.out");
        return translation;
    }

    public static String getTranslatedWord(String word){
        String translation = word;
        if (dictionary.get(word)!=null){
            translation = dictionary.get(word);
        }
        return translation;
    }

    public static void saveTranslation(String translation, String fileName){

        File file = new File("C:\\Users\\TanyaK\\Downloads\\" + fileName);
        try ( PrintWriter writer = new PrintWriter(file)){
            writer.println(translation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void saveDictionary(){

        File file = new File("C:\\Users\\TanyaK\\Downloads\\dictionary");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(dictionary);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadDictionary(){

        File file = new File("C:\\Users\\TanyaK\\Downloads\\dictionary");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))){
            dictionary = (Map<String, String>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}