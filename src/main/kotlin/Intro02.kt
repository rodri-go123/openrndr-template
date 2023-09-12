package examples.`04_Drawing`

import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.color.rgb
import org.openrndr.draw.circleBatch
import org.openrndr.draw.rectangleBatch
import org.openrndr.draw.shadeStyle
import org.openrndr.extra.camera.Camera2D
import org.openrndr.shape.Circle
import org.openrndr.extra.noise.Random
import org.openrndr.math.Polar
import org.openrndr.math.Vector2
import org.openrndr.shape.Rectangle

fun main() {
    application {

        configure {
            width = 1000
            height = 800
        }

        program {
            val colors = listOf(
                ColorRGBa(1.0, 0.0, 0.0, 0.8),
                ColorRGBa(0.0, 1.0, 0.0, 0.8),
                ColorRGBa(0.0, 0.0, 1.0, 0.8),
                ColorRGBa(1.0, 1.0, 1.0, 0.8)
            )

            var mousePos: Vector2? = null

            extend(Camera2D())
//
            mouse.moved.listen {
                mousePos = it.position
            }

            extend {

                for (i in 0..9) {
                    mousePos?.let {
                        drawer.translate( it.x / 2.0, it.y / 2.0)
                    }
                    drawer.points {
                        repeat(30000) {
//                            fill = Random.pick(colors)
                            fill = rgb((it * 0.01 - seconds) % 1)
                            point((it * it * 0.111) % width, (it * 4.011) % height)
                        }
                    }
                }
            }
        }
    }
}