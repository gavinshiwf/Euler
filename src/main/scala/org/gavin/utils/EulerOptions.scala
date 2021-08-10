package org.gavin.utils

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/6 16:13
 * * Description  : Euler工程参数说明
 * * Modified by  : 
 * * Version      : 1.0
 **/
object EulerOptions {
  final val OPTION_PARAM_INC_BATCH = "inc-batch"            //增量同步，按批次
  final val OPTION_PARAM_INC_TABLE = "inc-table"            //增量同步，按表
  final val OPTION_PARAM_MERGE_BATCH = "merge-batch"        //merge操作，按批次
  final val OPTION_PARAM_MERGE_TABLE = "merge-table"        //merge操作，按表
  final val OPTION_PARAM_INIT_HIS_DATA = "init-his-data"    //初始化历史数据
  final val OPTION_PARAM_INIT_JOB = "init-job"              //初始化任务
  final val OPTION_PARAM_DDL = "ddl"                        //表结构同步
}
