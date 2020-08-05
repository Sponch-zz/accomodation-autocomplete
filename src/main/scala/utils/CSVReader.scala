package utils

import java.io.File

import model.Hotel

trait FileReader[A] {
  def read(file: File): List[A]
}

trait CSVReader extends FileReader[Hotel] {
  override def read(file: File): List[Hotel] = {
    val bs = io.Source.fromFile(file)
    val list = bs.getLines().drop(1).map { line =>
      val items = line.split(",").map(_.trim)
      Hotel(items(0).toLong, items(1), items(2),items(3), items(4).toLong, items(5).toInt)
    }
    list.toList
  }
}
