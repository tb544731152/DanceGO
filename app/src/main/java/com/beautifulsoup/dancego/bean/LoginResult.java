package com.beautifulsoup.dancego.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class LoginResult implements Parcelable{

    /**
     * result : success
     * data : {"UserName":"wangxiaohao","UserID":"10987654321","Token":"3KCYT4LTGHV2","JoinedGroups":[]}
     * error : null
     */

    private String result;
    private DataBean data;
    private String error;

    protected LoginResult(Parcel in) {
        result = in.readString();
        data = in.readParcelable(DataBean.class.getClassLoader());
    }

    public static final Creator<LoginResult> CREATOR = new Creator<LoginResult>() {
        @Override
        public LoginResult createFromParcel(Parcel in) {
            return new LoginResult(in);
        }

        @Override
        public LoginResult[] newArray(int size) {
            return new LoginResult[size];
        }
    };

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeString(error);
        dest.writeParcelable(data, flags);
    }

    public static class DataBean implements Parcelable{
        /**
         * UserName : wangxiaohao
         * UserID : 10987654321
         * Token : 3KCYT4LTGHV2
         * JoinedGroups : []
         */

        private String UserName;
        private String UserID;
        private String Token;
        private List<?> JoinedGroups;

        protected DataBean(Parcel in) {
            UserName = in.readString();
            UserID = in.readString();
            Token = in.readString();
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel in) {
                return new DataBean(in);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserID() {
            return UserID;
        }

        public void setUserID(String UserID) {
            this.UserID = UserID;
        }

        public String getToken() {
            return Token;
        }

        public void setToken(String Token) {
            this.Token = Token;
        }

        public List<?> getJoinedGroups() {
            return JoinedGroups;
        }

        public void setJoinedGroups(List<?> JoinedGroups) {
            this.JoinedGroups = JoinedGroups;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "UserName='" + UserName + '\'' +
                    ", UserID='" + UserID + '\'' +
                    ", Token='" + Token + '\'' +
                    ", JoinedGroups=" + JoinedGroups +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(UserName);
            dest.writeString(UserID);
            dest.writeString(Token);
            dest.writeList(JoinedGroups);
        }
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "result='" + result + '\'' +
                ", data=" + data +
                ", error=" + error +
                '}';
    }
}
