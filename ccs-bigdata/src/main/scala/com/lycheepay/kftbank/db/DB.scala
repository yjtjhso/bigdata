package com.lycheepay.kftbank.db

import java.util.Properties

import com.lycheepay.ccs.Env
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession

/**
  * Created by Administrator on 2017/10/30.
  */
object DB {
  def get(): DB ={
    return new DB(1)
  }
  get()
}
class DB{
  private var sc:SparkContext = null
  private var conf:SparkConf = null
  private var spark:SparkSession = null
  def this(i:Int){
    this()
    init()
  }
  private def init(): Unit ={
    val inputStream = Env.getClass.getClassLoader.getResourceAsStream(Env.get().envMode+"-db.properties")
    val prop:Properties = new Properties()
    prop.load(inputStream)
    val host = prop.getProperty("db.host")
    val name = prop.getProperty("db.name")
    val password = prop.getProperty("db.password")
    conf = new SparkConf().setAppName("ccs").setMaster(prop.getProperty("spark.master"))
    sc = new SparkContext(conf)
    spark = SparkSession.builder().getOrCreate()
  }
  def queryTable(tableName:String): Unit = {
//    spark.sqlContext.read.jdbc()
  }
}
