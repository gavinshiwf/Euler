package org.gavin.utils

import java.io.FileInputStream
import java.util.Properties

import scala.collection.JavaConverters

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/6 18:07
 * * Description  : 加载Spark配置参数
 * * Modified by  : 
 * * Version      : 
 **/
class LoadSparkProps(spark_conf_file : String) {
  var map : scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map()

  /**
   *解析spark配置文件中所有的参数
   */
  def load() = {
    val props : Properties = new Properties()
    props.load(new FileInputStream(spark_conf_file))
    map = JavaConverters.propertiesAsScalaMap(props)
    map
  }
}
