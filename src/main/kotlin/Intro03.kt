
package examples.`10_ORX`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.LineCap
import org.openrndr.extra.fx.blur.BoxBlur
import org.openrndr.extra.noise.*
import org.openrndr.math.Vector2
import org.openrndr.math.Vector3
import org.openrndr.math.Vector4
import kotlin.math.abs

fun main() {
    application {
        program {

            val colors = listOf(
                ColorRGBa(1.0, 0.0, 0.0, 0.8),
                ColorRGBa(0.0, 1.0, 0.0, 0.8),
                ColorRGBa(0.0, 0.0, 1.0, 0.8),
                ColorRGBa(1.0, 1.0, 1.0, 0.8)
            )



            extend {
//                drawer.fill = ColorRGBa.PINK
                drawer.stroke = null
                drawer.translate(width / 2.0, height / 2.00)

                drawer.circles {
                    repeat(5000) {
//                       fill = Random.pick(colors)
                    circle(Vector2.uniformRing(mouse.position.x / 5, 250.0), Random.double(0.2, 2.0))
                    }
                }

            }
        }
    }
}