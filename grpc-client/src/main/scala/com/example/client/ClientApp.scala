package com.example.client

object ClientApp {
  def main(args: Array[String]): Unit = {
    try {
      val query = "Sample query from Scala client"
      // 调用 Java 工具方法发送请求
      val response = GrpcClientUtil.sendRequest(query)
      println("Client received response:")
      println(s"Status: ${response.getStatus}")
      println(s"Response Metadata - requestId: ${response.getMetadata.getRequestId}, timestamp: ${response.getMetadata.getTimestamp}")
      // 遍历并打印每个结果 detail
      response.getResultsList.forEach { detail =>
        println(s"Detail: info = ${detail.getInfo}, count = ${detail.getCount}")
      }
    } catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }
}