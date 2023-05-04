package com.kbstar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(CorsConfiguration.ALL);
        configuration.addAllowedMethod(CorsConfiguration.ALL);
        configuration.addAllowedHeader(CorsConfiguration.ALL);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**4. index.jsp - websocket library 추가\n" +
                "    <script src=\"/webjars/sockjs-client/sockjs.min.js\"></script>\n" +
                "    <script src=\"/webjars/stomp-websocket/stomp.min.js\"></script>\n" +
                "5. websocket.jsp 구현\n" +
                "<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\" %>\n" +
                "<%@ taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\" %>\n" +
                "<%@ taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\" %>\n" +
                "\n" +
                "<style>\n" +
                "  #all {\n" +
                "    width: 400px;\n" +
                "    height: 200px;\n" +
                "    overflow: auto;\n" +
                "    border: 2px solid red;\n" +
                "  }\n" +
                "\n" +
                "  #me {\n" +
                "    width: 400px;\n" +
                "    height: 200px;\n" +
                "    overflow: auto;\n" +
                "    border: 2px solid blue;\n" +
                "  }\n" +
                "\n" +
                "  #to {\n" +
                "    width: 400px;\n" +
                "    height: 200px;\n" +
                "    overflow: auto;\n" +
                "    border: 2px solid green;\n" +
                "  }\n" +
                "</style>\n" +
                "\n" +
                "<script>\n" +
                "  let websocket = {\n" +
                "    id:null,\n" +
                "    stompClient:null,\n" +
                "    init:function(){\n" +
                "      this.id = $('#adm_id').text();\n" +
                "      $(\"#connect\").click(function() {\n" +
                "        websocket.connect();\n" +
                "      });\n" +
                "      $(\"#disconnect\").click(function() {\n" +
                "        websocket.disconnect();\n" +
                "      });\n" +
                "      $(\"#sendall\").click(function() {\n" +
                "        websocket.sendAll();\n" +
                "      });\n" +
                "      $(\"#sendme\").click(function() {\n" +
                "        websocket.sendMe();\n" +
                "      });\n" +
                "      $(\"#sendto\").click(function() {\n" +
                "        websocket.sendTo();\n" +
                "      });\n" +
                "    },\n" +
                "    connect:function(){\n" +
                "      var sid = this.id;\n" +
                "      var socket = new SockJS('http://127.0.0.1:8088/ws');\n" +
                "      this.stompClient = Stomp.over(socket);\n" +
                "\n" +
                "      this.stompClient.connect({}, function(frame) {\n" +
                "        websocket.setConnected(true);\n" +
                "        console.log('Connected: ' + frame);\n" +
                "        this.subscribe('/send', function(msg) {\n" +
                "          $(\"#all\").prepend(\n" +
                "                  \"<h4>\" + JSON.parse(msg.body).sendid +\":\"+\n" +
                "                  JSON.parse(msg.body).content1\n" +
                "                  + \"</h4>\");\n" +
                "        });\n" +
                "        this.subscribe('/send/'+sid, function(msg) {\n" +
                "          $(\"#me\").prepend(\n" +
                "                  \"<h4>\" + JSON.parse(msg.body).sendid +\":\"+\n" +
                "                  JSON.parse(msg.body).content1+ \"</h4>\");\n" +
                "        });\n" +
                "        this.subscribe('/send/to/'+sid, function(msg) {\n" +
                "          $(\"#to\").prepend(\n" +
                "                  \"<h4>\" + JSON.parse(msg.body).sendid +\":\"+\n" +
                "                  JSON.parse(msg.body).content1\n" +
                "                  + \"</h4>\");\n" +
                "        });\n" +
                "      });\n" +
                "    },\n" +
                "    disconnect:function(){\n" +
                "      if (this.stompClient !== null) {\n" +
                "        this.stompClient.disconnect();\n" +
                "      }\n" +
                "      websocket.setConnected(false);\n" +
                "      console.log(\"Disconnected\");\n" +
                "    },\n" +
                "    setConnected:function(connected){\n" +
                "      if (connected) {\n" +
                "        $(\"#status\").text(\"Connected\");\n" +
                "      } else {\n" +
                "        $(\"#status\").text(\"Disconnected\");\n" +
                "      }\n" +
                "    },\n" +
                "    sendAll:function(){\n" +
                "      var msg = JSON.stringify({\n" +
                "        'sendid' : this.id,\n" +
                "        'content1' : $(\"#alltext\").val()\n" +
                "      });\n" +
                "      this.stompClient.send(\"/receiveall\", {}, msg);\n" +
                "    },\n" +
                "    sendTo:function(){\n" +
                "      var msg = JSON.stringify({\n" +
                "        'sendid' : this.id,\n" +
                "        'receiveid' : $('#target').val(),\n" +
                "        'content1' : $('#totext').val()\n" +
                "      });\n" +
                "      this.stompClient.send('/receiveto', {}, msg);\n" +
                "    },\n" +
                "    sendMe:function(){\n" +
                "      var msg = JSON.stringify({\n" +
                "        'sendid' : this.id,\n" +
                "        'content1' : $('#metext').val()\n" +
                "      });\n" +
                "      this.stompClient.send(\"/receiveme\", {}, msg);\n" +
                "    }\n" +
                "  };\n" +
                "  $(function(){\n" +
                "    websocket.init();\n" +
                "  })\n" +
                "\n" +
                "</script>\n" +
                "<!-- Begin Page Content -->\n" +
                "<div class=\"container-fluid\">\n" +
                "\n" +
                "  <!-- Page Heading -->\n" +
                "  <h1 class=\"h3 mb-2 text-gray-800\">Live Chart</h1>\n" +
                "\n" +
                "  <!-- DataTales Example -->\n" +
                "  <div class=\"card shadow mb-4\">\n" +
                "    <div class=\"card-header py-3\">\n" +
                "      <h6 class=\"m-0 font-weight-bold text-primary\">Live Chart</h6>\n" +
                "    </div>\n" +
                "    <div class=\"card-body\">\n" +
                "      <div id=\"container\"></div>\n" +
                "      <div class=\"col-sm-5\">\n" +
                "        <h1 id=\"adm_id\">${loginadm.id}</h1>\n" +
                "        <H1 id=\"status\">Status</H1>\n" +
                "        <button id=\"connect\">Connect</button>\n" +
                "        <button id=\"disconnect\">Disconnect</button>\n" +
                "\n" +
                "        <h3>All</h3>\n" +
                "        <input type=\"text\" id=\"alltext\"><button id=\"sendall\">Send</button>\n" +
                "        <div id=\"all\"></div>\n" +
                "\n" +
                "        <h3>Me</h3>\n" +
                "        <input type=\"text\" id=\"metext\"><button id=\"sendme\">Send</button>\n" +
                "        <div id=\"me\"></div>\n" +
                "\n" +
                "        <h3>To</h3>\n" +
                "        <input type=\"text\" id=\"target\">\n" +
                "        <input type=\"text\" id=\"totext\"><button id=\"sendto\">Send</button>\n" +
                "        <div id=\"to\"></div>\n" +
                "\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <!-- /.container-fluid -->\n" +
                "</div>\n" +
                "(편집됨)", configuration);

        http.httpBasic()
                .and().authorizeRequests()
                .anyRequest().permitAll()
                .and().cors().configurationSource(source)
                .and().csrf().disable();
    }
}
