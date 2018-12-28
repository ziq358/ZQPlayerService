package com.zq.zqplayer.model.live;

public class PandaTvLiveDataBean {

    private Info info;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public class Info
    {
        HostInfo hostinfo;
        VideoInfo videoinfo;

        public HostInfo getHostinfo() {
            return hostinfo;
        }

        public void setHostinfo(HostInfo hostinfo) {
            this.hostinfo = hostinfo;
        }

        public VideoInfo getVideoinfo() {
            return videoinfo;
        }

        public void setVideoinfo(VideoInfo videoinfo) {
            this.videoinfo = videoinfo;
        }
    }

}