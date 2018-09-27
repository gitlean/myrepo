package com.isoft.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.isoft.server.handler.MyHandler;

/**
 *  配置 WebSocket
	配置有两种方式：注解和 xml 。其作用就是将 WebSocket 处理器添加到注册中心。
	实现 WebSocketConfigurer

 * @author john
 * @date 2018年9月25日
 * @time 下午4:28:22
 * @describe:
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

}