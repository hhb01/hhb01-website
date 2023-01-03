package com.hhb01.hhb01website

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "歡迎使用官方初版App，未來會持續優化並新增功能", Toast.LENGTH_SHORT).show()


        //載入url
        val homeWeb = findViewById<View>(R.id.WebView) as WebView
        homeWeb.loadUrl("https://edu.hhb01.com")
        //啟用js
        val homeSet =  homeWeb.settings
        homeSet.javaScriptEnabled =true
        homeWeb.webViewClient = WebViewClient()
//        homeWeb.canGoBack()

//      val searchPost:View = findViewById(R.id.search)
//        searchView = findViewById(R.id.search)


    }

    //修復按返回直接退出應用
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // 檢查返回是否有歷史記錄
        val homeWeb = findViewById<View>(R.id.WebView) as WebView
        if (keyCode == KeyEvent.KEYCODE_BACK && homeWeb.canGoBack()) {
            homeWeb.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.left_menu, menu)
        val searchPost = menu.findItem(R.id.search)
        val searchView = searchPost.actionView as SearchView
        searchView.queryHint = "輸入你想搜尋文章的關鍵字"
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                val homeWeb = findViewById<View>(R.id.WebView) as WebView
                val hhb01Search = "https://edu.hhb01.com/search?q="
//                println(searchView.getQuery())
                val gogogo = hhb01Search+searchView.getQuery()
                homeWeb.loadUrl(gogogo)

                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
//                adapter.filter.filter(newText)
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }


//右上選單
    @SuppressLint("SuspiciousIndentation")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val homeWeb = findViewById<View>(R.id.WebView) as WebView
        return when (item.itemId) {
            R.id.homeItem -> {
                Toast.makeText(this, "執行回到首頁!", Toast.LENGTH_SHORT).show()
                homeWeb.loadUrl("https://edu.hhb01.com")
                true
            }
            R.id.reportItem ->{
                Toast.makeText(this, "執行回報頁面!", Toast.LENGTH_SHORT).show()
                homeWeb.loadUrl("https://edu.hhb01.com/p/app.html")
                true
            }
            R.id.aboutItem ->{
                Toast.makeText(this, "Hi!歡迎追蹤我的Instagram~", Toast.LENGTH_SHORT).show()
                homeWeb.loadUrl("https://hhb01.com")
                true
            }
            R.id.search ->{
                Toast.makeText(this, "請輸入搜尋文章關鍵字", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
//    fun setOnQueryTextListener(object : SearchView.OnQueryTextListener){
//
//    }

//
//    searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//        override fun onQueryTextSubmit(query: String?): Boolean {
//            // on below line we are checking
//            // if query exist or not.
//            if (programmingLanguagesList.contains(query)) {
//                // if query exist within list we
//                // are filtering our list adapter.
////                listAdapter.filter.filter(query)
//            } else {
//                // if query is not present we are displaying
//                // a toast message as no  data found..
////                Toast.makeText(this@MainActivity, "No Language found..", Toast.LENGTH_LONG).show()
//            }
//            return false
//        }
}


