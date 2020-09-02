package com.tech4lyf.SBSRATM;

public class EventHandlers {
    public interface CyberPlatSearchListener{
        public void onCyberPlatSearch(String search, String searchType);

    }
    private static CyberPlatSearchListener cyberPlatSearchListener;

    public void setCyberPlatSearchListener(CyberPlatSearchListener cyberPlatSearchListener){
        this.cyberPlatSearchListener = cyberPlatSearchListener;
    }

    public static void triggerCyberPlatSearchListener(String search, String searchType){
        cyberPlatSearchListener.onCyberPlatSearch(search, searchType);
    }
}
