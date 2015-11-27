package nl.quintor.ee;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ServerEndpoint("/updates")
@ApplicationScoped
public class MyWebSocket {

    private static Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void connect(Session session) {
        sessions.add(session);
        System.out.println(session);
    }

    @OnClose
    public void disconnect(Session session) {
        sessions.remove(session);
    }

    @OnError
    public void error(Throwable error, Session session) {
        sessions.remove(session);
    }

    @OnMessage
    public void message(String msg, Session session) {
        System.out.println(sessions.size());
        sessions.forEach(s -> s.getAsyncRemote().sendText(msg));
    }
}
