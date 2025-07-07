package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DetailController {

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") int id, Model model) {
        // 投稿リスト（仮データ）
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(0, "セルフネイルにおすすめ", "NAIL POLISH 3選", "/セルフネイルにおすすめnail polish 3選 (4).png"));
        posts.add(new Post(1, "トレンドチーク", "トレンドのくすみカラーのチークを紹介します♡", "/写真 2020-06-12 17 44 21.png"));
        posts.add(new Post(2, "超絶可愛いアイシャドウパレット♡", "おすすめアイシャドウを紹介します！", "/写真 2020-07-28 13 03 57 (1).png"));
        // IDをもとに該当する投稿データを取り出す
        Post selected = posts.get(id);
        model.addAttribute("post", selected);

        return "detail"; // → detail.html にデータを渡して表示
    }
}