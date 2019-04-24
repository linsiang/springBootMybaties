package com.gnnu.springbootmybaties.pojo;

public class Poetry {
    private int poetryId;
    private String poetryTitle;
    private String poetryBody;
    private String poetryAuthor;
    private String poetryDynasty;

    public Poetry() {
    }

    public int getPoetryId() {
        return poetryId;
    }

    public void setPoetryId(int poetryId) {
        this.poetryId = poetryId;
    }

    public String getPoetryTitle() {
        return poetryTitle;
    }

    public void setPoetryTitle(String poetryTitle) {
        this.poetryTitle = poetryTitle;
    }

    public String getPoetryBody() {
        return poetryBody;
    }

    public void setPoetryBody(String poetryBody) {
        this.poetryBody = poetryBody;
    }

    public String getPoetryAuthor() {
        return poetryAuthor;
    }

    public void setPoetryAuthor(String poetryAuthor) {
        this.poetryAuthor = poetryAuthor;
    }

    public String getPoetryDynasty() {
        return poetryDynasty;
    }

    public void setPoetryDynasty(String poetryDynasty) {
        this.poetryDynasty = poetryDynasty;
    }

    @Override
    public String toString() {
        return "Poetry{" +
                "poetryId=" + poetryId +
                ", poetryTitle='" + poetryTitle + '\'' +
                ", poetryBody='" + poetryBody + '\'' +
                ", poetryAuthor='" + poetryAuthor + '\'' +
                ", poetryDynasty='" + poetryDynasty + '\'' +
                '}';
    }
}
