/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Works with application configuration.
 * @author Alim
 */
public class AppConfig {
    
    private AppConfig(){}

    public static final int MAX_TRY_LOGIN = 10;
    public static final boolean IS_TESTING = true;
    /**
     * returns path like this E:\Working\GitHub\...ApplicationName (without
     * slash)
     */

    public static String DIRECTORY_SEPERATOR = File.separator;

    private static String _appPath;
    private static String _pictureUploadPath;
    private static String _connectionConfigTextFilePath = "config.txt";
    private static List<String> _configFileLines;

    public static CustomConfiguration Configuration = readDefaultConfigFile();

    /**
     *
     * @return E:\Working\GitHub\....Application name\config.txt
     */
    public static String getAbsoluteServerConfigFilePath() {
        return getAppPath() + DIRECTORY_SEPERATOR + _connectionConfigTextFilePath;
    }

    /**
     * @return path like this E:\Working\GitHub\Simple-Chat-System (without
     * slash)
     *
     */
    public static String getAppPath() {
        if (AppConfig._appPath == null) {
            try {
                AppConfig._appPath = new File(".").getCanonicalPath();
            } catch (IOException ex) {
                Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _appPath;
    }

    /**
     * E:\Working\GitHub\....Application name\PictureUpload\
     *
     * @return getAppPath() + DIRECTORY_SEPERATOR + "PictureUpload" + DIRECTORY_SEPERATOR
     */
    public static String getPictureUploadPath() {
        if (AppConfig._pictureUploadPath == null) {
            _pictureUploadPath = getAppPath() + DIRECTORY_SEPERATOR + "PictureUpload" + DIRECTORY_SEPERATOR;
        }
        return _pictureUploadPath;
    }

    public static CustomConfiguration readDefaultConfigFile() {
        try {
            System.out.println(getAbsoluteServerConfigFilePath());
            _configFileLines = Files.readAllLines(Paths.get(getAbsoluteServerConfigFilePath()), Charset.defaultCharset());
        } catch (IOException ex) {
            Logger.getLogger(AppConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CustomConfiguration config = new CustomConfiguration(_configFileLines);
 
        return config;
    }
}
