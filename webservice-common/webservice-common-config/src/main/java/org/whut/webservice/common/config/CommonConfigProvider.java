package org.whut.webservice.common.config;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: yangyang
 * Date: 15-7-4
 * Time: 上午10:46
 * To change this template use File | Settings | File Templates.
 */
public class CommonConfigProvider {
    private static final Logger logger =
            LoggerFactory.getLogger(CommonConfigProvider.class);
    public static final String FILE_PREFIX = "file:";
    public static final String CLASSPATH_PREFIX = "classpath:";
    public static final String DEFAULT_CONFIG_PATH = "classpath:/common.config.properties";

    private static Properties prop = null;

    public static Properties getProp() {
        if (prop == null) {
            init();
        }
        return prop;
    }

    public static synchronized void init() {
        //已经初始化，则直接返回
        if (CommonConfigProvider.prop != null
                && CommonConfigProvider.prop.size() > 0) {
            return;
        }

        logger.info("init CommonConfigProvider.prop.");
        Properties properties = ConfigProperties.getProperties();
        if (properties != null && properties.size() > 0) {
            CommonConfigProvider.prop = properties;
            logger.info("find properties from ConfigProperties");
        } else {
            String configPath = System.getProperty(Constants.CONFIG_PATH);

            if (configPath == null) {
                logger.info("can't load config from:System.getProperty(Constants.CONFIG_PATH)");
                configPath = System.getenv(Constants.CONFIG_PATH);
                logger.info("can't load config from:System.getenv(Constants.CONFIG_PATH)");
                if (configPath == null) {
                    logger.error("config.path is null，now we use default config.if the environment is not dev,please check you startup param: -Dconfig.path=xxx");
                    configPath = DEFAULT_CONFIG_PATH;
                }
            }
            logger.info("config.path:{}", configPath);

            Properties configs = new Properties();
            FileInputStream fileInputStream = null;
            InputStream inputStream = null;
            try {
                if (configPath.startsWith(FILE_PREFIX)) {
                    configPath = configPath.substring(FILE_PREFIX.length());
                    fileInputStream = new FileInputStream(new File(configPath));
                    configs.load(fileInputStream);
                } else if (configPath.startsWith(CLASSPATH_PREFIX)) {
                    configPath = configPath
                            .substring(CLASSPATH_PREFIX.length());
                    inputStream = CommonConfigProvider.class
                            .getResourceAsStream(configPath);
                    configs.load(inputStream);
                }
                CommonConfigProvider.prop = configs;
            } catch (FileNotFoundException e) {
                logger.error("", e);
            } catch (IOException e) {
                logger.error("", e);
            } finally {
                IOUtils.closeQuietly(fileInputStream);
                IOUtils.closeQuietly(inputStream);
            }
        }

        logger.info("CommonConfigProvider.prop ={},size:{}",
                CommonConfigProvider.prop,
                CommonConfigProvider.prop.size());
    }

    public Properties getProperties() {
        return getProp();
    }

    public static String get(String key) {
        return getProp().getProperty(key);
    }

    public static Integer getInt(String key) {
        String value = get(key);
        try {
            return Integer.parseInt(value);
        } catch (Exception ex) {
            logger.error("get int error, return null.", ex);
            return null;
        }
    }

    public static boolean getBoolean(String key) {
        String value = get(key);
        return Boolean.valueOf(value);
    }

    public static Double getDouble(String key) {
        String value = get(key);
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            logger.error("get int error, return null.", e);
            return null;
        }
    }

    public static Long getLong(String key) {
        String value = get(key);
        try {
            return Long.parseLong(value);
        } catch (Exception e) {
            logger.error("get int error, return null.", e);
            return null;
        }
    }
}
