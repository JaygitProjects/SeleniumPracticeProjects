package uk.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
   Properties prop;
    public ReadConfig(){

        //to get the config file


        File src = new File(System.getProperty("user.dir")+"/src/test/resources/Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            prop = new Properties();
            try {
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

// read each value
    public String readAppUrl(){
        String url = prop.getProperty("url");
          return url;
    }
    public String readUserId(){
        String uName = prop.getProperty("userId");
        return uName;
    }
    public String readPassword(){
        String pWord = prop.getProperty("password");
        return pWord;
    }

    //drivers path
    public String readChromePath(){
        String chromePath = prop.getProperty("chromePath");
        return chromePath;
        }
        public String readGeckoPAth(){
        String geckoPath = prop.getProperty("geckoPath");
        return geckoPath;
        }

}
