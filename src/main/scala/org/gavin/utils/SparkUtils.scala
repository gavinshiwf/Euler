package org.gavin.utils

import java.text.SimpleDateFormat
import java.util.Date

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
}
