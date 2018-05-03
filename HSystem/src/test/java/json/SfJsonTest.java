package json;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SfJsonTest {
    @Test
    public void jsonTest(){

        String test =
                "{\"name\":\"hongjian\",\"type\":\"table\",\"key\":{\"name\":\"id\",\"type\":\"varchar\"},\"fields\":[{\"name\":\"name\",\"type\":\"varchar\"},{\"name\":\"sex\",\"type\":\"varchar\"}]}";

        TableTestVo a = com.alibaba.fastjson.JSONObject.parseObject(test,TableTestVo.class);

        System.out.println(a.getName());

        JsonConfig jc = new JsonConfig();
     /*   JsonValueProcessor jvp = new JsonValueProcessor(){
            @Override
            public Object processArrayValue(Object o, JsonConfig jsonConfig) {
                System.out.println("aaaa");
                return null;
            }
            @Override
            public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
                System.out.println("bbbb");
                return null;
            }
        };*/
/*
        jc.registerJsonValueProcessor(List.class,jvp);
*/
        Map m = new HashMap();
        m.put("fields",TableFieldTestVo.class);
        jc.setClassMap(m);
        net.sf.json.JSONObject jo = net.sf.json.JSONObject.fromObject(test);
        TableTestVo b = new TableTestVo();
        net.sf.json.JSONObject.toBean(jo,b,jc);
        System.out.println(b.getName());
    }

    @Test
    public void beanTest(){
        TableTestVo a =  new TableTestVo();
        doSm(a);
        System.out.println(a.name);
    }

    private void doSm(TableTestVo a) {
        a = new TableTestVo();
        a.setName("tssss");
    }

}
