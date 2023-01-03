package com.hhb01.hhb01website


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
//
//        // This is used to hide the status bar and make
//        // the splash screen as a full screen activity.
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN
//        )
//
//        // we used the postDelayed(Runnable, time) method
//        // to send a message with a delayed time.
//        //Normal Handler is deprecated , so we have to change the code little bit
//
//        // Handler().postDelayed({
//        Handler(Looper.getMainLooper()).postDelayed({
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }, 13000) // 3000 is the delayed time in milliseconds.
        val backgroundImage:ImageView = findViewById(R.id.SplashScreenImage)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundImage.startAnimation(sideAnimation)


        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000) // delaying for 4 seconds...
    }
}