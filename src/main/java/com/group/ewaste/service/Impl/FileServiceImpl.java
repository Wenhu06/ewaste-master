package com.group.ewaste.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.ewaste.domain.File;
import com.group.ewaste.mapper.FileMapper;
import com.group.ewaste.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {
}
