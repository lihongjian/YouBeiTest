package person.li.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller
public class DownloadAndUploadController {


    @RequestMapping(value = "/download")
    public String download(){
        return "/downloadAndUpload/download";
    }


    @RequestMapping(value = "/upload")
    public String upload(){
        return "/downloadAndUpload/upload";
    }


    @RequestMapping(value="/downLoadZip")
    @ResponseBody
    public String downLoadZip(String id) throws IOException {
        Map result = new HashMap();

 /*       String data = "what";
        String filename = "dotest.txt";
        byte[] zippedbytes = zipFile(data,filename);
*/
        File zipFile = new File("E:/1/test.zip");
        FileInputStream fi = new FileInputStream(zipFile);

        byte[] bytes =  IOUtils.toByteArray(fi);
//        Base64.encodeBase64URLSafeString(zippedbytes);
        String jsonString =  Base64.encodeBase64String(bytes);

        result.put("data",jsonString);

        String json = JSON.toJSONString(result);
        return json;
    }

    /**
     * 使用流的方式下载文件  安全 稳妥
     * @param request
     * @param response
     */
    @RequestMapping(value="/downLoadFileStream")
    public void downLoadFileStream(HttpServletRequest request, HttpServletResponse response){
        //根据文件名获取 MIME 类型
        ServletContext servletContext = request.getSession().getServletContext();

//        String realPath = servletContext.getRealPath("/image/download/water1.jpg");
        String realPath = servletContext.getRealPath("/image/download/摔跤吧！爸爸.mkv");

        File file = new File(realPath);
        String contentType = servletContext.getMimeType(file.getName());
        String contentDisposition = "attachment;filename=" + file.getName();
        // 设置头
        response.setHeader("Content-Type",contentType);
        response.setHeader("Content-Disposition",contentDisposition);
        try(OutputStream os  = response.getOutputStream();
            InputStream io = new FileInputStream(file)) {
            IOUtils.copy(io,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/downloadTest")
    @ResponseBody
    public String downloadTest(String id) throws UnsupportedEncodingException {

        String abc = "测试js atob方法的字符集";
        String bcd = "123abc";
        System.out.println(Charset.defaultCharset());
        String abcbase64  =  Base64.encodeBase64String(abc.getBytes());
        showBytes(abc.getBytes());
        String abcbase64utf16  =  Base64.encodeBase64String(abc.getBytes("utf16"));
        showBytes(abc.getBytes("utf16"));
        String abcbase64utf8  =  Base64.encodeBase64String(abc.getBytes("utf8"));
        showBytes(abc.getBytes("utf8"));

        String bcdbase64  =  Base64.encodeBase64String(bcd.getBytes());
        showBytes(bcd.getBytes());

        String bcdbase64utf16  =  Base64.encodeBase64String(bcd.getBytes("utf16"));
        showBytes(bcd.getBytes("utf16"));

        String bcdbase64utf8  =  Base64.encodeBase64String(bcd.getBytes("utf8"));
        showBytes(bcd.getBytes("utf8"));


        Map map = new HashMap();
        map.put("abcbase64",abcbase64);
        map.put("abcbase64utf16",abcbase64utf16);
        map.put("abcbase64utf8",abcbase64utf8);

        map.put("bcdbase64",bcdbase64);
        map.put("bcdbase64utf16",bcdbase64utf16);
        map.put("bcdbase64utf8",bcdbase64utf8);

        String json = JSON.toJSONString(map);
        return json;
    }

    public void showBytes(byte[] bytes){
        System.out.println("");
        for(int i = 0 ; i < bytes.length ; i ++ ){
            System.out.print(bytes[i] + " ");
        }
    }

    private byte[] zipFile(String data,String filename) {
        byte[] result = null;
        ByteArrayOutputStream baos = null;
        ByteArrayInputStream bais = null;
        ZipOutputStream zos = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        try {
         baos = new ByteArrayOutputStream();
         bais = new ByteArrayInputStream(data.getBytes());
         zos = new ZipOutputStream(baos);
         bos = new BufferedOutputStream(zos);
         bis = new BufferedInputStream(bais);

            zos.putNextEntry(new ZipEntry(filename));
            byte[] b = new byte[1024];
            int i = 0 ;
            while((i = bis.read(b)) != -1){
                bos.write(b,0,i);
                bos.flush();
            }
            result = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(zos!=null){
                try {
                    zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bais!=null){
                try {
                    bais.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 使用流的方式上传文件
     * @param uploadFile
     */
    @RequestMapping(value="/uploadFile")
    @ResponseBody
    public void uploadFile(MultipartFile uploadFile){
        String filename = uploadFile.getOriginalFilename();
        File newFile = new File("e:/1/" + filename);
        try {
            uploadFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping(value="/uploadFileStream")
    @ResponseBody
    public void uploadFileStream(HttpServletRequest request, HttpServletResponse response){

    }
    /**
     * 使用servlet3 part的方式上传文件
     * 暂时不能使用 spring的配置问题 详查spring的reference
     * @param request
     * @param response
     */
    @RequestMapping(value="/uploadFilePart")
    @ResponseBody
    public void uploadFilePart(HttpServletRequest request, HttpServletResponse response){
        Part part = null;
        try {
            part = request.getPart("uploadFile");
            String fileName = getFileName(part);
            System.out.println(fileName + "*****************");
            writeTo(fileName, part);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        //String uploadPath = request.getServletContext().getRealPath("/upload");
    }

    /**
     *  分块上传
     *  上传来的块和file是一样的
     *
     */
    @RequestMapping(value="/uploadChunk")
    @ResponseBody
    public void uploadChunk(MultipartFile uploadFile){
        String filename = uploadFile.getOriginalFilename();
        File newFile = new File("e:/1/" + filename);

    }


    private String getFileName(Part part) {
        String header = part.getHeader("Content-Disposition");
        String fileName = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));
        return fileName;
    }

    private void writeTo(String fileName, Part part) throws FileNotFoundException, IOException {
        String uploadPath = "e:/1/";
/*
        part.write(uploadPath + File.separator + fileName);
*/
         InputStream in = part.getInputStream();
         OutputStream out = new FileOutputStream(uploadPath + fileName);
         byte[] buffer = new byte[2048];
         int length = -1;
         while ((length = in.read(buffer)) != -1) {
         out.write(buffer, 0, length);
         }
         in.close();
         out.close();
    }






}
