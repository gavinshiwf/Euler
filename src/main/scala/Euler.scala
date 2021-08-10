import joptsimple.OptionParser
import org.apache.log4j.Logger
import org.gavin.utils.{EulerOptions, EulerProps, Options2Props}

import scala.collection.JavaConverters

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/6 15:52
 * * Description  : Euler工程入口类
 * * Modified by  : 
 * * Version      : 1.0
 **/
object Euler extends App {
  private val logger = Logger.getLogger(Euler.getClass)
  val parser = new OptionParser()
  val helpInfo = parser.acceptsAll(java.util.Arrays.asList("help","h"),"帮助信息. 注意(系统级别说明): 自定义变量不能使用euler或EULER开头").forHelp()
  parser.accepts(EulerOptions.OPTION_PARAM_INC_TABLE,"按表进行增量同步 eg: inc-table table1,table2...").withRequiredArg()
  parser.accepts(EulerOptions.OPTION_PARAM_INC_BATCH,"按批次进行增量同步 eg: inc-batch batch:1").withRequiredArg()
  parser.accepts(EulerOptions.OPTION_PARAM_MERGE_TABLE,"按表进行MERGE操作 eg: merge-table table1,table2...").withRequiredArg()
  parser.accepts(EulerOptions.OPTION_PARAM_MERGE_BATCH,"按批次进行MERGE操作 eg: merge-batch 1").withRequiredArg()
  //parser.accepts(EulerOptions.OPTION_PARAM_INIT_JOB,"初始化任务").withRequiredArg()
  parser.accepts(EulerOptions.OPTION_PARAM_INIT_HIS_DATA, "初始化历史数据,只针对表操作，不能针对于批次操作 eg: sync-his-data table1,table2..").withRequiredArg()
  parser.accepts(EulerOptions.OPTION_PARAM_DDL,"同步上游表结构, eg : ddl or ddl-batch 1 or ddl-table table1,table2...").withRequiredArg()

  //解析参数数组
  val options = parser.parse(args : _*)
  if(args == null || args.length == 0 || options.has(helpInfo)){
    parser.printHelpOn(System.out)
    System.exit(0)
  }

  //解析所有输入参数，并传入到map中
  val inputParams = JavaConverters.propertiesAsScalaMap(Options2Props.asProperties(options))
  logger.info(s"input parameters : ${inputParams}")
  
  //验证输入action参数，入参超过1个，直接抛出异常
  val keys = inputParams.keySet
  if(keys.size > 1){
    logger.error("action parameters too much...")
    System.exit(1)
  }
  
  //获取触发动作
  val action = keys.last
  logger.info(s"action parameter is ${action}")
  
  //检查action操作
  /*keys.foreach(key => {
    if(!EulerProps.action_map.contains(key)){
      logger.error(s"action ${key} don't support ...")
    }
  }
  )*/
  
  
  
  
  
  
}
