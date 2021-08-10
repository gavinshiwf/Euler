package org.gavin.inc

import java.security.KeyStore.TrustedCertificateEntry

import org.apache.log4j.Logger
import org.apache.spark.sql.SparkSession
import org.gavin.utils.{SparkSessionUtils, SparkUtils}

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/9 16:59
 * * Description  : 增量同步入口类
 * * Modified by  : 
 * * Version      : 1.0
 **/
class EulerInc(action_name : String){
  private val logger = Logger.getLogger("EulerInc")
  private lazy val application_name : String = s"Euler ${action_name} Table "+"["+SparkUtils.getNow+"]"
  private lazy val ss : SparkSession = SparkSessionUtils.initSparkSessionWithHive(application_name,"",true)
  /**
   * 增量同步处理
   * @param action_values
   */
  def handle(action_values : String) = {
    val parseVals = SparkUtils.parseActionValue(action_name,action_values)
    
  }
  
  
}
