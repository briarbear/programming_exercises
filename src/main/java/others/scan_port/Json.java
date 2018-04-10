package others.scan_port;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Json {
	public boolean isConnect(String url) {
		int status = 404;
		int jsonFlag = 0;
		try {
			URL urlObject = new URL(url);
			HttpURLConnection huc = (HttpURLConnection) urlObject.openConnection();
			huc.setUseCaches(false);
			huc.setConnectTimeout(1000);
			huc.setReadTimeout(1000);
			status = huc.getResponseCode();
			if (status != 200) {
				return false;
			}
			Map headers = huc.getHeaderFields();
			Set<String> keys = headers.keySet();
			for (String key : keys) {
				String val = huc.getHeaderField(key);
				if (val.contains("json")) {
					jsonFlag = 1;
					//break;
				}
				//System.out.println(key + " ++++++++++++++++++++++" + val);
			}
			//System.out.println(jsonFlag + "*************************");
			//System.out.println(huc.getLastModified() + "-------------");
			// System.out.println(status);
		} catch (MalformedURLException e) {
			// e.printStackTrace();
			return false;
		} catch (IOException e) {
			return false;
			// e.printStackTrace();
		}
		if (jsonFlag == 0) {
			return false;
		}
		return true;
	}

	public String loadJson(String url) {
		StringBuilder json = new StringBuilder();
		try {
			URL urlObject = new URL(url);
			URLConnection uc = urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
			String line = null;
			while ((line = in.readLine()) != null) {
				json.append(line);
				System.out.println(line);
			}
			in.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json.toString();
	}

	
	public void parseJson(String jsonString) {
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(jsonString);
			
			//JSONArray fileStatuses = jsonObject.getJSONArray("FileStatuses");
			
			String fileStatuses = jsonObject.getString("FileStatuses");
			//System.out.println(fileStatuses);
			jsonObject = new JSONObject(fileStatuses);
			JSONArray fileStatusArray = jsonObject.getJSONArray("FileStatus");
			
			List<FileStatus> fileStatusList = new ArrayList<FileStatus>();
			
			//System.out.println(fileStatusArray.length());
			System.out.println("-------------------------------------");
			for (int i = 0; i < fileStatusArray.length(); i++) {
				FileStatus file = new FileStatus();
				JSONObject fileStatus = fileStatusArray.getJSONObject(i);

				file.setAccessTime(fileStatus.getInt("accessTime"));
				file.setBlockSize(fileStatus.getInt("blockSize")); //块大小
				file.setChildrenNum(fileStatus.getInt("childrenNum")); //
				file.setFileId(fileStatus.getInt("fileId"));
				file.setGroup(fileStatus.getString("group"));
				file.setLength(fileStatus.getInt("length"));
				file.setModificationTime(fileStatus.getString("modificationTime"));
				file.setOwner(fileStatus.getString("owner"));
				file.setPathSuffix(fileStatus.getString("pathSuffix"));
				file.setPermission(fileStatus.getString("permission"));
				file.setReplication(fileStatus.getInt("replication"));
				file.setStoragePolicy(fileStatus.getInt("storagePolicy"));
				file.setType(fileStatus.getString("type"));
				
				fileStatusList.add(file);
			}
			for (int i = 0; i < fileStatusList.size(); i++) {
				System.out.println(fileStatusList.get(i).toString());
				System.out.println("-------------------------------------");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://10.0.0.208:5000/webhdfs/v1/?op=LISTSTATUS";
		Json json = new Json();

		if (json.isConnect(url)) {
			System.out.println(new Json().loadJson(url));
		} else
			System.out.println("opopopo");

		String url1 = "http://10.0.0.117:8804/webhdfs/v1/?op=LISTSTATUS";
		if (json.isConnect(url1)) {
			System.out.println(new Json().loadJson(url1));
		} else
			System.out.println("opopopo");

	}

}
