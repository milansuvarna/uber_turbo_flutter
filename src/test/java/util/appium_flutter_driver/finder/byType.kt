@file:JvmName("_FinderRawMethods")
@file:JvmMultifileClass
package util.appium_flutter_driver.finder

fun byType(input: String): FlutterElement {
  return FlutterElement(mapOf(
          "finderType" to "ByType",
          "type" to input
  ))
}
