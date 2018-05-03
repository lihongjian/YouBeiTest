package person.li.vo.httpclient;

import java.util.List;

public class HttpClientVo {

    String name;

    String code;

    List<HttpClientChildVo> httpClientChildVos;

    HttpClientChildVo theHttpClientChildVo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<HttpClientChildVo> getHttpClientChildVos() {
        return httpClientChildVos;
    }

    public void setHttpClientChildVos(List<HttpClientChildVo> httpClientChildVos) {
        this.httpClientChildVos = httpClientChildVos;
    }

    public HttpClientChildVo getTheHttpClientChildVo() {
        return theHttpClientChildVo;
    }

    public void setTheHttpClientChildVo(HttpClientChildVo theHttpClientChildVo) {
        this.theHttpClientChildVo = theHttpClientChildVo;
    }
}
