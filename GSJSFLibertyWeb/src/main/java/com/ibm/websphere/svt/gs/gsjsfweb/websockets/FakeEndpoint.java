package com.ibm.websphere.svt.gs.gsjsfweb.websockets;

import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.Session;

public class FakeEndpoint extends Endpoint {
    
 @Override
 public void onOpen(Session session, EndpointConfig config) {
  // https://java.net/jira/browse/WEBSOCKET_SPEC-240
 }   
}
