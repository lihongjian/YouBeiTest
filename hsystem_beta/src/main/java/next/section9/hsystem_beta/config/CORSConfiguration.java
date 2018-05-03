package next.section9.hsystem_beta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CORSConfiguration {

    private CorsConfiguration buildConfig() {

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 在添加  corsConfiguration.setAllowCredentials(true) 的时候 使用addAllowedOrigin("http://192.168.43.198:8081")
        // 可以取得原域的cookie 可以对原域和跨过来的域进行统一的session管理
        // 但是addAllowedOrigin("http://localhost:8081") 则不行
        corsConfiguration.addAllowedOrigin("http://192.168.43.198:8081"); // 1 设置访问源地址
        corsConfiguration.addAllowedOrigin("http://192.168.43.198:8083"); //

         /*   corsConfiguration.addAllowedOrigin("*");*/ //设置获取所有的origin 但是不能获取cookie
         //  设置可以获取的前台自定义的header
         // 当前台定义自定义的header时，前台的cors请求会变为非简单模式 : 先发送一个option的请求预检，通过之后
         //  才真正的调用
        corsConfiguration.addAllowedHeader("myheader"); // 2 设置访问源请求头
        corsConfiguration.addAllowedHeader("myheader1"); // 2 设置访问源请求头


        corsConfiguration.addAllowedMethod("POST"); // 3 设置访问源请求方法
        //此处添加是否cookie
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //此处配置可以访问的路径
        source.registerCorsConfiguration("/hello/*", buildConfig()); // 4 对接口配置跨域设置
        return new CorsFilter(source);
    }

}
