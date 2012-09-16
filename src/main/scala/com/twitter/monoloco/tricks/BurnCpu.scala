package com.twitter.monoloco.tricks

import java.util.concurrent.TimeUnit.SECONDS
import com.twitter.monoloco.CodeTrick
import javax.crypto.{KeyGenerator, Cipher}
import java.security.SecureRandom
import java.math.BigInteger
import java.util.concurrent.{Executors, ExecutorService, ThreadPoolExecutor}

class CipherUpdate extends Runnable {

  def run() {
    val keyGenerator = KeyGenerator.getInstance("AES")
    keyGenerator.init(256)
    val secretKey = keyGenerator.generateKey()
    val cipher = Cipher.getInstance("AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    (1 to 100000) foreach { x =>
      if (Thread.interrupted()) {
        return
      } else {
        cipher.update(new BigInteger(131232, new SecureRandom).toString(32).getBytes)
      }
    }
  }

}

class BurnCpu extends CodeTrick {

  def duration() = (30L, SECONDS)

  var pool:ExecutorService = null

  def start() {
    val i = Runtime.getRuntime.availableProcessors();
    pool = Executors.newFixedThreadPool(i)
    (1 to i) foreach { xs => pool.execute(new CipherUpdate)}
  }

  def stop() {
    pool.shutdownNow()
  }


}
