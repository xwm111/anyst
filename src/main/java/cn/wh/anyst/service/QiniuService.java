package cn.wh.anyst.service;

import java.io.InputStream;
import java.util.UUID;

import org.json.JSONException;
import org.springframework.stereotype.Component;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

/*
 * 七牛云服务Service
 */
@Component
public class QiniuService {
	public QiniuService() {
		Config.ACCESS_KEY = "e7x-C6YOsTscrNTXNoWhfHB9CMaamQDzThMy8R77";
		Config.SECRET_KEY = "aGM3C2EOBXc77Ds2byK830KTzaxlNixezsZAskzi";
	}
	
	public String uploadFile(String bucketName, String fileName) throws AuthException, JSONException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(bucketName);
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		
		String key = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		System.out.println(key);
		PutRet ret = IoApi.putFile(uptoken, key, fileName, extra);
		if (ret.getStatusCode() == 200) {
			return ret.getKey();
		} else {
			return null;
		}
	}
	
	public String uploadFile(String bucketName, InputStream fis) throws AuthException, JSONException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(bucketName);
		String uptoken = putPolicy.token(mac);
		PutExtra extra = new PutExtra();
		
		String key = UUID.randomUUID().toString().replace("-", "").toUpperCase();
		System.out.println(key);
		PutRet ret = IoApi.Put(uptoken, key, fis, extra);
		if (ret.getStatusCode() == 200) {
			return ret.getKey();
		} else {
			return null;
		}
	}
}
