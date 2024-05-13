package com.hyosik.xmlwithcompose

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import java.util.Timer
import java.util.TimerTask

class DetailActivity : AppCompatActivity() {

    var reverse: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val timer = Timer()

        // 3초마다 실행되는 TimerTask 생성
        val timerTask = object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    if(!reverse){
                        translateYView(0f, 200f)
                        reverse = reverse.not()
                    } else {
                        translateYView(200f, 0f)
                        reverse = reverse.not()
                    }
                }
            }
        }

        // 3초마다 TimerTask 실행
        timer.schedule(timerTask, 0, 3000)

    }


    private fun translateYView(start: Float, end: Float) {
        val targetView: AppCompatImageView = findViewById(R.id.iv_wave)

        // translateY 애니메이션 생성
        val translateAnimator = ObjectAnimator.ofFloat(
            targetView, // 이동시킬 뷰
            View.TRANSLATION_Y, // 이동할 속성 (여기서는 Y 축 방향으로 이동)
            start, // 시작 값 (여기서는 현재 위치)
            end // 종료 값 (이동할 거리)
        )


        // 애니메이션의 기간 설정 (밀리초 단위)
        translateAnimator.duration = 1000 // 1초 동안 이동

        // 애니메이션 시작
        translateAnimator.start()
    }

}