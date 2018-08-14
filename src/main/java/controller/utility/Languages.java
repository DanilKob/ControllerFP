package controller.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;


/**
 * Enumeration of available input languages
 */
public enum Languages {
    RUS(PropertyPath.RUS_REG),
    ENG(PropertyPath.ENG_REG);

    private final Properties regexProperties;
    private static Set<String> languageSet = new HashSet<>();

    static {
        setLanguages();
    }

    /**
     * Method fills String Set of all language names in enum
     */
    private static void setLanguages(){
        {
            for (Languages language : Languages.values()) {
                languageSet.add(language.name());
            }
        }
    }

    /**
     * Delegate method to check if enum contains given languageName
     * @param languageName
     * @return true if given language name exists
     */
    public static boolean contains(String languageName) {
        return languageSet.contains(languageName);
    }

    /**
     * Load text and regex properties by given path
     * @param regexPath - path to property file with regexes
     */
    Languages(String regexPath){
        this.regexProperties = loadProperty(regexPath);
    }

    /**
     * Method return properties with regexes for current language
     * @return Properies with regex rules
     */
    public Properties getRegexProperties(){
        return regexProperties;
    }

    private Properties loadProperty(String path){
        InputStream inputStream =null;
        Properties properties = new Properties();
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream(path);
            properties.load(inputStream);
        }catch(IOException io){
            io.printStackTrace();
        }finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}
