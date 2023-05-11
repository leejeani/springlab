package com.kbstar.weather;

import com.kbstar.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class WeatherTEst2 {

    @Test
    void contextLoads() throws Exception{
        JSONObject result = null;
        result = (JSONObject)WeatherUtil.getWeather3("109");
        log.info(result.toJSONString());
    }

}
