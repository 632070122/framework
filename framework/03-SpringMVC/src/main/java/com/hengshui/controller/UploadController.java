package com.hengshui.controller;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/com/hengshui/upload")
public class UploadController {

    @RequestMapping("/traditionUpload")
    public String tradition(HttpServletRequest request) throws Exception {
        System.out.println("文件上传开始......");
        //使用FileUpload组件完成上传
        //设置上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在,并创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        //创建磁盘文件项工厂,用于创建文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request,获取文件项
        List<FileItem> items = upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //进行判断,当前文件项,是否是上传文件项
            if (item.isFormField()) {
                //普通表单项目
            } else {
                //上传文件项目
                //获取上传文件的名称
                String fileName = item.getName();

                //把文件的名字设置成唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;

                //完成文件上传
                item.write(new File(path, fileName));
                //删除临时文件
                item.delete();
            }
        }
        System.out.println("上传成功!!!");
        return "success";
    }

    @RequestMapping("/springMVCUpload")
    public String springMVCUpload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传开始......");
        //使用FileUpload组件完成上传
        //设置上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在,并创建
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        //获取文件的名字
        String fileName = upload.getOriginalFilename();


        //把文件的名字设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;


        //完成文件上传
        upload.transferTo(new File(path, fileName));

        System.out.println("上传成功!!!");
        return "success";
    }

    @RequestMapping("/servletFileUpload")
    public String servletFileUpload(MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传开始......");

        //定义文件上传的服务器的路径
        String path = "http://localhost:8080/uploads/";


        //获取文件的名字
        String fileName = upload.getOriginalFilename();
        //把文件的名字设置成唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "_" + fileName;

        //完成跨越服务器文件上传
        //创建客户端对象
        Client client = Client.create();

        //和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);

        //调用方法,上传文件
        webResource.put(upload.getBytes());

        System.out.println("上传成功!!!");
        return "success";
    }
}
