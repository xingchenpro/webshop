package com.nb.shopping.controller;

import com.nb.shopping.util.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :http://www.javahly.com/
 * @CSDN :blog.csdn.net/Sirius_hly
 * @date :2019/1/11
 */
@RestController
@RequestMapping("/")
public class fileUploadController {

    //上传图片
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Result uploadAfter(@Param("file") MultipartFile file, HttpServletRequest request) {
        Result result = new Result();

        //String rootPath = "D:/shopping/";
        //根目录
        String rootPath = request.getSession().getServletContext().getRealPath("/resources/fileUpload/");
        System.err.println("rootPath:" + rootPath);
        //文件完整名称，.jpg等
        String fileName = file.getOriginalFilename();
        System.err.println("fileName:" + fileName);
        //文件名，不包括后缀
        String nameWithoutSuffix = fileName.substring(0, fileName.indexOf("."));
        System.err.println("nameWithoutSuffix:" + nameWithoutSuffix);
        //文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.err.println("suffixName" + suffixName);
        //按年月存放
        //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
        Calendar date = Calendar.getInstance();
        //个值的初始值是0，因此我们要用它来表示正确的月份时就需要加1。
        File dataFile = new File(date.get(Calendar.YEAR) + File.separator + (date.get(Calendar.MONTH) + 1));

        File newFile = new File(rootPath + File.separator + dataFile + File.separator + fileName);
        System.err.println("/resources/fileUpload/"+dataFile+ File.separator + fileName);
        //文件存在就重命名
        int i = 0;
        String newFileName = fileName;
        while (newFile.exists()) {
            newFileName = nameWithoutSuffix + "(" + i + ")" + suffixName;
            String parentPath = newFile.getParent();
            newFile = new File(parentPath + File.separator + newFileName);
            i++;
        }
        //目录是否存在
        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
            String url = rootPath + "/" + dataFile + "/" + newFile;
        }
        System.err.println("图片上传地址："+"/resources/fileUpload/"+dataFile+ File.separator + fileName);
        try {
            file.transferTo(newFile);
        } catch (IOException e) {
            result.setBusErrInfos("文件上传失败");
            e.printStackTrace();
        }
        return result;
    }

    //得到图片//http://localhost/getImage?imageUrl=/resources/fileUpload/2019/1/化妆品1.jpg
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    public void getMapPic1(@RequestParam(value = "imageUrl", required = false) String imageUrl, HttpServletRequest request, HttpServletResponse httpResponse) {
        String filePath = request.getSession().getServletContext().getRealPath(imageUrl);
        System.out.println("filePath:"+filePath);
        File file = new File(filePath);
        FileInputStream fis = null;
        try {
            httpResponse.setContentType("image/jpg");
            OutputStream out = httpResponse.getOutputStream();
            fis = new FileInputStream(file);
            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
