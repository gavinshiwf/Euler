import org.junit.Test

import scala.collection.mutable.ArrayBuffer

/**
 * * Author       : Gavin
 * * Date         : Created in 2021/8/6 17:10
 * * Description  : ${description}
 * * Modified by  : 
 * * Version      : 
 **/
class EulerTest {
  @Test
  def testEulerParams(): Unit ={
    val args_array = ArrayBuffer[String]()
    args_array.append("--inc-table")
    args_array.append("table1,table2")
    //args_array.append("--inc-batch")
    //args_array.append("1,2")
    
    Euler.main(args_array.toArray)
    
    
  }
  
  
}
