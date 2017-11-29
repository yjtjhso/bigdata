package com.lycheepay

import java.util.Date

import com.lycheepay.ccs.dao.TradeRecordDao
import com.lycheepay.ccs.remote.dto.ClearingDTO

/**
  * Created by Administrator on 2017/10/30.
  */
object SettlementService {
  private def syncTradeRecord(clearingDTO: ClearingDTO): Unit ={
    println("syncTradeRecord run")
    val dataFrame = TradeRecordDao.syncTradeRecord2CCS()
    println(clearingDTO)
  }

  def reclearing(clearingDTO: ClearingDTO): Unit = {
    println("reclearing run")
    println(clearingDTO)
  }
  def clearing(clearingDTO: ClearingDTO): Unit = {
    println("clearing run")
    syncTradeRecord(clearingDTO)
    println(clearingDTO)
  }
  def genSettlement(clearingDTO: ClearingDTO): Unit ={
    println("genSettlement run")
    println(clearingDTO)
  }
}
