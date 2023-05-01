//package com.group.ewaste.util.file;
//
//import cn.hutool.core.io.FileTypeUtil;
//import com.group.ewaste.util.file.model.FileDto;
//import com.xiexin.common.enums.ExceptionCode;
//import com.xiexin.common.exception.BaseException;
//import com.xiexin.common.utils.file.model.FileDto;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.IOUtils;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletRequest;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//@Slf4j
//public class MyFileUploadUtils {
//  static final int wdDoNotSaveChanges = 0;// 不保存待定的更改。
//  static final int wdFormatPDF = 17;// PDF 格式
//  static final int ppSaveAsPDF = 32;// ppt 转PDF 格式
//  static final String line = File.separator;
//  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // 时间格式化对象，用于创建当日文件夹名称
//
//  public static FileDto save(MultipartFile file) throws Exception {
//    //判断文件是否为空
//    if (file.isEmpty()) {
//      throw new RuntimeException("文件不能为空");
//    }
//    // 获取文件名
//    String fileName = file.getOriginalFilename();
//    fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
//    System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: " + fileName + "\n");
//    //获取服务器webapp下的相对路径
////    String line = File.separator;
//    ServletRequestAttributes aRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//    HttpServletRequest request = aRequestAttributes == null ? null : aRequestAttributes.getRequest();
//    String path;
//    String urlDemo;
//    File _file = multipartFileToFile(file);
//    Date now = new Date();
//    //判断文件类型
//    if (isImage(_file)) {//是否为图片
//      path = "C:\\file\\image\\" +sdf.format(now)+"\\" +fileName.replace(line, "/");
//      urlDemo = request.getScheme() + "://" + (request.getServerName().equals("888")?"111.231.134.120":request.getServerName()) + ":" + request.getServerPort() + "/edu-image/"+sdf.format(now)+"/"+fileName;
//
//    } else if (isVideo(_file)) {//是否为视频
//      path = "C:\\file\\image\\" +sdf.format(now)+"\\"+ fileName;
//      urlDemo = request.getScheme() + "://" + (request.getServerName().equals("888")?"111.231.134.120":request.getServerName()) + ":" + request.getServerPort() + "/edu-video/"+sdf.format(now)+"/"+fileName;
//    } else {//office文件
//      path = "C:\\file\\image\\" +sdf.format(now)+"\\"+ fileName;
//      urlDemo = request.getScheme() + "://" + (request.getServerName().equals("888")?"111.231.134.120":request.getServerName()) + ":" + request.getServerPort() + "/edu-file/"+sdf.format(now)+"/"+fileName;
//    }
//    //文件绝对路径
//    System.out.print("保存文件绝对路径" + path + "\n");
//    //创建文件路径
//    File dest = new File(path);
//    //判断文件父目录是否存在
//    if (!dest.getParentFile().exists()) {
//      dest.getParentFile().mkdirs();
//    }
//    FileDto fileDto = new FileDto();
//    //上传文件
//    if(isImage(_file)&&file.getSize()>1024*1024*3){
//      System.out.println("--------------------------这张图片是超过3m的------------------------------");
//      PicUtils.compressPicForScale(file.getBytes(),3071L);
//      IOUtils.write(PicUtils.compressPicForScale(file.getBytes(),3071L), new FileOutputStream(new File(path)));
//    }else {
//      file.transferTo(dest); //保存文件
//    }
//    delteTempFile(_file);
//    String url = urlDemo;
//    fileDto.setPath(path);
//    fileDto.setUrl(url);
//    return fileDto;
//  }
//  /**
//   * 判断是否为图片
//   *
//   * @param file
//   * @return
//   */
//  public static final boolean isImage(File file) {
//    boolean flag = false;
//    try {
//      BufferedImage bufreader = ImageIO.read(file);
//      int width = bufreader.getWidth();
//      int height = bufreader.getHeight();
//      if (width == 0 || height == 0) {
//        flag = false;
//      } else {
//        flag = true;
//      }
//    } catch (IOException e) {
//      flag = false;
//    } catch (Exception e) {
//      flag = false;
//    }
//    return flag;
//  }
//
//  /**
//   * 判断是不是视频 （mp4、avi）
//   *
//   * @param file
//   * @return
//   */
//  public static boolean isVideo(File file) {
//    File _file = cn.hutool.core.io.FileUtil.file(file);
//    String type = FileTypeUtil.getType(_file);
//    if ("mp4".equals(type) || "avi".equals(type)) {
//      return true;
//    }
//    return false;
//  }
//
//  public static boolean del(String path) {
//    return cn.hutool.core.io.FileUtil.del(path);
//  }
//
//
//  public static File multipartFileToFile(MultipartFile file) throws Exception {
//
//    File toFile = null;
//    if (file.equals("") || file.getSize() <= 0) {
//      file = null;
//    } else {
//      InputStream ins = null;
//      ins = file.getInputStream();
//      toFile = new File(file.getOriginalFilename());
//      inputStreamToFile(ins, toFile);
//      ins.close();
//    }
//    return toFile;
//  }
//
//  public static void delteTempFile(File file) {
//    if (file != null) {
//      File del = new File(file.toURI());
//      del.delete();
//    }
//  }
//
//  //获取流文件
//  private static void inputStreamToFile(InputStream ins, File file) {
//    try {
//      OutputStream os = new FileOutputStream(file);
//      int bytesRead = 0;
//      byte[] buffer = new byte[8192];
//      while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
//        os.write(buffer, 0, bytesRead);
//      }
//      os.close();
//      ins.close();
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
//
//  public static void getFile(byte[] bfile, String filePath,String fileName) {
//    BufferedOutputStream bos = null;
//    FileOutputStream fos = null;
//    File file = null;
//    try {
//      File dir = new File(filePath);
//      if(!dir.exists()&&dir.isDirectory()){//判断文件目录是否存在
//        dir.mkdirs();
//      }
//      file = new File(filePath+"\\"+fileName);
//      fos = new FileOutputStream(file);
//      bos = new BufferedOutputStream(fos);
//      bos.write(bfile);
//    } catch (Exception e) {
//      e.printStackTrace();
//    } finally {
//      if (bos != null) {
//        try {
//          bos.close();
//        } catch (IOException e1) {
//          e1.printStackTrace();
//        }
//      }
//      if (fos != null) {
//        try {
//          fos.close();
//        } catch (IOException e1) {
//          e1.printStackTrace();
//        }
//      }
//    }
//  }
//}
