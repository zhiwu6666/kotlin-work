// COMP2850 Portfolio: Week 2
// Functions for working with triangle geometry

import kotlin.math.sqrt

typealias Triangle = Triple<Double,Double,Double>

fun isValidTriangle(triangle: Triangle): Boolean {
    val (a, b, c) = triangle
    return a < b + c && b < a + c && c < a + b
}

fun triangleArea(triangle: Triangle): Double {
    require(isValidTriangle(triangle)) { "Invalid triangle" }
    val (a, b, c) = triangle
    val semiperimeter = (a + b + c) / 2
    return sqrt(semiperimeter * (semiperimeter - a) * (semiperimeter - b) * (semiperimeter - c))
}
