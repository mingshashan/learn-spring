package com.example.demo.designpattern.proxy.jdk2;

import java.lang.reflect.Proxy;

public class PlayerProxyFactory {

    private final Class<Player> mapperInterface = Player.class;

    public PlayerProxyFactory() {

    }

    public Class<Player> getMapperInterface() {
        return mapperInterface;
    }


    @SuppressWarnings("unchecked")
    protected Player newInstance(PlayerProxy playerProxy) {
        return (Player) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, playerProxy);
    }

    public Player newInstance() {
        final PlayerProxy playerProxy = new PlayerProxy();
        return newInstance(playerProxy);
    }
}
