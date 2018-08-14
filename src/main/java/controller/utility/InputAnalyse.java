package controller.utility;


import java.util.Properties;

public class InputAnalyse {
    private Properties regexProperties;

    /**
     * Method get regex from properties and matches with word
     * @param inputWord string to check
     * @param regexPropertyKey property key to get regex from properties
     * @return if given word mathes to regex
     */
    public boolean checkInputByRegex(String inputWord, String regexPropertyKey){
        inputWord.matches(regexProperties.getProperty(regexPropertyKey));
        return inputWord.matches(regexProperties.getProperty(regexPropertyKey));
    }

    /**
     * Method sets properties which contain regexes
     * @param regexProperty
     */
    public void setRegexProperty(Properties regexProperty) {
        this.regexProperties = regexProperty;
    }

    public Properties getRegexProperty() {
        return regexProperties;
    }

    public boolean checkInputByRegex(String inputWord, String regexPropertyKey, Languages language){
        Properties properties = language.getRegexProperties();
        return inputWord.matches(properties.getProperty(regexPropertyKey));
    }

}
