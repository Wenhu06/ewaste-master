package com.group.ewaste.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.ewaste.config.RuoYiConfig;
import com.group.ewaste.config.ServerConfig;
import com.group.ewaste.domain.AjaxResult;
import com.group.ewaste.domain.File;
import com.group.ewaste.domain.User;
import com.group.ewaste.mapper.UserMapper;
import com.group.ewaste.service.FileService;
import com.group.ewaste.service.UserService;
import com.group.ewaste.util.StringUtils;
import com.group.ewaste.util.file.FileUploadUtils;
import com.group.ewaste.util.file.FileUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/common")
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);
    @Autowired
    private FileService fileService;
    @Autowired
   private UserMapper userMapper;

    @Autowired
    private ServerConfig serverConfig;

    private static final String FILE_DELIMETER = ",";

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.checkAllowDownload(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "file", name = "file", value = "", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "username", value = "", required = false),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "email", value = "", required = false)
    })
    @ApiOperation(value = "文件上传", notes = "文件上传", httpMethod = "POST")
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file,@RequestParam(required = false) String username) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = "C:/Users/Administrator/Desktop/upload"+"/upload";
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
            ajax.put("originalFilename", file.getOriginalFilename());
            File file1=new File();
            file1.setName(file.getOriginalFilename());
            file1.setCreateTime(new Date());
            if(username!=null){
                User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));
                file1.setCreateBy(username);
                file1.setEmail(user.getEmail());
            }
            file1.setUrl(url);
            file1.setPath(filePath+"/"+fileName.replace("/profile/upload/",""));
            fileService.save(file1);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

}
