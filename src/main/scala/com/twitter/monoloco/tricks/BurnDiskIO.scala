package com.twitter.monoloco.tricks

import com.twitter.monoloco.{Logging, CodeTrick}

import java.util.concurrent.TimeUnit._
import java.io.{BufferedOutputStream, FileOutputStream, File}
import java.math.BigInteger
import java.security.SecureRandom
import java.util.concurrent.{Executors, ExecutorService}

class WriteDiskTask extends Runnable with Logging {
  def run() {
    val rand = new BigInteger(13, new SecureRandom).toString(32)
    val data = new BigInteger(200, new SecureRandom).toString(32)
    val fos = new BufferedOutputStream(new FileOutputStream(
      new File("/tmp/monoloco-" + rand)), 8192)
    while(true) {
      if (Thread.interrupted()) {
        return
      } else {
        logger.info("[%s] writing", Thread.currentThread.getId)
        fos.write(data.getBytes)
      }
    }
    fos.close()
  }
}

class BurnDiskIO extends CodeTrick {

  def duration() = (5L, MINUTES)

  var pool:ExecutorService = null

  def start() {
    pool = Executors.newFixedThreadPool(1)
    (1 to 1) foreach { xs => pool.execute(new WriteDiskTask)}
  }

  def stop() {
    pool.shutdownNow()
  }
}
