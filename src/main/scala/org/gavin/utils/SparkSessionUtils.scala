package org.gavin.utils

import org.apache.commons.lang3.StringUtils
import org.apache.log4j.Logger
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/6 17:51
 * * Description  : 构建SparkSession工具类
 * * Modified by  : 
 * * Version      : 
 **/
object SparkSessionUtils {
  private val logger = Logger.getLogger(SparkSessionUtils.getClass)

  /**
   * 构建SparkSession Builder
   * @param application_name 任务名称
   * @param spark_conf_file 配置文件名称
   */
  private def initSparkSessionBuilder(application_name : String,spark_conf_file : String): SparkSession.Builder ={
    val conf = new SparkConf()
    var sparkConfFile = spark_conf_file
    conf.setAppName(application_name)
    if(spark_conf_file.equals("spark-local-file.properties") || StringUtils.isBlank(spark_conf_file) || StringUtils.isEmpty(spark_conf_file)) {
      sparkConfFile = this.getClass.getClassLoader.getResource("spark-local-file.properties").getPath
    }else{
      sparkConfFile = this.getClass.getClassLoader.getResource("spark-master-file.properties").getPath
    }
    
    val map = new LoadSparkProps(sparkConfFile).load()
    for(key <- map.keySet){
      conf.set(key,map.get(key).get.toString)
      logger.info(s"setting spark configuration : ${key} = ${map.get(key).get.toString}")
    }
    SparkSession.builder().config(conf)
  }

  /**
   * 构建SparkSession
   * @param application_name
   * @param spark_conf_file
   * @param is_enable_hive
   */
  def initSparkSessionWithHive(application_name : String,spark_conf_file : String,is_enable_hive : Boolean) = {
    val spark_builer = initSparkSessionBuilder(application_name,spark_conf_file)
    if(is_enable_hive) spark_builer.enableHiveSupport()
    val spark_session = spark_builer.getOrCreate()
    printSparkConf(spark_session)
    spark_session
  }

  /**
   * SparkSession stop
   * @param spark_session
   */
  def stopSparkSession(spark_session : SparkSession) = {
    logger.info("spark session stop ....")
    spark_session.stop() 
  }

  /**
   * 打印Spark配置参数
   * @param spark
   */
  private def printSparkConf(spark : SparkSession) = {
    val conf = spark.conf.getAll.foldRight("")((a,b) => b + a._1 + "=" + a._2 + "\n")
    logger.info("\n---------------Spark Configuration---------------\n"
      +conf+
      "\n---------------Spark Configuration---------------\n")
  }
  
}
