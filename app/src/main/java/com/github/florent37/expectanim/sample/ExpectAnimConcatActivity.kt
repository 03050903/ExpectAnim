package com.github.florent37.expectanim.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.florent37.expectanim.ExpectAnim
import com.github.florent37.expectanim.animation
import kotlinx.android.synthetic.main.expectanim_activity_flip.*

class ExpectAnimConcatActivity : AppCompatActivity() {

    private var expectAnimMove: ExpectAnim? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.expectanim_activity_flip)

        this.expectAnimMove = ExpectAnim.concat(
                animation(duration = 1000L) {
                    animate(image1, cameraDistance = 500f) {
                        flippedHorizontally()
                    }
                },
                animation(duration = 500L) {
                    animate(image2, cameraDistance = 1000f) {
                        flippedVertically()
                    }
                },
                animation(duration = 300L) {
                    animate(image3, cameraDistance = 1500f) {
                        flippedVertically()
                    }
                },
                animation(duration = 1000L) {
                    animate(image4, cameraDistance = 2000f) {
                        flippedHorizontallyAndVertically()
                    }
                }).start()

        findViewById(R.id.content).setOnClickListener {
            expectAnimMove!!.setPercent(0f)
            expectAnimMove!!.start()
        }
    }

}
