package org.gavin.controller

import org.apache.log4j.Logger
import org.gavin.utils.{EulerOptions, EulerProps}

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/9 16:27
 * * Description  : 控制类
 * * Modified by  : 
 * * Version      : 
 **/
object EulerController {
  private val logger = Logger.getLogger(EulerController.getClass)
  def process(action : String , param : String): Unit ={
    val strActionClass = EulerProps.action_map.get(action).get
    try{
      val actionClass = Class.forName(strActionClass)
      logger.info(s"load action class ${strActionClass}")
      
      //通过反射机制调用相关类的方法
      
    }
  }
}
