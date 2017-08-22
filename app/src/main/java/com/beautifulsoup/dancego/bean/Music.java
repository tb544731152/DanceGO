package com.beautifulsoup.dancego.bean;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public class Music {

    /**
     * result : success
     * data : [{"musicnum":"000004","musicname":"test4","musicsize":2565334,"download":0,"timelength":123},{"musicnum":"000003","musicname":"test","musicsize":3944413,"download":0,"timelength":123},{"musicnum":"000002","musicname":"test3","musicsize":1876528,"download":0,"timelength":123},{"musicnum":"000001","musicname":"test1","musicsize":4763690,"download":0,"timelength":123}]
     * error : null
     */

    private String result;
    private Object error;
    private List<DataBean> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * musicnum : 000004
         * musicname : test4
         * musicsize : 2565334
         * download : 0
         * timelength : 123
         */

        private String musicnum;
        private String musicname;
        private int musicsize;
        private int download;
        private int timelength;

        public String getMusicnum() {
            return musicnum;
        }

        public void setMusicnum(String musicnum) {
            this.musicnum = musicnum;
        }

        public String getMusicname() {
            return musicname;
        }

        public void setMusicname(String musicname) {
            this.musicname = musicname;
        }

        public int getMusicsize() {
            return musicsize;
        }

        public void setMusicsize(int musicsize) {
            this.musicsize = musicsize;
        }

        public int getDownload() {
            return download;
        }

        public void setDownload(int download) {
            this.download = download;
        }

        public int getTimelength() {
            return timelength;
        }

        public void setTimelength(int timelength) {
            this.timelength = timelength;
        }
    }
}
