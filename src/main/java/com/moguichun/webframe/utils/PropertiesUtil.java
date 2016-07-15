package com.moguichun.webframe.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * A class read properties file' value.
 * <p>according to config-swithch.properties file's value to determine<br>
 * read config-online.properties or config-test.properties file's value.</p>
 *
 * @author MoGuichun
 * @version V1.0
 * @ClassName: PropertiesUtil
 * @Description: A class read properties file' value.
 * @date 2016年5月10日 上午10:53:01
 */
public class PropertiesUtil {

    private static Properties configProperties;
    private final static String SWITCH_FILE = "config-switch.properties";
    private final static String PRODUCT_FILE = "config-product.properties";
    private final static String TEST_FILE = "config-test.properties";

    /**
     * A method analyzing current environment.
     *
     * @return Boolean
     * @Title: initUtil
     * @Description: A method analyzing current environment.
     */
    private static Boolean isTestConfigRuntime() {
        Properties switchProperties = getProperties(SWITCH_FILE);
        if (switchProperties.getProperty("switch").equals("0")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * A method load properties file.
     *
     * @param filename file's name
     * @return A Properties - java.util.Properties
     * @Title: getProperties
     * @Description: load properties file
     */
    private static Properties getProperties(String filename) {
        Properties properties = new Properties();

        InputStreamReader is;
        try {
            is = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(filename), "UTF-8");
            properties.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("找不到：“" + filename + "” 配置文件！");
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * A method read config file's value.
     * <p>according to config-swithch.properties file's value to determine<br>
     * read config-online.properties or config-test.properties file's value.</p>
     *
     * @param key value's key
     * @return A String - the key's value
     * @Title: getProperty
     * @Description: A method read config file's value.
     */
    public static String getConfigProperty(String key) {
        configProperties = isTestConfigRuntime() ? getProperties(TEST_FILE) : getProperties(PRODUCT_FILE);
        String value = configProperties.getProperty(key);
        if (key == null || value == null) {
            try {
                throw new NoSuchPropertyException("找不到：“" + key + "” 配置属性！");
            } catch (NoSuchPropertyException e) {
                e.printStackTrace();
            }
        }
        return value;
    }

}

class NoSuchPropertyException extends Exception {

    private static final long serialVersionUID = -9199251835427552322L;

    public NoSuchPropertyException(String message) {
        super(message);
    }

}
