// COMP2850 Portfolio: Week 3
// Tests for median()

import io.kotest.core.spec.style.FreeSpec
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.floats.plusOrMinus

const val tolerance = 0.000001f

@Suppress("Unused")
class MedianTest : FreeSpec({
    "Exception when size=0" {
        shouldThrow<IllegalArgumentException> {
            median(listOf())
        }
    }

    "Median of one value is that value" {
        median(listOf(7f)) shouldBe (7f plusOrMinus tolerance)
    }

    "Median of two values is their mean" {
        median(listOf(9f, 2f)) shouldBe (5.5f plusOrMinus tolerance)
    }

    "Median of three values is the middle after sorting" {
        median(listOf(9f, 1f, 4f)) shouldBe (4f plusOrMinus tolerance)
    }

    "Median of four values is the mean of the two middle after sorting" {
        median(listOf(9f, 1f, 4f, 2f)) shouldBe (3f plusOrMinus tolerance)
    }
})
