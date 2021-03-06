package com.wxystatic.loadretrylibrary;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by static on 2017/12/5/005.
 */

public class LoadRetryRefreshConfig {
    private  @ColorRes int backgroundColor;
    private  @ColorRes int btnNormalColor;
    private  @ColorRes int btnPressedColor;
    private  @ColorRes int btnBorderColor;
    private  @ColorRes int btnTextColor;
    private  @ColorRes int loadAndErrorTextColor;
    private  @DrawableRes int gif;
    private  String btnText;
    private String  loadText;
    private int startAnimTime;
    private int endAnimTime;

    public int getStartAnimTime() {
        return startAnimTime;
    }

    public void setStartAnimTime(int startAnimTime) {
        this.startAnimTime = startAnimTime;
    }

    public int getEndAnimTime() {
        return endAnimTime;
    }

    public void setEndAnimTime(int endAnimTime) {
        this.endAnimTime = endAnimTime;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    public int getBtnNormalColor() {
        return btnNormalColor;
    }

    public void setBtnNormalColor(int btnNormalColor) {
        this.btnNormalColor = btnNormalColor;
    }

    public int getBtnPressedColor() {
        return btnPressedColor;
    }

    public void setBtnPressedColor(int btnPressedColor) {
        this.btnPressedColor = btnPressedColor;
    }

    public int getBtnBorderColor() {
        return btnBorderColor;
    }

    public void setBtnBorderColor(int btnBorderColor) {
        this.btnBorderColor = btnBorderColor;
    }
    public String getLoadText() {
        return loadText;
    }

    public void setLoadText(String loadText) {
        this.loadText = loadText;
    }


    public Float getBtnRadius() {
        return btnRadius;
    }

    public void setBtnRadius(Float btnRadius) {
        this.btnRadius = btnRadius;
    }

    private Float btnRadius;




    public int getBtnTextColor() {
        return btnTextColor;
    }

    public void setBtnTextColor(int btnTextColor) {
        this.btnTextColor = btnTextColor;
    }

    public int getLoadAndErrorTextColor() {
        return loadAndErrorTextColor;
    }

    public void setLoadAndErrorTextColor(int loadAndErrorTextColor) {
        this.loadAndErrorTextColor = loadAndErrorTextColor;
    }


    public int getGif() {
        return gif;
    }

    public void setGif(int gif) {
        this.gif = gif;
    }

    public String getBtnText() {
        return btnText;
    }

    public void setBtnText(String btnText) {
        this.btnText = btnText;
    }
}
