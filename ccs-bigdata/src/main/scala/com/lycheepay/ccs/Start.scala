package com.lycheepay.ccs

import java.util.Date

import com.lycheepay.SettlementService
import com.lycheepay.ccs.Start.args
import com.lycheepay.ccs.remote.dto.ClearingDTO
import org.slf4j.LoggerFactory

/**
  * Created by Administrator on 2017/10/30.
  */
object Start extends App{
  def run(env:String, clearingDTO: ClearingDTO): Unit ={
    val logger = LoggerFactory.getLogger(this.getClass)
    if (clearingDTO.getOptType == null) {
      logger.error("清算操作类型错误，没有找到操作类型")
      return;
    }
    logger.info("清算操作开始：{}",clearingDTO.getOptType)
    Env.init(env)
    if (clearingDTO.getOptType==ClearingDTO.OptType.CLEARING) {
      SettlementService.clearing(clearingDTO)
    } else if (clearingDTO.getOptType==ClearingDTO.OptType.GENSETTLEMENT) {
      SettlementService.genSettlement(clearingDTO);
    } else if (clearingDTO.getOptType==ClearingDTO.OptType.RECLEARING) {
      SettlementService.reclearing(clearingDTO)
    }/* else if (clearingDTO.getOptType==ClearingDTO.OptType.SYNC_TRADE_RECORD) {
      settlementService.reclearing()
    }*/
    logger.info("清算结算：{}",clearingDTO.getOptType)
  }
  args(0)="dev"
  args(1)="clearing"
  val clearingDTO: ClearingDTO = new ClearingDTO()
  clearingDTO.setOptType(ClearingDTO.OptType.CLEARING)
  run("dev",clearingDTO)
}
