package com.beautifulsoup.dancego.bean;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class LogoutResult {

    /**
     * result : failure
     * data : null
     * error : 用户与token不匹配
     */

    private String result;
    private Object data;
    private String error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
