package org.gavin.utils

import java.util.Properties

import joptsimple.{OptionSet, OptionSpec}

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/9 14:45
 * * Description  : 将输入参数转换成properties
 * * Modified by  : 
 * * Version      : 
 **/
object Options2Props {
  def asProperties(options : OptionSet) : Properties = {
    val props = new Properties()
    val entrys = options.asMap().entrySet()
    entrys.forEach((entry : java.util.Map.Entry[OptionSpec[_],java.util.List[_]]) => {
      val spec = entry.getKey
      val values = entry.getValue
      if(!values.isEmpty){
        props.setProperty(propKeys(spec),values.toArray().mkString(","))
      }
    })
    props
  }

  def propKeys(spec : OptionSpec[_]) : String={
    var returnVal = ""
    val keys = spec.options()
    if(keys.size() > 1){
      throw new IllegalArgumentException(s"invalid parameters:"+keys.toString)
    }

    keys.forEach((key : String)=>{
      //确保有效参数
      if(key.length > 0){
        returnVal = key
      }
    })
    returnVal
  }
}
