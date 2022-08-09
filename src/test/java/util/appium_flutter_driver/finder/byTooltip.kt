@file:JvmName("_FinderRawMethods")
@file:JvmMultifileClass
package util.appium_flutter_driver.finder

fun byTooltip(input: String): FlutterElement {
  return FlutterElement(mapOf(
          "finderType" to "ByTooltipMessage",
          "text" to input
  ))
}
