package com.example.mycommunity.service;

import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.mycommunity.mapper.UserAgentMapper;
import com.example.mycommunity.model.User;
import com.example.mycommunity.model.UserAgent;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserAgentServiceImpl implements UserAgentService{

        private final RestTemplate restTemplate;
        private final UserService userService;
        private final UserAgentMapper userAgentMapper;

        @Override
        public UserAgent getUserAgent(Long userId) {
            return userAgentMapper.getUserAgent(userId);
        }

        @Override
        public UserAgent addUserAgent(Long userId) {
            User user = userService.findById(userId);
            UserAgent userAgent = new UserAgent();
            userAgent.setUserId(user.getUserId());
            userAgent.setEmail(user.getEmail());
            String uuid = UUID.randomUUID().toString();
            userAgent.setUuid(uuid);
            userAgent.setServerAddr(ProxyInfo.PROXY_ADDRESS);
            userAgent.setServerPort(ProxyInfo.PROXY_PORT);

            restTemplate.postForObject(ProxyInfo.PROXY_API_URI, userAgent, String.class);
            System.out.println("add user successful, uuid:" + uuid);

            //userAgentMapper.addUserAgent(userAgent);
            return userAgent;
        }

        @Override
        public void deleteUserAgent(Long userId) {
            User user = userService.findById(userId);
            String email = user.getEmail();
            String url = ProxyInfo.PROXY_API_URI + "/{email}";
            restTemplate.delete(url,email);
            //userAgentMapper.deleteUserAgent(userId);
        }


}
