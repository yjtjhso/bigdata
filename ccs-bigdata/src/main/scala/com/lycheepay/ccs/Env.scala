package com.lycheepay.ccs

import java.util.Properties

import org.slf4j.LoggerFactory

/**
  * Created by Administrator on 2017/10/30.
  */
object Env {
  private var env:Env = null
  def init(envMode:String): Env ={
    env = new Env(envMode)
    env
  }
  def get(): Env ={
    if (null == env) env = new Env(null)
    return env
  }
}
class Env(env:String, val default:String="dev"){
  private val logger = LoggerFactory.getLogger(classOf[Env])
  val envMode=if(null==env) default else env
  logger.info("环境模式："+envMode)
//  logger.info("SparkService init")
  logger.info("读取配置文件："+envMode+"-db.properties")
  val configured = new Properties()
  configured.load(this.getClass.getClassLoader.getResourceAsStream(envMode+"-db.properties"))
  val dbConf = new Properties()
  dbConf.put("host", configured.getProperty("db.host"))
  dbConf.put("user", configured.getProperty("db.username"))
  dbConf.put("password", configured.getProperty("db.password"))
  dbConf.put("driver", configured.getProperty("db.driver"))
}
