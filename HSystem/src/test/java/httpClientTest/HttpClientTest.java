package httpClientTest;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import person.li.vo.httpclient.HttpClientChildVo;
import person.li.vo.httpclient.HttpClientVo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTest {

    @Test
    public void httpClientParamTestClient() throws IOException {

        HttpClientVo hc = new HttpClientVo();
        HttpClientChildVo hcchild = new HttpClientChildVo();
        hc.setName("hc name1 ");
        hc.setCode("hc code1 ");
        hcchild.setCode("hcchild code1");
        hcchild.setName("hcchild name1");
        List<HttpClientChildVo> hcchildvos = new ArrayList<HttpClientChildVo>();
        hc.setHttpClientChildVos(hcchildvos);
        HttpClientChildVo hcchild1 = new HttpClientChildVo();
        hcchild1.setName("hc hcchild name1 ");
        hcchild1.setCode("hc hcchild code1 ");

        hcchildvos.add(hcchild1);

        String param = JSON.toJSONString(hc);

        CloseableHttpClient chc = HttpClients.createDefault();
        String url = "http://localhost:8080/httpClientParamTest";
        HttpPost hp = new HttpPost(url);
        hp.addHeader("Content-type","application/json;charset=utf-8");
        hp.setHeader("Accept","application/json");
        hp.setEntity(new StringEntity(param, Charset.forName("UTF-8")));
        chc.execute(hp);

    }

    @Test
    public void httpClientParamTestClient2() throws IOException {

        HttpClientVo hc = new HttpClientVo();
        HttpClientChildVo hcchild = new HttpClientChildVo();
        hc.setName("hc name1 ");
        hc.setCode("hc code1 ");
        hcchild.setCode("hcchild code1");
        hcchild.setName("hcchild name1");
        List<HttpClientChildVo> hcchildvos = new ArrayList<HttpClientChildVo>();
        hc.setHttpClientChildVos(hcchildvos);
        HttpClientChildVo hcchild1 = new HttpClientChildVo();
        hcchild1.setName("hc hcchild name1 ");
        hcchild1.setCode("hc hcchild code1 ");
        hcchildvos.add(hcchild1);
        String param = "{\"hc\":" + JSON.toJSONString(hc) + ",\"hcchild\":" + JSON.toJSONString(hcchild) + "}";
        CloseableHttpClient chc = HttpClients.createDefault();
        String url = "http://localhost:8080/httpClientParamTest2";
        HttpPost hp = new HttpPost(url);
        hp.addHeader("Content-type","application/json;charset=utf-8");
        hp.setHeader("Accept","application/json");
        hp.setEntity(new StringEntity(param, Charset.forName("UTF-8")));
        CloseableHttpResponse hr = chc.execute(hp);
        if(hr.getStatusLine().equals(HttpStatus.SC_OK)){
            HttpEntity he = hr.getEntity();
        }
    }



    @Test
    public void httpClientReturnTest() throws IOException {
        String abc = "";
        String url = "http://localhost:8080/httpClientReturnTest";
        CloseableHttpClient chc = HttpClients.createDefault();
        HttpPost hp = new HttpPost(url);
        String param = "{\"abc\":\"qqqweq\"}";
        hp.addHeader("Content-type","application/json;charset=utf-8");
        hp.setHeader("Accept","application/json");
        hp.setEntity(new StringEntity(param, Charset.forName("UTF-8")));
        CloseableHttpResponse hr = chc.execute(hp);
        if(hr.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            HttpEntity he = hr.getEntity();
            String result = EntityUtils.toString(he);
            HttpClientVo hc = JSON.parseObject(result,HttpClientVo.class);
            System.out.println(hc.getName());
        }
    }
}
