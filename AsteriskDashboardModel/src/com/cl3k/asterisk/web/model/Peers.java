package com.cl3k.asterisk.web.model;

import java.io.StringReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;


//import sun.org.mozilla.javascript.internal.json.JsonParser;

public class Peers {
  // Return all contacts
    List<Peer> peersList = new ArrayList();

    public List<Peer> findAllContacts() {
        return peersList;
    }

    // Return all contacts matching name (case-insensitive)
    public List<Peer> findContactsByPeerID(String id) {
        String idPattern = ".*" + (id != null ? id.toUpperCase() : "") + ".*";
        List<Peer> matches = new ArrayList();
        for (Peer c : peersList) {
            if (Pattern.matches(idPattern, c.getPeerID().toUpperCase())) {
                matches.add(c);
            }
        }
        return matches;
    }

    public Peers() {
        super();
        
            String mensaje = "{\"action\":\"response\",\"idrequest\":\"1234-1\",\"server\":\"Server1\" " +
            ",\"data\":[ " +
            "{\"peerID\":\"SIP/102\",\"server\":\"ServerUno\",\"timestamp\":1.40495764769E12,\"dateReceived\":\"2014-07-09 23:00:47\",\"chanobjecttype\":\"peer\" " +
            ",\"channeltype\":\"SIP\",\"ipaddress\":\"\",\"objectname\":\"102\",\"status\":\"Unmonitored\",\"dynamic\":true,\"peer\":\"SIP/102\",\"cause\":\"Expired\",\"time\":\"\" " +
            ",\"peerstatus\":\"Unregistered\",\"initializedTimeStamp\":1.40495516535E12,\"totalInboundCalls\":0,\"totalOutboundCalls\":0,\"inboundCallsAnswered\":0,\"inboundCallsNotAnswered\":0 " +
            ",\"outboundCallsAnswered\":0,\"outboundCallsNotAnswered\":0} " +
            ",{\"peerID\":\"SIP/102\",\"server\":\"ServerUno\",\"timestamp\":1.40495764769E12,\"dateReceived\":\"2014-07-09 23:00:47\",\"chanobjecttype\":\"peer\" " +
            ",\"channeltype\":\"SIP\",\"ipaddress\":\"\",\"objectname\":\"102\",\"status\":\"Unmonitored\",\"dynamic\":true,\"peer\":\"SIP/102\",\"cause\":\"Expired\",\"time\":\"\" " +
            ",\"peerstatus\":\"Unregistered\",\"initializedTimeStamp\":1.40495516535E12,\"totalInboundCalls\":0,\"totalOutboundCalls\":0,\"inboundCallsAnswered\":0,\"inboundCallsNotAnswered\":0 " +
            ",\"outboundCallsAnswered\":0,\"outboundCallsNotAnswered\":0} " +
            ",{\"peerID\":\"SIP/102\",\"server\":\"ServerUno\",\"timestamp\":1.40495764769E12,\"dateReceived\":\"2014-07-09 23:00:47\",\"chanobjecttype\":\"peer\" " +
            ",\"channeltype\":\"SIP\",\"ipaddress\":\"\",\"objectname\":\"102\",\"status\":\"Unmonitored\",\"dynamic\":true,\"peer\":\"SIP/102\",\"cause\":\"Expired\",\"time\":\"\" " +
            ",\"peerstatus\":\"Unregistered\",\"initializedTimeStamp\":1.40495516535E12,\"totalInboundCalls\":0,\"totalOutboundCalls\":0,\"inboundCallsAnswered\":0,\"inboundCallsNotAnswered\":0 " +
            ",\"outboundCallsAnswered\":0,\"outboundCallsNotAnswered\":0} " +
            "] " +
            "}";
      
        parseToPeers(mensaje);
    }
  
  
    private void parseToPeers(String message){
         
        //create JsonReader object
        JsonReader jsonReader = Json.createReader( new StringReader(message));
        //get JsonObject from JsonReader
        JsonObject jsonObject = jsonReader.readObject();
        //we can close IO resource and JsonReader now
        jsonReader.close();
        
        //Ahora leo el objeto data
        //JsonObject innerJsonObject = jsonObject.getJsonObject("data");
        
        
        
        //jsonReader.readArray()
        JsonArray jsonArray = jsonObject.getJsonArray("data");
        for(JsonValue reg : jsonArray){
            JsonObject registro = (JsonObject) reg;
            //Retrieve data from JsonObject and create Employee bean
            Peer peer = new Peer();
            
            peer.setPeerID(registro.getString("peerID"));
            peer.setServer(registro.getString("server"));
            peer.setDateReceived(registro.getString("dateReceived"));
            //peer.setTimestamp(registro.getJsonNumber("timestamp"));
            peer.setIpaddress(registro.getString("ipaddress"));
            peer.setObjectname(registro.getString("objectname"));
            peer.setStatus(registro.getString("status"));
            peer.setCause(registro.getString("cause"));
            peer.setTotalInboundCalls(registro.getInt("totalInboundCalls"));
            peer.setTotalOutboundCalls(registro.getInt("totalOutboundCalls"));
            peer.setInboundCallsAnswered(registro.getInt("inboundCallsAnswered"));
            peer.setInboundCallsNotAnswered(registro.getInt("inboundCallsNotAnswered"));
            peer.setOutboundCallsAnswered(registro.getInt("outboundCallsAnswered"));
            peer.setOutboundCallsNotAnswered(registro.getInt("outboundCallsNotAnswered"));
            
            peersList.add(peer);
        }        

        //reading arrays from json

        //JsonArray jsonArray2 = jsonObject.getJsonArray("phoneNumbers");
         
        //reading inner object from json object
        /*
        JsonObject innerJsonObject = jsonObject.getJsonObject("address");
        Address address = new Address();
        address.setStreet(innerJsonObject.getString("street"));
        address.setCity(innerJsonObject.getString("city"));
        address.setZipcode(innerJsonObject.getInt("zipcode"));
        emp.setAddress(address);
        */
    }
  
  
    private void parseJSON(String message){
        JsonParser parser = Json.createParser(new StringReader(message));
        String keyType = null;
        String key = null, value = null;
        Map<String, String> stickyNotes;
        stickyNotes = new HashMap<>();
        while(parser.hasNext()){
            //Identify the type of event i.e type of JSON element.
            switch (parser.next()){
                //If the JSON element is the "KEY", then record the key type.
                case KEY_NAME:
                    keyType = parser.getString();
                    break;
                //If the JSON element is a value string then extract the value
                //and decide if the value is a sticky note key or sticky note data.
                case VALUE_STRING:
                    switch(keyType){
                        case "key":
                            key = parser.getString();
                        case "value":
                            value = parser.getString();
                    }
                    break;
                //Once we encounter the end of the sticky note object, update the
                //map with the sticky note key and sticky note value.
                case END_OBJECT:
                    stickyNotes.put(key, value);
                    break;
            }
        }
    }
  
}
