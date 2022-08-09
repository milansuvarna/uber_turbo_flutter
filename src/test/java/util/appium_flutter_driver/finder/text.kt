@file:JvmName("_FinderRawMethods")
@file:JvmMultifileClass
package util.appium_flutter_driver.finder

fun text(input: String): FlutterElement {
  return FlutterElement(mapOf(
          "finderType" to "ByText",
          "text" to input
  ))
}
