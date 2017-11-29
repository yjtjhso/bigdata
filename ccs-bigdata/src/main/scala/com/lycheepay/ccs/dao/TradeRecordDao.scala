package com.lycheepay.ccs.dao


import com.lycheepay.ccs.db.DB
import com.lycheepay.ccs.spark.SparkService
import org.apache.hadoop.fs.{FileSystem, Path}

/**
  * Created by Administrator on 2017/10/30.
  */
object TradeRecordDao {
  def syncTradeRecord2CCS(): Unit ={
    val dataFrame = DB.get().queryAll("t_clearing_rule")
    dataFrame.foreach((row) => {
      println(row.get(0))
    }:Unit)
    FileSystem.get(SparkService.get().spark.sparkContext.hadoopConfiguration).deleteOnExit(new Path(""))
  }
}
