package com.lycheepay.ccs.db

import java.util.Properties

import com.lycheepay.ccs.Env
import com.lycheepay.ccs.spark.SparkService
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.slf4j.LoggerFactory

import scala.collection.JavaConverters._

/**
  * Created by Administrator on 2017/10/30.
  */
object DB {
  private var db:DB = null
  def get(): DB ={
    if (db == null) {
      db = new DB()
    }
    return db
  }
  get()
}
class DB{
  private val logger = LoggerFactory.getLogger(classOf[SparkService])
  def queryAll(tableName:String): DataFrame = {
    logger.info("查询表:{}",tableName)
    val dataFrame = SparkService.get().spark.sqlContext.read.jdbc(Env.get().dbConf.getProperty("host"), tableName, Env.get().dbConf)
    logger.info("查询表总数:{}",dataFrame.count())
    return dataFrame
  }
}