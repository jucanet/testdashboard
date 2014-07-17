package com.cl3k.asterisk.web.model;
    
public class Peer {
    
    private String peerID;
    private String server;
    private String dateReceived;
    private Double timestamp;
    private String chanobjecttype;
    private String channeltype;
    private String ipaddress;
    private String objectname;
    private String status;
    private Boolean dynamic;
    private String peer;
    private String cause;
    private String time;
    private String peerstatus;
    private Double initializedTimeStamp;
    private Integer totalInboundCalls;
    private Integer totalOutboundCalls;
    private Integer inboundCallsAnswered;
    private Integer inboundCallsNotAnswered;
    private Integer outboundCallsAnswered;
    private Integer outboundCallsNotAnswered;
    
    
    public Peer() {
        super();
    }    

    public void setPeerID(String peerID) {
        this.peerID = peerID;
    }

    public String getPeerID() {
        return peerID;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getServer() {
        return server;
    }

    public void setDateReceived(String dateReceived) {
        this.dateReceived = dateReceived;
    }

    public String getDateReceived() {
        return dateReceived;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setChanobjecttype(String chanobjecttype) {
        this.chanobjecttype = chanobjecttype;
    }

    public String getChanobjecttype() {
        return chanobjecttype;
    }

    public void setChanneltype(String channeltype) {
        this.channeltype = channeltype;
    }

    public String getChanneltype() {
        return channeltype;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public String getObjectname() {
        return objectname;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDynamic(Boolean dynamic) {
        this.dynamic = dynamic;
    }

    public Boolean getDynamic() {
        return dynamic;
    }

    public void setPeer(String peer) {
        this.peer = peer;
    }

    public String getPeer() {
        return peer;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getCause() {
        return cause;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setPeerstatus(String peerstatus) {
        this.peerstatus = peerstatus;
    }

    public String getPeerstatus() {
        return peerstatus;
    }

    public void setInitializedTimeStamp(Double initializedTimeStamp) {
        this.initializedTimeStamp = initializedTimeStamp;
    }

    public Double getInitializedTimeStamp() {
        return initializedTimeStamp;
    }

    public void setTotalInboundCalls(Integer totalInboundCalls) {
        this.totalInboundCalls = totalInboundCalls;
    }

    public Integer getTotalInboundCalls() {
        return totalInboundCalls;
    }

    public void setTotalOutboundCalls(Integer totalOutboundCalls) {
        this.totalOutboundCalls = totalOutboundCalls;
    }

    public Integer getTotalOutboundCalls() {
        return totalOutboundCalls;
    }

    public void setInboundCallsAnswered(Integer inboundCallsAnswered) {
        this.inboundCallsAnswered = inboundCallsAnswered;
    }

    public Integer getInboundCallsAnswered() {
        return inboundCallsAnswered;
    }

    public void setInboundCallsNotAnswered(Integer inboundCallsNotAnswered) {
        this.inboundCallsNotAnswered = inboundCallsNotAnswered;
    }

    public Integer getInboundCallsNotAnswered() {
        return inboundCallsNotAnswered;
    }

    public void setOutboundCallsAnswered(Integer outboundCallsAnswered) {
        this.outboundCallsAnswered = outboundCallsAnswered;
    }

    public Integer getOutboundCallsAnswered() {
        return outboundCallsAnswered;
    }

    public void setOutboundCallsNotAnswered(Integer outboundCallsNotAnswered) {
        this.outboundCallsNotAnswered = outboundCallsNotAnswered;
    }

    public Integer getOutboundCallsNotAnswered() {
        return outboundCallsNotAnswered;
    }

}
