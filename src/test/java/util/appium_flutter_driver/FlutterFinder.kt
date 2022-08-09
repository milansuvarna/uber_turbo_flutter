package util.appium_flutter_driver

import java.util.regex.Pattern

import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.FileDetector
import util.appium_flutter_driver.finder.FlutterElement
import util.appium_flutter_driver.finder.ancestor as _ancestor
import util.appium_flutter_driver.finder.bySemanticsLabel as _bySemanticsLabel
import util.appium_flutter_driver.finder.byTooltip as _byTooltip
import util.appium_flutter_driver.finder.byType as _byType
import util.appium_flutter_driver.finder.byValueKey as _byValueKey
import util.appium_flutter_driver.finder.descendant as _descendant
import util.appium_flutter_driver.finder.pageBack as _pageBack
import util.appium_flutter_driver.finder.text as _text


class FlutterFinder(driver: RemoteWebDriver) {
  private val driver = driver
  private val fileDetector = FileDetector({ _ -> null })
  fun ancestor(of: FlutterElement, matching: FlutterElement, matchRoot: Boolean = false): FlutterElement {
    val f = _ancestor(of, matching, matchRoot)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun ancestor(of: FlutterElement, matching: FlutterElement): FlutterElement {
    val f = _ancestor(of, matching)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun bySemanticsLabel(label: String): FlutterElement {
    val f = _bySemanticsLabel(label)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun bySemanticsLabel(label: Pattern): FlutterElement {
    val f = _bySemanticsLabel(label)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun byTooltip(input: String): FlutterElement {
    val f = _byTooltip(input)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun byType(input: String): FlutterElement {
    val f = _byType(input)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun byValueKey(input: String): FlutterElement {
    val f = _byValueKey(input)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun byValueKey(input: Int): FlutterElement {
    val f = _byValueKey(input)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun descendant(of: FlutterElement, matching: FlutterElement, matchRoot: Boolean = false): FlutterElement {
    val f = _descendant(of, matching, matchRoot)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun descendant(of: FlutterElement, matching: FlutterElement): FlutterElement {
    val f = _descendant(of, matching)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun pageBack(): FlutterElement {
    val f = _pageBack()
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
  fun text(input: String): FlutterElement {
    val f = _text(input)
    f.setParent(driver)
    f.setFileDetector(fileDetector)
    return f
  }
}
