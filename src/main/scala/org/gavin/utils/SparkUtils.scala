package org.gavin.utils

import java.text.SimpleDateFormat
import java.util.Date

import scala.collection.mutable.ListBuffer

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/9 17:23
 * * Description  : Spark 工具类
 * * Modified by  : 
 * * Version      : 1.0
 **/
object SparkUtils {

  /**
   * 获取当前时间
   * @return
   */
  def getNow : String = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    formatter.format(new Date()) 
  }

  /**
   * 解析传入进来的值，解析成 'tab1','tab2' ... 或 '1' 等格式
   * @param action_name
   * @param action_value
   * @return
   */
  def parseActionValue(action_name : String,action_value : String) : String = {
    var value = ""
    var list : ListBuffer[String] = ListBuffer[String]()
    if(action_name.endsWith("table")){
      val tabArr = action_value.split(",")
      tabArr.foreach(list += _.toUpperCase)
      value = tabArr.map(","+_+",").mkString(",")
    }else{
      val batchArr = action_value.split(",")
      //如果批量的值有多个，则报错
      if(batchArr.length > 1) throw new RuntimeException(s"batch parameter value too much ${action_value} ...")
      batchArr.foreach(list += _)
      value = batchArr.map(","+_+",").mkString(",")
    }
    value
  }
}
