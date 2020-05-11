package com.fiuty;

import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private static final Logger log = LoggerFactory.getLogger(AppTest.class);

    private static final ThreadLocal<ObjectMapper> OBJECT_MAPPER_WITH_UNDERSCORES = ThreadLocal.withInitial(()->{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new Jdk8Module());
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    });

    private static final ThreadLocal<ObjectMapper> OBJECT_MAPPERS = ThreadLocal.withInitial(() -> {
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        om.registerModule(new JavaTimeModule());
        om.registerModule(new Jdk8Module());
        return om;
    });
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test6() {
        String[] arr = new String[]{"GuangZhou", "ShenZhen", "BeiJin"};
        List<String> list = Arrays.asList(arr);
        arr[0] = "HangZhou";
        //HangZhou/GuangZhou
        System.out.println(arr[0] + "/" + list.get(0));
        list.set(0, "HongKong");
        //HangZhou/HongKong
        System.out.println(arr[0] + "/" + list.get(0));
        list.add("ShangHai");
        //4
        System.out.println(arr.length);
    }

    @Test
    public void testSplit() {
        String str = "美妆|口腔护理|口腔护理|牙刷";
        String[] split = str.split("\\|");
        for (int i = 0; i < split.length; i++) {
            log.debug("index:{},value:{}", i, split[i]);
        }
    }

    @Test
    public void testAddOddNum() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        Integer totalOddNum = list.stream().filter(item -> item % 2 != 0).reduce(0, Integer::sum);
        log.debug("totalOddNum:{}", totalOddNum);
    }

    @Test
    public void testJson() {
        String json = "{\"firstName\":\"first_name\",\"lastName\":\"last_name\"}";
        String json2 = "{\"person\":{\"first_name\":\"first_name\",\"last_name\":\"last_name\"}}";
        Person person = parse(json, Person.class);
        log.debug("person:{}",person);
    }

    @Test
    public void testJson2() {
        Person person = new Person("firstName", "lastName");
        try {
            toUnderlineJSONString(person);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 反序列化JSON为对象
     * @param json JSON
     * @param clazz 对象类型
     * @param <T> 对象类型
     * @return 反序列化后的对象
     */
    public static <T> T parse(String json, Class<T> clazz) {
        try {
            return OBJECT_MAPPERS.get().readerFor(clazz).readValue(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toSnakeObject(String json, Class<T> clazz) throws IOException{
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        try {
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象的大写转换为下划线加小写，例如：userName-->user_name
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String toUnderlineJSONString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String reqJson = mapper.writeValueAsString(object);
        return reqJson;
    }

    @Test
    public void test() {
        String reductionType = "4,5,10,11,4-,5-,10-,11-";
        String giftItemName = "4-10";
        if (giftItemName.length() > 1) {
            giftItemName = giftItemName.substring(0, 2);
        }
        log.debug("giftItemName:{}", giftItemName);
        if (reductionType.contains(giftItemName)) {
            log.debug("contains:{}",giftItemName);
        }
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>(0);
        map.put("1", "1");
        handleMap(map);
        log.debug("map:{}", map);
    }

    private void handleMap(Map<String, String> map) {
        map.put("1", "2");
    }
}
