import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.shadeStyle
import org.openrndr.extra.noise.Random
import org.openrndr.math.Vector2
import org.openrndr.shape.Circle
import java.util.*

fun main() = application {
    configure {
        width = 768
        height = 576
    }

    program {

        val colors = listOf(
            ColorRGBa(1.0, 0.0, 0.0, 0.8),
            ColorRGBa(0.0, 1.0, 0.0, 0.8),
            ColorRGBa(0.0, 0.0, 1.0, 0.8),
            ColorRGBa(1.0, 1.0, 1.0, 0.8)
        )

        var drawPosition: Vector2? = null
        var fixedPosition: Vector2? = null
        var rad = 50.0

        val list = mutableListOf<Circle>()

        mouse.moved.listen {
            drawPosition = it.position
        }

        mouse.buttonDown.listen {
            rad = (60..150).random() * 1.0
            list.add(Circle(it.position, rad))
        }


        extend {

            Random.resetState()

            drawer.shadeStyle = shadeStyle {
                fragmentTransform = """
 float c = cos(c_screenPosition.x * 0.1 + p_time) * 0.5 + 0.5;
 x_fill.rgb *= vec3(c, c, c);
                    """.trimMargin()
                parameter("time", seconds)
            }

            drawer.clear(1.0, 1.0, 1.0, 1.0)
//            drawer.circle(width/2.0, height/2.0,80.0)
            drawPosition?.let {
                drawer.circle(it.x, it.y, (it.x + it.y)/10.0)
            }

            fixedPosition?.let {
//                drawer.fill = ColorRGBa.RED
//                drawer.circle(it.x, it.y, 100.0)
            }
            for (item in list) {

                drawer.fill = Random.pick(colors)
                drawer.circle(item)
            }

        }

    }
}
