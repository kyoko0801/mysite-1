package com.example.demo;

public class Post {
    private int id;
    private String title;
    private String description;
    private String imageUrl;

    // コンストラクタ（4つの引数）
    public Post(int id, String title, String description, String imageUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // ゲッター（値を取り出すためのメソッド）
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
