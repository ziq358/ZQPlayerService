package com.zq.zqplayer.model.live;

public class VideoInfo
    {
        String plflag;
        String room_key;
        String sign;
        String ts;

        public String getPlflag() {
            return plflag;
        }

        public void setPlflag(String plflag) {
            this.plflag = plflag;
        }

        public String getRoom_key() {
            return room_key;
        }

        public void setRoom_key(String room_key) {
            this.room_key = room_key;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTs() {
            return ts;
        }

        public void setTs(String ts) {
            this.ts = ts;
        }
    }