package com.beautifulsoup.dancego.bean;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/20.
 */

public class GroupList {


    /**
     * result : success
     * data : [{"groupnum":"000000","groupname":"testgroup","identy":3}]
     */

    private String result;
    private List<DataBean> data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * groupnum : 000000
         * groupname : testgroup
         * identy : 3
         */

        private String groupnum;
        private String groupname;
        private int identy;

        public String getGroupnum() {
            return groupnum;
        }

        public void setGroupnum(String groupnum) {
            this.groupnum = groupnum;
        }

        public String getGroupname() {
            return groupname;
        }

        public void setGroupname(String groupname) {
            this.groupname = groupname;
        }

        public int getIdenty() {
            return identy;
        }

        public void setIdenty(int identy) {
            this.identy = identy;
        }
    }
}
