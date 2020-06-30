package com.example.covid_19

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(
            Model("서울특별시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2d/Seal_of_Seoul%2C_South_Korea.svg/220px-Seal_of_Seoul%2C_South_Korea.svg.png",
                "https://www.seoul.go.kr/coronaV/coronaStatus.do"),
            Model("부산광역시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Symbol_of_Busan.svg/220px-Symbol_of_Busan.svg.png",
                "http://www.busan.go.kr/corona19/index"),
            Model("대구광역시\n확진자동선 정보",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Symbol_of_Daegu.svg/220px-Symbol_of_Daegu.svg.png",
                "http://www.daegu.go.kr/dgcontent/index.do?menu_id=00936598"),
            Model("인천광역시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/d/dc/Seal_of_Incheon.svg/220px-Seal_of_Incheon.svg.png",
                "https://www.incheon.go.kr/health/HE020409"),
            Model("광주광역시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/6/69/Seal_of_Gwangju.svg/220px-Seal_of_Gwangju.svg.png",
                "https://www.gjcity.go.kr/corona_index.jsp"),
            Model("대전광역시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/b/be/Seal_of_Daejeon.svg/220px-Seal_of_Daejeon.svg.png",
                "https://www.daejeon.go.kr/corona19/index.do?menuId=0002"),
            Model("울산광역시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/1/18/Symbol_of_Ulsan.svg/220px-Symbol_of_Ulsan.svg.png",
                "https://www.ulsan.go.kr/corona.jsp"),
            Model("세종특별자치시\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/e5/Seal_of_Sejong_City%2C_South_Korea.svg/220px-Seal_of_Sejong_City%2C_South_Korea.svg.png",
                "https://www.sejong.go.kr/bbs/R3391/list.do"),
            Model("경기도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Emblem_of_Gyeonggi_Province.svg/220px-Emblem_of_Gyeonggi_Province.svg.png",
                "https://www.gg.go.kr/bbs/board.do?bsIdx=722&menuId=2903#page=1"),
            Model("강원도\n확진자 동선 정보",
                "https://www.provin.gangwon.kr/site/portal_new/images/common/logo.png",
                "https://www.provin.gangwon.kr/covid-19.html"),
            Model("충청북도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/b/be/Seal_of_North_Chungcheong.svg/220px-Seal_of_North_Chungcheong.svg.png",
                "http://www1.chungbuk.go.kr/covid-19/index.do"),
            Model("충청남도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/9/9f/Seal_of_South_Chungcheong.svg/220px-Seal_of_South_Chungcheong.svg.png",
                "http://www.chungnam.go.kr/coronaStatus.do"),
            Model("전라북도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/2/21/%EC%A0%84%EB%9D%BC%EB%B6%81%EB%8F%84_%ED%9C%98%EC%9E%A5.gif",
                "http://www.jeonbuk.go.kr/board/list.jeonbuk?boardId=BBS_0000107&menuCd=DOM_000000110006000000&contentsSid=1224&cpath="),
            Model("전라남도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/6/65/Seal_of_South_Jeolla.svg/220px-Seal_of_South_Jeolla.svg.png",
                "https://www.jeonnam.go.kr/coronaMainPage.do"),
            Model("경상북도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/d/df/Seal_of_North_Gyeongsang.svg/220px-Seal_of_North_Gyeongsang.svg.png",
                "https://gb.go.kr/Main/open_contents/section/wel/page.do?mnu_uid=5760"),
            Model("경상남도\n확진자 동선 정보",
                "https://upload.wikimedia.org/wikipedia/ko/thumb/b/bd/Seal_of_South_Gyeongsang.svg/220px-Seal_of_South_Gyeongsang.svg.png",
                "http://xn--19-q81ii1knc140d892b.kr/main/main.do#close"),
            Model("제주특별자치도\n확진자 동선 정보",
                "http://www.jejusori.net/news/photo/200904/62261_67202_2244.jpg",
                "https://www.jeju.go.kr/corona19.jsp")
        )

        val mAdapter = MainRvAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter

        mAdapter.itemClick = object : MainRvAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                Log.e("position : ", position.toString())

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(modelList.get(position).url))
                startActivity(intent)
            }
        }

        val la = LinearLayoutManager(this)
        mRecyclerView.layoutManager = la
    }
}
