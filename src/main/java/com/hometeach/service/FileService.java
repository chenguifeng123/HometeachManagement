package com.hometeach.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hometeach.util.Utils;
/*
 
 */
@RestController
public class FileService {
	
	@Value("${web.upload-path}")
	public String currentPath;

    private String getPath(){
        //return FileService.class.getResource("/").getPath();
    	return currentPath;
    }

    // 
    @RequestMapping(value = "/uploadPicture/{columnName}", method = RequestMethod.POST)
    public Map<String, String> uploadPicture(@RequestParam("file") MultipartFile file,@PathVariable("columnName") String columnName){
        Map<String, String> result = new HashMap<String, String>();
        result.put("field", columnName);
        if(!file.isEmpty()){
            try {
                String localPath = getPath();//String.format("%sstatic", getPath());
                String fileName = String.format("/img/%d_%s", System.currentTimeMillis(), file.getOriginalFilename());
                Utils.writeByteArrayToFile(localPath + fileName, file.getBytes());
                result.put("url", fileName);
            }catch(IOException e){
                result.put("url", "");
                e.printStackTrace();
            }
        }
        return result;
    }
}
