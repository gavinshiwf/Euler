package com.gavin.conf;

import com.gavin.service.EtlException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/10 19:00
 * * Description  : 获取配置信息
 * * Modified by  :
 * * Version      :
 **/
public class ConfigManager {
    private static Properties prop = null;
    private static final Logger logger = Logger.getLogger(ConfigManager.class);

    /**
     * 装载配置文件
     */
    static{
        prop = new Properties();
        //测试环境地址
        System.setProperty("CONF","E:\\prj\\Euler\\conf\\");
        logger.info("euler properties :"+ FilenameUtils.concat(System.getProperty("CONF"),"euler.properties"));
        File confFile = new File(FilenameUtils.concat(System.getProperty("CONF"),"euler.properties"));
        
        if(!confFile.exists()){
            throw new EtlException("Euler Properties not exists ...");
        }

        try {
            InputStream input = new BufferedInputStream(new FileInputStream(confFile));
            prop.load(input);
            input.close();
            logger.info("euler properties load successful ...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new EtlException(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new EtlException(e);
        }
    }

    /**
     * 获取指定key的值
     * @param key
     * @return
     */
    public static String getConfValue(String key){
        return prop.getProperty(key);
    }

    /**
     * 获取指定Key的值，如果key的值不存在，则返回默认值
     * @param key
     * @param default_value
     * @return
     */
    public static String getConfValueByDefault(String key,String default_value){
        String value = prop.getProperty(key);
        if(StringUtils.isBlank(value)){
            return default_value;
        }else{
            return value;
        }
    }
}
