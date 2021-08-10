package org.gavin.utils

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/9 15:15
 * * Description  : Euler工程相关信息
 * * Modified by  : 
 * * Version      : 
 **/
object EulerProps {
  //action对应的类名
  final val action_map : scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map(
    "inc-table" -> "org.gavin.inc.EulerInc",
    "inc-batch" -> "org.gavin.inc.EulerInc",
    "merge-table" -> "org.gavin.merge.EulerMerge",
    "merge-batch" -> "org.gavin.merge.EulerMerge",
    "init-his-data" -> "org.gavin.synchis.EulerSyncHis",
    "ddl" -> "org.gavin.ddl.EulerDDL"
  )
  
  //spark参数文件
  final lazy val SPARK_CONF_DEFAULT_FILENAME = "spark-local-file.properties"
  final lazy val SPARK_CONF_MASTER_FILENAME = "spark-master-file.properties"
}
