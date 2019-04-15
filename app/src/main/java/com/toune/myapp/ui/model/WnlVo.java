package com.toune.myapp.ui.model;

import com.google.gson.annotations.SerializedName;

public class WnlVo {

    /**
     * data : {"avoid":"祈福.开市.修造.动土.破土.谢土.","animalsYear":"猪","weekday":"星期一","suit":"求嗣.出行.解除.订盟.纳采.嫁娶.会亲友.进人口.安床.开市.交易.纳畜.牧养.入殓.除服.成服.移柩.安葬.启攒.","lunarYear":"己亥年","lunar":"三月十一","year-month":"2019-4","date":"2019-4-15"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * avoid : 祈福.开市.修造.动土.破土.谢土.
         * animalsYear : 猪
         * weekday : 星期一
         * suit : 求嗣.出行.解除.订盟.纳采.嫁娶.会亲友.进人口.安床.开市.交易.纳畜.牧养.入殓.除服.成服.移柩.安葬.启攒.
         * lunarYear : 己亥年
         * lunar : 三月十一
         * year-month : 2019-4
         * date : 2019-4-15
         */

        private String avoid;
        private String animalsYear;
        private String weekday;
        private String suit;
        private String lunarYear;
        private String lunar;
        @SerializedName("year-month")
        private String yearmonth;
        private String date;

        public String getAvoid() {
            return avoid;
        }

        public void setAvoid(String avoid) {
            this.avoid = avoid;
        }

        public String getAnimalsYear() {
            return animalsYear;
        }

        public void setAnimalsYear(String animalsYear) {
            this.animalsYear = animalsYear;
        }

        public String getWeekday() {
            return weekday;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public String getSuit() {
            return suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getLunarYear() {
            return lunarYear;
        }

        public void setLunarYear(String lunarYear) {
            this.lunarYear = lunarYear;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

        public String getYearmonth() {
            return yearmonth;
        }

        public void setYearmonth(String yearmonth) {
            this.yearmonth = yearmonth;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
