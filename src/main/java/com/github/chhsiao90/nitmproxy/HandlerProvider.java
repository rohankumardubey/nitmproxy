package com.github.chhsiao90.nitmproxy;

import com.github.chhsiao90.nitmproxy.handler.protocol.http1.Http1BackendHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.http1.Http1EventHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.http1.Http1FrontendHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.http2.Http2BackendHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.http2.Http2EventHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.http2.Http2FrontendHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.tls.TlsBackendHandler;
import com.github.chhsiao90.nitmproxy.handler.protocol.tls.TlsFrontendHandler;
import io.netty.channel.ChannelHandler;

public class HandlerProvider {

    private NitmProxyMaster master;
    private ConnectionContext context;

    public HandlerProvider(NitmProxyMaster master, ConnectionContext context) {
        this.master = master;
        this.context = context;
    }

    public ChannelHandler http1BackendHandler() {
        return new Http1BackendHandler(context);
    }

    public ChannelHandler http1FrontendHandler() {
        return new Http1FrontendHandler(master, context);
    }

    public ChannelHandler http1EventHandler() {
        return new Http1EventHandler(master, context);
    }

    public ChannelHandler http2BackendHandler() {
        return new Http2BackendHandler(context);
    }

    public ChannelHandler http2FrontendHandler() {
        return new Http2FrontendHandler(context);
    }

    public ChannelHandler http2EventHandler() {
        return new Http2EventHandler(master, context);
    }

    public ChannelHandler tlsFrontendHandler() {
        return new TlsFrontendHandler(context);
    }

    public ChannelHandler tlsBackendHandler() {
        return new TlsBackendHandler(master, context);
    }
}