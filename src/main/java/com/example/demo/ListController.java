package com.example.demo; // ← 自分のパッケージ名に合わせてね！

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    @GetMapping("/list")
    public String showListPage(Model model) {
        // 投稿データを作成（画像つき）
        List<Post> posts = new ArrayList<>();

        posts.add(new Post(0, "セルフネイルにおすすめ", "NAIL POLISH 3選", "セルフネイルにおすすめnail polish 3選 (4).png"));
        posts.add(new Post(1, "トレンドチーク", "トレンドのくすみカラーのチークを紹介します♡", "写真 2020-06-12 17 44 21.png"));
        posts.add(new Post(2, "超絶可愛いアイシャドウパレット♡", "おすすめアイシャドウを紹介します！", "写真 2020-07-28 13 03 57 (1).png"));

        model.addAttribute("postList", posts);
        return "list";
    }
}