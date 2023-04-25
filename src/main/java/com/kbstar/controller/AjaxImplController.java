package com.kbstar.controller;

import com.kbstar.dto.Cust;
import com.kbstar.dto.Marker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        List<Cust> list= new ArrayList<>();
        list.add(new Cust("id01","pwd01","james1"));
        list.add(new Cust("id02","pwd02","james2"));
        list.add(new Cust("id03","pwd03","james3"));
        list.add(new Cust("id04","pwd04","james4"));
        list.add(new Cust("id05","pwd05","james5"));

        // Java Object ---> JSON
        // JSON(JavaScript Object Notation)
        // [{},{},{},...]
        JSONArray ja = new JSONArray();
        for(Cust obj:list){
            JSONObject jo = new JSONObject();
            Random r = new Random();
            int i = r.nextInt(100)+1;
            jo.put("id",obj.getId());
            jo.put("pwd",obj.getPwd());
            jo.put("name",obj.getName()+i);
            ja.add(jo);
        }
        return ja;
    }
    @RequestMapping("/checkid")
    public Object checkid(String id){
        int result = 0;
        if(id.equals("qqqq") || id.equals("aaaa") || id.equals("ssss")){
            result = 1;
        }
        return result;
    }
    @RequestMapping("/markers")
    public Object markers(String loc){
        List<Marker> list = new ArrayList<>();
        if(loc.equals("s")){
            list.add(new Marker(100,"국밥","http://www.nate.com",37.5732099 ,126.9778146,"a.jpg","s"));
            list.add(new Marker(101,"짬뽕","http://www.naver.com",37.5712099 ,126.9758146,"b.jpg","s"));
            list.add(new Marker(102,"껍데기","http://www.daum.net",37.5722099 ,126.9768146,"c.jpg","s"));
        }else if(loc.equals("b")){
            list.add(new Marker(103,"국밥","http://www.nate.com",35.1938469 ,129.1536102,"a.jpg","b"));
            list.add(new Marker(104,"짬뽕","http://www.naver.com",35.1948469 ,129.1576102,"b.jpg","b"));
            list.add(new Marker(105,"껍데기","http://www.daum.net",35.1928469 ,129.1556102,"c.jpg","b"));
        }else if(loc.equals("j")){
            list.add(new Marker(106,"국밥","http://www.nate.com",33.2471736 ,126.5521947,"a.jpg","j"));
            list.add(new Marker(107,"짬뽕","http://www.naver.com",33.2461736 ,126.5541947,"b.jpg","j"));
            list.add(new Marker(108,"껍데기","http://www.daum.net",33.2451736 ,126.5531947,"c.jpg","j"));
        }

        JSONArray ja = new JSONArray();
        for(Marker obj:list){
            JSONObject jo = new JSONObject();
            jo.put("id",obj.getId());
            jo.put("title",obj.getTitle());
            jo.put("target",obj.getTarget());
            jo.put("lat",obj.getLat());
            jo.put("lng",obj.getLng());
            jo.put("img",obj.getImg());
            jo.put("loc",obj.getLoc());
            ja.add(jo);
        }
        return ja;
    }
}
