package utils

import org.scalatest.flatspec.AnyFlatSpec
import java.io.File

class CSVReaderTest extends AnyFlatSpec with CSVReader {

  "An reader" should "have read csv hotels" in {
    val path = getClass.getResource("/hotels.csv").getPath
    val file = new File(path)
    val hotels = read(file)
    assert(hotels.size == 20)
  }
}
