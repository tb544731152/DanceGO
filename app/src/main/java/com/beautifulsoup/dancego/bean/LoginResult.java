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
     * data : {"username":"wangxiaohao","phonenum":"10987654321","token":"3KCYT4LTGHV2","GetGroupInfoList":[]}
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
         * username : wangxiaohao
         * phonenum : 10987654321
         * token : 3KCYT4LTGHV2
         * GetGroupInfoList : []
         */

        private String username;
        private String phonenum;
        private String token;
        private List<?> GetGroupInfoList;

        protected DataBean(Parcel in) {
            username = in.readString();
            phonenum = in.readString();
            token = in.readString();
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhonenum() {
            return phonenum;
        }

        public void setPhonenum(String phonenum) {
            this.phonenum = phonenum;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<?> getGetGroupInfoList() {
            return GetGroupInfoList;
        }

        public void setGetGroupInfoList(List<?> GetGroupInfoList) {
            this.GetGroupInfoList = GetGroupInfoList;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "username='" + username + '\'' +
                    ", phonenum='" + phonenum + '\'' +
                    ", token='" + token + '\'' +
                    ", GetGroupInfoList=" + GetGroupInfoList +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(username);
            dest.writeString(phonenum);
            dest.writeString(token);
            dest.writeList(GetGroupInfoList);
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
