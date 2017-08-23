package com.beautifulsoup.dancego.bean;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/20.
 */

public class GroupList {


    /**
     * result : success
     * data : [{"GroupNum":"000000","GroupName":"testgroup","Identity":3}]
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
         {
         "GroupNum": "000000",
         "GroupName": "testgroup",
         "NameInGroup": "test1",
         "IsReady": false,
         "MessageUnread": 3,
         "ApplyUnread": 2,
         "NoticeUnread": 0,
         "Identity": 3
         }
         */

        private String GroupNum;
        private String GroupName;
        private String NameInGroup;
        private boolean IsReady;
        private int MessageUnread;
        private int ApplyUnread;
        private int NoticeUnread;
        private int Identity;



        public String getGroupNum() {
            return GroupNum;
        }

        public void setGroupNum(String GroupNum) {
            this.GroupNum = GroupNum;
        }

        public String getGroupName() {
            return GroupName;
        }

        public void setGroupName(String GroupName) {
            this.GroupName = GroupName;
        }

        public int getIdentity() {
            return Identity;
        }

        public void setIdentity(int Identity) {
            this.Identity = Identity;
        }

        public boolean getIsReady() {return IsReady;}

        public int getApplyUnread() {return ApplyUnread;}

        public int getMessageUnread() {return MessageUnread;}

        public int getNoticeUnread() {return NoticeUnread;}

        public String getNameInGroup() {return NameInGroup;}

        public void setApplyUnread(int applyUnread) {ApplyUnread = applyUnread;}

        public void setMessageUnread(int messageUnread) {MessageUnread = messageUnread;}

        public void setNameInGroup(String nameInGroup) {NameInGroup = nameInGroup;}

        public void setNoticeUnread(int noticeUnread) {NoticeUnread = noticeUnread;}

        public void setIsReady(boolean isready) {IsReady = isready;}
    }
}
