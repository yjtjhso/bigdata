package com.lycheepay.ccs.spark

import java.util.Properties

import com.lycheepay.ccs.Env
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by Administrator on 2017/11/2.
  */
object SparkService{
  private var sparkService:SparkService = null
  def get(): SparkService ={
    if (null == sparkService) {
      sparkService = new SparkService()
      sparkService.init()
    }
    return sparkService
  }
}
class SparkService {
  private val logger = LoggerFactory.getLogger(classOf[SparkService])
  private var sc:SparkContext = null
  private var conf:SparkConf = null
  private val env = Env.get()
  var spark:SparkSession = null
  private def init(): Unit ={
    logger.info("spark init begin")
    conf = new SparkConf().setAppName(env.configured.getProperty("app.name")).setMaster(env.configured.getProperty("spark.master"))
    sc = new SparkContext(conf)
    spark = SparkSession.builder().config(conf).getOrCreate()
    logger.info("spark init end")
  }
}
