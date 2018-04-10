package others.scan_port;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetAllIp {

	public List<String> getAllIp() {
		List<String> ips = GetLocalIp.getIps();

		InputStream is = null;
		BufferedReader br = null;
		
		List<String> ipList = new ArrayList<String>();

		for(int i = 0;i < ips.size();i++){			

			String cmd = "nmap -sn -PE -n --min-hostgroup 1024 --min-parallelism 1024 -oX ips/AllIp.xml " + ips.get(i) + "/24";
			//System.out.println(cmd);
			try {

				//long t = System.currentTimeMillis();
				Process pro = Runtime.getRuntime().exec(cmd);
				pro.waitFor();
				//System.out.println(System.currentTimeMillis() - t + "ms");
				
				is = pro.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));

				String result = null;

				while ((result = br.readLine()) != null) {

					if (result.contains("Nmap scan report for ")) {
						ipList.add(result.substring("Nmap scan report for ".length()));
					}
					
				}

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				try {
					if (is != null)
						is.close();
					if (br != null)
						br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ipList;
	}

	public static void main(String[] args) {
		List<String> ipList = new GetAllIp().getAllIp();
		System.out.println(ipList.size());
		int i =0 ;
		for (String string : ipList) {
			System.out.println(string+"---"+i);
			i++;
		}
	}

}
