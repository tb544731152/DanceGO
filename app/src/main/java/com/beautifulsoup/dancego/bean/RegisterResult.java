package com.beautifulsoup.dancego.bean;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class RegisterResult<T> {

    private String result;
    private String error;
    private T data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
